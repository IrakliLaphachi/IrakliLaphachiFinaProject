package api;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {
    @BeforeClass
    public void setupApi() {
        RestAssured.baseURI = "https://automationexercise.com";
    }
}