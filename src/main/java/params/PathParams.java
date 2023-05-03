package params;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParams {
	@Test
	void pathParamTest() {

		Response response = given().log().all().pathParam("apiName", "api")
				.pathParam("userName", "users")
				.contentType("application/x-www-form-urlencoded;charset=utf-8")
				.formParam("name", "prasanna")
				.formParam("job", "QA")
				.when().post("https://reqres.in/{apiName}/{userName}");

		Assert.assertEquals(response.statusCode(), 201);
	}
}
