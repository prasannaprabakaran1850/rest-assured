package params;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;


public class MultiPart {
	
	@Test
	public void fileUploadTest() {
		String RESOURCES_PATH = System.getProperty("user.dir") + "/src/main/resources/testdata/TFL_TeamPlayers.png";
		File file = new File(RESOURCES_PATH);		
		Response responce= given().log().all()
        .multiPart("file", file, "multipart/form-data")
        .when().post("https://the-internet.herokuapp.com/upload");
		
		Assert.assertEquals(responce.statusCode(), 200);
		
	}

}
