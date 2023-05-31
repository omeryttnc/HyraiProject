package stepDefinitions.backendStepDef;

import com.fasterxml.jackson.databind.ObjectMapper;
import enums.USERINFO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.junit.Assert;
import pojos.Login.PLogin;
import pojos.PLoginLombok;
import pojos.RLogin;
import utilities.ApiUtilities;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
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

    @Given("read response by Json path")
    public void readResponseByJsonPath() {
        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", "demokesif1@gmail.com");
        mapBody.put("password", "123123");
        mapBody.put("state", "candidate");

        Response loginResponse = ApiUtilities.getLoginResponse(mapBody);

        loginResponse.prettyPrint();

        JsonPath jsonPath = loginResponse.jsonPath();

        Assert.assertTrue(jsonPath.getBoolean("status"));

        int actualUserId = jsonPath.getInt("result.userId");

        // expected 975 but actual 975 hatasi alirsak cozum data type lari farkli girilmistir

        int expectedUserId = 975;

        Assert.assertEquals(expectedUserId, actualUserId);

        Assert.assertTrue(jsonPath.getList("userInfo.roles").stream()
                .anyMatch(t -> t.equals("ROLE_USER")));


    }

    @Given("read response by hamcrest")
    public void readResponseByHamcrest() {

        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", "demokesif1@gmail.com");
        mapBody.put("password", "123123");
        mapBody.put("state", "candidate");

        Response loginResponse = ApiUtilities.getLoginResponse(mapBody);

        Assert.assertTrue(loginResponse.getBody().toString().contains("errorCode"));

        loginResponse
                .then()
                .assertThat()
                .statusCode(200)
                .body("status", equalTo(true))
                .body("result.userId", equalTo(975))
                .body("errorCode", nullValue())
                .body("userInfo.roles", hasItem("ROLE_USER"))
                .body("userInfo.roles", not(hasItem("ROLE_SELLER")))
                .time(lessThan(3000L))
                .header("Content-Type", "application/json")
                .log()
                .body();


    }
    @SneakyThrows
    @Given("read response by ObjectMapper")
    public void readResponseByObjectMapper() {

        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", "demokesif1@gmail.com");
        mapBody.put("password", "123123");
        mapBody.put("state", "candidate");


//         way 1
        Response loginResponse = ApiUtilities.getLoginResponse(mapBody);

        ObjectMapper objectMapper = new ObjectMapper();

        PLogin pLogin = objectMapper.readValue(loginResponse.asString(), PLogin.class);


        // way 2
       // PLogin pLogin = ApiUtilities.getLoginResponseAsObjectMapper(mapBody);

        Assert.assertTrue(pLogin.getStatus());

        Assert.assertTrue(pLogin.getResult().getUserId().equals(975));

        Assert.assertTrue(pLogin.getUserInfo().getRoles().stream().anyMatch(t -> t.equals("ROLE_USER")));

    }
}
