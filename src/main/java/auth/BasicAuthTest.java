package auth;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BasicAuthTest {
    @Test
    public void testBasicAuthentication() {
    	Response response =   given()
            .auth()
            .preemptive()
            .basic("postman", "password") 
        .when()
            .get("https://postman-echo.com/basic-auth");
    	
        //Assert.assertEquals(jsonPath.getString("authenticated"), "true");
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("authenticated"), "true");
    
    }
    
    
    

}










