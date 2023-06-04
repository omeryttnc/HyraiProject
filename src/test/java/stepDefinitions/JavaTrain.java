package stepDefinitions;

import enums.TOAST_MESSAGE;
import enums.USERINFO;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.ToString;
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


    @Test
    public void MapClass_InnerClass_calismasi() {
        Map<String, Integer> map = new HashMap<>();

        map.put("elma", 20);
        map.put("armut", 25);
        map.put("ayva", 30);
        map.put("kiraz", 35);
        map.put("muz", 40);
        map.put("havuc", 45);

        // key adi muz var mi
        Assert.assertTrue(map.keySet().stream().anyMatch(t -> t.equals("muz")));
        // butun value ler 100 den kucuk mu
        Assert.assertTrue(map.values().stream().allMatch(t -> t < 100));
        // 30 dan buyuk 3 harfli urun var mi
        Assert.assertTrue(map.entrySet()
                .stream()
                .filter(t -> t.getValue() > 30)
                .anyMatch(t -> t.getKey().length() == 3));


        Fruit fruit = new Fruit();
        fruit.setFruit(new Fruit("omer", "elma", 50, true));
        fruit.setFruit(new Fruit("omer", "kayisi", 25, false));
        fruit.setFruit(new Fruit("mahmut", "muz", 30, true));
        fruit.setFruit(new Fruit("mahmut", "elma", 35, false));
        fruit.setFruit(new Fruit("mahmut", "kayisi", 40, true));


        List<Fruit> fruitList = fruit.getFruitList();

        // organic urunlerinin hepsinin fiyati 30 dan buyuk mu

        boolean flag = false;

        for (int i = 0; i < fruitList.size(); i++) {
            if (fruitList.get(i).isOrganic()) {
                if (fruitList.get(i).getPrice() > 30) {
                    flag = true;

                }
            }
        }

        Assert.assertTrue(flag);

        Assert.assertTrue(fruitList.stream()
                .filter(t -> t.isOrganic() == true)
                .allMatch(t -> t.getPrice() > 30));

        // fiyatin 25 den kucuk herhangi organic bir urun var mi
        // omer beyin elma urunu organic mi
        // mahmut beyin kayisi fiyati 30 dan yuksek mi

    }

    @Test
    public void mapLambdaCalismasi() {
        List<String> price = Arrays.asList("$102.5", "$24.5", "$34.5", "$35.2", "$43.6");


        // urun fiyatlarinin oldugu bir listemizin oldugunu varsayalim ve bu listedeki fiyatlari yuzde 10 indirim
        // yapildiginda butun urunlerin $15 dan daha fazla oldugunu assert etmemiz isteniyor nasil yaparsiniz



    }


}

@ToString
@Getter
class Fruit {
    private String productName, ownerName;
    private int price;
    private boolean isOrganic;

    private List<Fruit> fruitList = new ArrayList<>();

    public Fruit(String ownerName, String productName, int price, boolean isOrganic) {
        this.ownerName = ownerName;
        this.productName = productName;
        this.price = price;
        this.isOrganic = isOrganic;
    }

    public Fruit() {
    }

    public void setFruit(Fruit fruit) {
        fruitList.add(fruit);
    }

    public List<Fruit> getFruitList() {
        return fruitList;
    }
}
