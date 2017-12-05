package com.epam.framework.features.api.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.epam.framework.features.api.services.HTTPServices.*;
import static org.testng.Assert.assertEquals;

public class GistApiTest {

    private static final String URI = "https://api.github.com/";
    private static final String PATH_TO_GIST_CREATE_JSON = "src/main/resources/json/gist_create.json";
    private static final String PATH_TO_GIST_UPDATE_JSON = "src/main/resources/json/gist_update.json";
    private static final String ACCESS_TOKEN = "df3b0194279fceab6df56ce74ea3c3237d0704cd";
    private static final String GIST_ID = "05de8017b3292c8504314fb6bd19ace7";
    private static final String URI_POST_REQUEST = URI + "gists?access_token=" + ACCESS_TOKEN;
    private static final String URI_PATCH_REQUEST = URI + "/gists/" + GIST_ID + "?access_token=" + ACCESS_TOKEN;
    private static final String URI_PUT_REQUEST = URI + "/gists/" + GIST_ID + "/star?access_token=" + ACCESS_TOKEN;
    private static final String URI_DELETE_REQUEST = URI + "/gists/" + GIST_ID + "/star?access_token=" + ACCESS_TOKEN;

    @Parameters("statusCodeCreated")
    @Test(description = "This TC check Create a gist")
    public void checkPostRequest(String statusCodeCreated) {
        String statusCode = post(URI_POST_REQUEST, PATH_TO_GIST_CREATE_JSON);
        assertEquals(statusCode, statusCodeCreated);
    }

    @Parameters("statusCodeNoContent")
    @Test(description = "This TC check Star a gist")
    public void checkPutRequest(String statusCodeNoContent) {
        String statusCode = put(URI_PUT_REQUEST);
        assertEquals(statusCode, statusCodeNoContent);
    }

    @Parameters("statusCodeNoContent")
    @Test(description = "This TC check Unstar a gist")
    public void checkDeleteRequest(String statusCodeNoContent) {
        String statusCode = delete(URI_DELETE_REQUEST);
        assertEquals(statusCode, statusCodeNoContent);
    }

    @Parameters("statusCodeOk")
    @Test(description = "This TC check Edit a gist")
    public void checkEditRequest(String statusCodeOk) {
        String statusCode = patch(URI_PATCH_REQUEST, PATH_TO_GIST_UPDATE_JSON);
        assertEquals(statusCode, statusCodeOk);
    }
}