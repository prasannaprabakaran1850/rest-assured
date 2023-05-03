package params;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class FormParams {
	@Test
	void formPAramTest() {
		RestAssured.baseURI = "https://reqres.in/";

		Response response = given().log().all()
				.contentType("application/x-www-form-urlencoded;charset=utf-8")
				.formParam("name", "prasanna").
				formParam("job", "QA")
				.when().post("api/users");

		Assert.assertEquals(response.statusCode(), 201);
	}

}
