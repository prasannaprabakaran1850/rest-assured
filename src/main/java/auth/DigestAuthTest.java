package auth;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DigestAuthTest {
    @Test
    public void testDigestAuthentication() {
    	Response response =   given()
            .auth()
            .digest("postman", "password") 
        .when()
            .get("https://postman-echo.com/basic-auth");
    	
        JsonPath jsonPath = response.jsonPath();
        System.out.println(response.body().asPrettyString());
        Assert.assertEquals(jsonPath.getString("authenticated"), "true");
    
    }
}