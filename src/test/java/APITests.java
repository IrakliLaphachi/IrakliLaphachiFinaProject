import api.BaseAPITest;

import io.qameta.allure.Description;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

//        System.out.println(response.getBody().asString());

//        response.prettyPrint();

public class APITests extends BaseAPITest {
    @Description("Get All Products List")
    @Test
    public void getProductList() {
        Response response = RestAssured
                        .given()
                        .when()
                        .get("/api/productsList")
                        .then()
                        .extract()
                        .response();

        Assert.assertEquals(response.getStatusCode(), 200);

        int productsCount =
                response.jsonPath().getList("products").size();

        System.out.println("Total Products: " + productsCount);
    }

    @Description("POST to All Products List")
    @Test
    public void postToProductList() {
        Response response = RestAssured
                .when()
                .post("/api/productsList")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 405);
        System.out.println("Response Code from JSON: " + responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "This request method is not supported.");
        System.out.println("Message: " + message);
    }

    @Description("Get All Brands List")
    @Test
    public void getBrandsList() {
        Response response = RestAssured
                .when()
                .get("/api/brandsList")
                .then()
                .extract()
                .response();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Description("PUT to All Brands List")
    @Test
    public void putToBrandsList() {
        Response response = RestAssured
                .when()
                .put("/api/brandsList")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 405);
        System.out.println("Response Code from JSON: " + responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "This request method is not supported.");
        System.out.println("Message: " + message);
    }

    @Description("POST to Search Products")
    @Test
    public void postToSearch() {
        Response response = RestAssured
                .given()
                .formParam("search_product", "top")
                .when()
                .post("/api/searchProduct")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200);
        System.out.println("Response Code from JSON: " + responseCode);
    }

    @Description("POST to Search Products without search_product parameter")
    @Test
    public void postEmptySearch() {
        Response response = RestAssured
                .when()
                .post("/api/searchProduct")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 400);
        System.out.println("Response Code from JSON: " + responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Bad request, search_product parameter is missing in POST request.");
        System.out.println("Message: " + message);
    }

    @Description("POST to valid login details")
    @Test
    public void postValidLogin() {
        Response response = RestAssured
                .given()
                .formParam("email", "irakli@gmail.com")
                .formParam("password", "test1234")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200);
        System.out.println("Response Code from JSON: " + responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "User exists!");
        System.out.println("Message: " + message);
    }

    @Description("POST to invalid login details")
    @Test
    public void postInvalidLogin() {
        Response response = RestAssured
                .given()
                .formParam("email", "irakli@gmail.com")
                .formParam("password", "wrong")
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 404);
        System.out.println("Response Code from JSON: " + responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "User not found!");
        System.out.println("Message: " + message);
    }

    @Description("POST to empty login details")
    @Test
    public void postEmptyLogin() {
        Response response = RestAssured
                .given()
                .when()
                .post("/api/verifyLogin")
                .then()
                .extract()
                .response();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 400);
        System.out.println("Response Code from JSON: " + responseCode);

        String message = response.jsonPath().getString("message");
        Assert.assertEquals(message, "Bad request, email or password parameter is missing in POST request.");
        System.out.println("Message: " + message);
    }

    @Description("GET to user details by email")
    @Test
    public void getUserDetails() {
        Response response = RestAssured
                .given()
                .formParam("email", "irakli@gmail.com")
                .when()
                .get("/api/getUserDetailByEmail")
                .then()
                .extract()
                .response();

        response.prettyPrint();

        int responseCode = response.jsonPath().getInt("responseCode");
        Assert.assertEquals(responseCode, 200);
        System.out.println("Response Code from JSON: " + responseCode);

        String user = response.jsonPath().getString("user");
        System.out.println("User Details: " + user);
    }
}