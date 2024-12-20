package utils;

import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class APICommonMethods {

    public static void validateErrorMessage(Response response, String expectedMessage) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("Error"));
        assertTrue(responseBody.contains(expectedMessage));
    }

    public static void validateJWTToken(Response response) {
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        assertTrue("Response does not contain token", responseBody.contains("token"));

        String token = response.jsonPath().getString("token");
        Assert.assertNotNull("Token is null", token);
        assertEquals("Token does not follow JWT structure", 3, token.split("\\.").length);
    }
}
