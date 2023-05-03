package auth;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class OAuthTest {




@Test 
public void OAuthTest(){
    given()
            .auth().oauth2("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")
            .when()
            .get("https://api.github.com/user/repos")
            .then()
            .statusCode(200)
            .log().all();
}

}