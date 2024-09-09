package users;

import apiConfig.ApiPath;
import apiConfig.HeaderConfigs;
import apiVerification.Verification;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import static org.hamcrest.Matchers.equalTo;

public class GetApi extends BaseTest {


    @Test
    public void getUsers(){
        log.info("..............starting test...........");
        Response response =
                RestAssured.given().headers(new HeaderConfigs().defaultHeader())
                .queryParam("page",2).when().get(ApiPath.GET_USER.getValue())
                                .then().extract().response();

        log.info("response is :\n" + response.prettyPrint());
        JsonPath object = new JsonPath(response.getBody().asString());

        Verification.verifyStatusCode(response, HttpStatus.SC_OK);
        Verification.verifyData(Integer.parseInt(object.getString("page")), 2);
        Verification.responseTimeValidation(response);


        log.info("..............ending test...........");
    }

    @Test
    public void getUser(){
        int userId = 2;
        log.info("..............starting test...........");

        RequestSpecification requestSpecification = RestAssured.given().headers(new HeaderConfigs().defaultHeader())
                .pathParams("userId", userId);

        log.info(requestSpecification);

        Response response =
               requestSpecification.when().get(ApiPath.GET_USER.getValue()+"/{userId}")
                        .then().extract().response();



        log.info("response is :\n" + response.prettyPrint());
        JsonPath object = new JsonPath(response.getBody().asString());

        Verification.verifyStatusCode(response, HttpStatus.SC_OK);
        Verification.verifyData(Integer.parseInt(object.getString("data.id")), 2);
        Verification.responseTimeValidation(response);


        log.info("..............ending test...........");
    }

    @Test
    public void getResources(){
        log.info("..............starting test...........");

        RequestSpecification requestSpecification = RestAssured.given().headers(new HeaderConfigs().defaultHeader());

        log.info(requestSpecification);

        Response response =
                requestSpecification.when().get(ApiPath.GET_RESOURCE.getValue())
                        .then().extract().response();



        log.info("response is :\n" + response.prettyPrint());
        JsonPath object = new JsonPath(response.getBody().asString());

        Verification.verifyStatusCode(response, HttpStatus.SC_OK);
        Verification.verifyData(Integer.parseInt(object.getString("page")), 1);
        Verification.responseTimeValidation(response);


        log.info("..............ending test...........");
    }

    @Test
    public void getResource(){
        int userId = 2;

        log.info("..............starting test...........");

        RequestSpecification requestSpecification = RestAssured.given().headers(new HeaderConfigs().defaultHeader())
                .pathParams("userId", userId);

        log.info(requestSpecification);

        Response response =
                requestSpecification.when().get(ApiPath.GET_RESOURCE.getValue()+"/{userId}")
                        .then().extract().response();



        log.info("response is :\n" + response.prettyPrint());
        JsonPath object = new JsonPath(response.getBody().asString());

        Verification.verifyStatusCode(response, HttpStatus.SC_OK);
        Verification.verifyData(Integer.parseInt(object.getString("data.id")), 2);
        Verification.responseTimeValidation(response);


        log.info("..............ending test...........");
    }

    @Test
    public void getDelayUser(){
        int delay = 2;

        log.info("..............starting test...........");

        RequestSpecification requestSpecification = RestAssured.given().headers(new HeaderConfigs().defaultHeader());

        log.info(requestSpecification);

        Response response =
                requestSpecification.queryParam("delay", delay)
                        .when().get(ApiPath.GET_RESOURCE.getValue())
                        .then().extract().response();



        log.info("response is :\n" + response.prettyPrint());
        JsonPath object = new JsonPath(response.getBody().asString());

        Verification.verifyStatusCode(response, HttpStatus.SC_OK);
        Verification.verifyData(Integer.parseInt(object.getString("page")), 1);
        Verification.responseTimeValidation(response);


        log.info("..............ending test...........");
    }

}
