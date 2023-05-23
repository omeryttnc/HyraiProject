package stepDefinitions.backendStepDef;

import enums.USERINFO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.PLoginLombok;
import pojos.RLogin;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static stepDefinitions.Hooks.MOCKSESSID;

public class LoginApi {
    Response response;

    @Then("print mock session ID")
    public void printMockSessionID() {
        System.out.println("MOCKSESSID = " + MOCKSESSID);
    }


    @Given("get mock session id string")
    public void getMockSessionId_string() {

        response = given()
                .contentType(ContentType.JSON)
                .body("{\"email\":\"demokesif1@gmail.com\",\"password\":\"123123\",\"state\":\"candidate\"}")
                .when()
                .post("https://hyrai.com/api/login");

        System.out.println("response.cookie(\"MOCKSESSID\") = " + response.cookie("MOCKSESSID"));

    }

    @Given("get mock session id map")
    public void getMockSessionIdMap() {

        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", "demokesif1@gmail.com");
        mapBody.put("password", "123123");
        mapBody.put("state", "candidate");

        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");

        System.out.println("response.cookie(\"MOCKSESSID\") = " + response.cookie("MOCKSESSID"));
    }

    @Given("get mock session id inner class")
    public void getMockSessionIdInnerClass() {


        // normal class
//        PLogin pLoginBody = new PLogin("demokesif1@gmail.com","123123","candidate");
        // normal class ile lombok kutuphanesi
        PLoginLombok pLoginBody = new PLoginLombok("demokesif1@gmail.com", "123123", "candidate");
//PLoginLombok s= new PLoginLombok();
        // record class
        RLogin rLogin = new RLogin("demokesif1@gmail.com", "123123", "candidate");


        // normal java class
        System.out.println(pLoginBody.getPassword());
        // record java class
        System.out.println(rLogin.password());


        response = given()
                .contentType(ContentType.JSON)
                .body(rLogin)
                .when()
                .post("https://hyrai.com/api/login");

        System.out.println("response.cookie(\"MOCKSESSID\") = " + response.cookie("MOCKSESSID"));
    }

    @Given("get mock session id enum")
    public void getMockSessionIdEnum() {
        USERINFO.CANDIDATE.getResponse();
        System.out.println("USERINFO.CANDIDATE.getMockID() = " + USERINFO.CANDIDATE.getMockID());
    }
}
