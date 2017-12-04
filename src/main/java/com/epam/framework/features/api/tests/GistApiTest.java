package com.epam.framework.features.api.tests;

import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class GistApiTest {
    private static final String ACCESS_TOKEN = "df3b0194279fceab6df56ce74ea3c3237d0704cd";
    private static final String GIST_ID = "05de8017b3292c8504314fb6bd19ace7";
    private static final String URI = "https://api.github.com/";
    private static final int STATUS_CODE_CREATED = 201;
    private static final int STATUS_CODE_NO_CONTENT = 204;
    private static final int STATUS_CODE_OK = 200;
    private static final String JSON_STRING_CREATE = "   {\n" +
            "            \"description\": \"the description for this gist\",\n" +
            "                \"public\": true,\n" +
            "                \"files\": {\n" +
            "            \"file1.txt\": {\n" +
            "                \"content\": \"String file contents\"\n" +
            "            }\n" +
            "        }\n" +
            "        }";
    private static final String JSON_STRING_UPDATE = "   {\n" +
            "            \"description\": \"the description for this gist\",\n" +
            "                \"public\": true,\n" +
            "                \"files\": {\n" +
            "            \"file1.txt\": {\n" +
            "                \"content\": \"updated file content\"\n" +
            "            }\n" +
            "        }\n" +
            "        }";



    @Test(description = "This TC check to Create a gist")
    public void checkPostRequest() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post = new HttpPost(URI + "gists?access_token=" + ACCESS_TOKEN);
        StringEntity requestEntity = new StringEntity(
                JSON_STRING_CREATE,
                ContentType.APPLICATION_JSON);
        post.setEntity(requestEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_CREATED);
    }


    @Test(description = "This TC check to Star a gist")
    public void checkPutRequest() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut put = new HttpPut(URI + "/gists/" + GIST_ID + "/star?access_token=" + ACCESS_TOKEN);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_NO_CONTENT);
    }

    @Test(description = "This TC check to Unstar a gist")
    public void checkDeleteRequest() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(URI + "/gists/" + GIST_ID + "/star?access_token=" + ACCESS_TOKEN);
        CloseableHttpResponse response = httpclient.execute(delete);
        try {
            response = httpclient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_NO_CONTENT);
    }


    @Test(description = "This TC check to edit a gist")
    public void checkEditRequest() throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPatch patch = new HttpPatch(URI + "/gists/" + GIST_ID + "?access_token=" + ACCESS_TOKEN);
        StringEntity entity = new StringEntity(
            JSON_STRING_UPDATE,
            ContentType.APPLICATION_JSON);
        patch.setEntity(entity);
        CloseableHttpResponse response = httpclient.execute(patch);
        try {
            response = httpclient.execute(patch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_OK);
    }
}
