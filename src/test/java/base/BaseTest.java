package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;
import users.GetApi;
import utils.FileAndEnv;

public class BaseTest {

    protected Logger log = Logger.getLogger(BaseTest.class);

    @BeforeTest
    public void baseTest(){
        RestAssured.baseURI = FileAndEnv.getConfigProperty().get("serverName");
    }
}
