package users;

import apiBuilder.BodyConfig;
import apiConfig.ApiPath;
import apiConfig.HeaderConfigs;
import apiVerification.Verification;
import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Provider;

import java.util.Map;

public class PostApi extends BaseTest {

    @Test(dataProvider = "users", dataProviderClass = Provider.class)
    public void createUser(String name, String job){
        log.info("..............starting test...........");

        String[] key = {"name", "job"};
        String[] value = {name, job};
        BodyConfig bodyConfig = new BodyConfig();
        Map<String, String> body = bodyConfig.getBody(key, value);

        RequestSpecification requestSpecification = RestAssured.given().when().headers(new HeaderConfigs().defaultHeader())
                .body(body);

        Response response = requestSpecification.post(ApiPath.GET_USER.getValue());

        log.info("response is :\n" + response.prettyPrint());

        Verification.verifyStatusCode(response, HttpStatus.SC_CREATED);

        JsonPath jsonPath = response.getBody().jsonPath();

        Verification.verifyData(jsonPath.getString("name"), value[0]);
        Verification.responseTimeValidation(response);

        log.info("..............ending test...........");

    }


    @Test
    public void register(){
        log.info("..............starting test...........");

        String[] key = {"email", "password"};
        String[] value = {"eve.holt@reqres.in", "pistol"};
        BodyConfig bodyConfig = new BodyConfig();
        Map<String, String> body = bodyConfig.getBody(key, value);

        RequestSpecification requestSpecification = RestAssured.given().when().headers(new HeaderConfigs().defaultHeader())
                .body(body);

        Response response = requestSpecification.post(ApiPath.REGISTER.getValue());

        log.info("response is :\n" + response.prettyPrint());

        Verification.verifyStatusCode(response, HttpStatus.SC_OK);

        JsonPath jsonPath = response.getBody().jsonPath();

        Verification.verifyData(jsonPath.getString("id"), "4");
        Verification.responseTimeValidation(response);

        log.info("..............ending test...........");

    }
}
