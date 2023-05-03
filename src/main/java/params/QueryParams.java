package params;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class QueryParams {
	@Test
    public  void performMultipleQueryparametrs() {
        RestAssured.baseURI = "https://reqres.in/";
        RestAssured.basePath = "api/";
        given().log().all().urlEncodingEnabled(false).contentType(ContentType.JSON). with().queryParam("page", 2).queryParam("id", 9).
        when().get("users").then().statusCode(200).log().all();
    }
}
