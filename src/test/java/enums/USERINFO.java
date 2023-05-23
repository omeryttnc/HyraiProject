package enums;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public enum USERINFO {
    CANDIDATE("demokesif1@gmail.com", "123123", "candidate");
    private String email, password, state;
    Response response;

    USERINFO(String email, String password, String state) {
        this.email = email;
        this.password = password;
        this.state = state;
    }


    public Response getResponse() {


        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", this.email);
        mapBody.put("password", this.password);
        mapBody.put("state", this.state);
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

        return response;
    }


    public int getUserID() {
        JsonPath jsonPath = response.jsonPath();

        return (jsonPath.getInt("result.userId"));
    }


    public String getMockID() {
        return response.cookie("MOCKSESSID");
    }
}