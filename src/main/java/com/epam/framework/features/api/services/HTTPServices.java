package com.epam.framework.features.api.services;

import org.apache.http.client.methods.*;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

import static com.epam.framework.core.utils.FileUtils.getGsonString;

public class HTTPServices {

    public static CloseableHttpResponse put(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPut put =  new HttpPut(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(put);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static CloseableHttpResponse delete(String url){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpDelete delete =  new HttpDelete(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static CloseableHttpResponse post(String url, String pathToJson){
        String json = getGsonString(pathToJson);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost post =  new HttpPost(url);
        StringEntity requestEntity = new StringEntity(
                json,
                ContentType.APPLICATION_JSON);
        post.setEntity(requestEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static CloseableHttpResponse patch(String url, String pathToJson){
        String json = getGsonString(pathToJson);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPatch patch = new HttpPatch(url);
        StringEntity requestEntity = new StringEntity(
                json,
                ContentType.APPLICATION_JSON);
        patch.setEntity(requestEntity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(patch);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
