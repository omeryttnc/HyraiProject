package utilities;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.asm.MemberSubstitution;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
  static   Response response;
    public static String getMockSessionIdMap(Map<String, String> mapBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

      return response.cookie("MOCKSESSID");
    }
}

