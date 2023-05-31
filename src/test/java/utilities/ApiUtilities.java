package utilities;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import pojos.Login.PLogin;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApiUtilities {
    static Response response;

    public static String getMockSessionIdMap(Map<String, String> mapBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

        return response.cookie("MOCKSESSID");
    }

    public static Response getLoginResponse(Map<String, String> mapBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

        return response;
    }

    @SneakyThrows
    public static PLogin getLoginResponseAsObjectMapper(Map<String, String> mapBody) {
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

        response.prettyPrint();
        ObjectMapper objectMapper = new ObjectMapper();
        PLogin pLogin;

        pLogin = objectMapper.readValue(response.asString(), PLogin.class);


        return pLogin;
    }
}

