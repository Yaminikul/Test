package apiVerification;

import org.testng.Assert;

import io.restassured.response.Response;


public class Verification {

    public static void verifyStatusCode(Response response, int expected){
        Assert.assertEquals(response.getStatusCode(), expected);
    }

    public static void verifyData(String actual, String expected){
        Assert.assertEquals(actual, expected);
    }
    public static void verifyData(int actual, int expected){
        Assert.assertEquals(actual, expected);
    }

    public static void responseTimeValidation(Response response){
        long time = response.getTime();
    }
}
