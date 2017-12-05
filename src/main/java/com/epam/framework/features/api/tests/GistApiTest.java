package com.epam.framework.features.api.tests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.epam.framework.features.api.services.HTTPServices.*;
import static org.testng.Assert.assertEquals;

public class GistApiTest {

    private static final int STATUS_CODE_CREATED = 201;
    private static final int STATUS_CODE_NO_CONTENT = 204;
    private static final int STATUS_CODE_OK = 200;
    private static final String URI = "https://api.github.com/";
    private static final String PATH_TO_GIST_CREATE_JSON = "src/main/resources/json/gist_create.json";
    private static final String PATH_TO_GIST_UPDATE_JSON = "src/main/resources/json/gist_update.json";
    private static final String ACCESS_TOKEN = "df3b0194279fceab6df56ce74ea3c3237d0704cd";
    private static final String GIST_ID = "05de8017b3292c8504314fb6bd19ace7";
    private static final String URI_POST_REQUEST = URI + "gists?access_token=" + ACCESS_TOKEN;
    private static final String URI_PATCH_REQUEST = URI + "/gists/" + GIST_ID + "?access_token=" + ACCESS_TOKEN;

    @Test(description = "This TC check Create a gist")
    public void checkPostRequest() {
        CloseableHttpResponse response = post(URI_POST_REQUEST, PATH_TO_GIST_CREATE_JSON);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_CREATED);
    }

    @Test(description = "This TC check Star a gist")
    public void checkPutRequest() {
        CloseableHttpResponse response = put(URI + "/gists/" + GIST_ID + "/star?access_token=" + ACCESS_TOKEN);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_NO_CONTENT);
    }

    @Test(description = "This TC check Unstar a gist")
    public void checkDeleteRequest() {
        CloseableHttpResponse response = delete(URI + "/gists/" + GIST_ID + "/star?access_token=" + ACCESS_TOKEN);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_NO_CONTENT);
    }

    @Test(description = "This TC check Edit a gist")
    public void checkEditRequest() throws IOException {
        CloseableHttpResponse response = patch(URI_PATCH_REQUEST, PATH_TO_GIST_UPDATE_JSON);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, STATUS_CODE_OK);
    }
}