package stepDefinitions;

import enums.TOAST_MESSAGE;
import enums.USERINFO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class JavaTrain {
    @Test
    public void lambda() {
        String[] names = {"elma", "armut", "muz"};


        // java 8 oncesi structure programming
        for (int i = 0; i < names.length; i++) {
            Assert.assertTrue(names[i].contains("m"));
        }

        // java 8 sonrasi functional programming lambda

        Assert.assertTrue(Arrays.stream(names).allMatch(t -> t.contains("m")));  // her bir obje m iceriyor mu

        Assert.assertTrue(Arrays.stream(names).anyMatch(t -> t.contains("z")));  // herhangi bir obje z iceriyor mu

        Assert.assertTrue(Arrays.stream(names).noneMatch(t -> t.contains("x")));  // hicbir bir obje x iceriyor mu


    }


    @Test
    public void enumDeneme() {
        System.out.println(TOAST_MESSAGE.EMAIL_1.getToast());

        TOAST_MESSAGE.assertToast(TOAST_MESSAGE.EMAIL_1);

    }


    @Test
    public void getRsponse() {

        USERINFO.CANDIDATE.getResponse();

        System.out.println(USERINFO.CANDIDATE.getUserID());

    }

    @Test
    public void filterLambda() {
        //  List<String> names =List.of("Turkiye","Almanya","Amerika","Ingiltere","Fransa");
        List<String> names2 = Arrays.asList("Turkiye", "Almanya", "Amerika", "Ingiltere", "Fransa");

        // icinde m harfi olanlari

        // structure programming
        List<String> newList = new ArrayList<>();

        for (int i = 0; i < names2.size(); i++) {
            if (names2.get(i).contains("m")) {
                newList.add(names2.get(i));
            }
        }
        System.out.println(newList);

        // functional programming
        List<String> lambdaList = names2.stream()
                .filter(t -> !t.contains("m"))
                .collect(Collectors.toList());


        System.out.println(lambdaList);
        // uzunlugu 7 harf olanlari

        List<String> stringList = names2.stream()
                .filter(t -> t.length() == 7)
                .collect(Collectors.toList());

        System.out.println(stringList);
    }


    @Test
    public void getResponseRoles() {
        Response response;
        Map<String, String> mapBody = new HashMap<>();
        mapBody.put("email", "demokesif1@gmail.com");
        mapBody.put("password", "123123");
        mapBody.put("state", "candidate");
        response = given()
                .contentType(ContentType.JSON)
                .body(mapBody)
                .when()
                .post("https://hyrai.com/api/login");


        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        System.out.println("jsonPath.getString(\"userInfo.email\") = " + jsonPath.getString("userInfo.email"));
        System.out.println("jsonPath.getInt(\"nbNotOpenedNotifications\") = " + jsonPath.getInt("nbNotOpenedNotifications"));
        System.out.println("jsonPath.getString(\"userInfo.firstName\") = " + jsonPath.getString("userInfo.firstName"));
        System.out.println("jsonPath.getList(\"userInfo.roles\") = " + jsonPath.getList("userInfo.roles").get(0));


    }


}
