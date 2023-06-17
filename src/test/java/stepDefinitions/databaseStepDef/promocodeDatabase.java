package stepDefinitions.databaseStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.Promocode.PPromoCode;
import utilities.DatabaseUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class promocodeDatabase {
    Faker faker = new Faker();
    String promocodeName = faker.name().firstName();

    @Given("create promocode by using statement")
    public void createPromocodeByUsingStatement() {
        String startDate = getDateAndTimeForPromocode(-5, 0);
        String endDate = getDateAndTimeForPromocode(-3, 5);

        DatabaseUtilities.createPromoCode_statement(promocodeName, startDate, endDate);
    }

    @Given("update promocode by using statement")
    public void updatePromocodeByUsingStatement() {
    }

    @Given("delete promocode by using statement")
    public void deletePromocodeByUsingStatement() {
        DatabaseUtilities.deletePromocode_statement(3);
    }

    @Given("create promocode by using prepared statement")
    public void createPromocodeByUsingPreparedStatement() {
        String startDate = "2023-06-14 18:16:10.000000";
        String endDate = "2023-06-28 19:16:38";
        DatabaseUtilities.createPromocodePreStatement(promocodeName, startDate, endDate);
    }


    public String getDateAndTimeForPromocode(int day, int hour) {
        // "2023-06-14 18:16:10.000000";
        //  yyyy-MM-dd HH:mm:ss

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        calendar.add(Calendar.HOUR, hour);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(calendar.getTime()) + ".000000";

    }

    @Given("update promocode by using prepared statement")
    public void updatePromocodeByUsingPreparedStatement() {

        DatabaseUtilities.updatePomocode_preStatement(promocodeName, 3);
    }

    @Given("delete promocode by using prepared statement")
    public void deletePromocodeByUsingPreparedStatement() {
        DatabaseUtilities.deletePromocode_preStatetment(4);
    }

    @Given("select promocode")
    public void selectPromocode() {
        List<Map<String, Object>> promocode = DatabaseUtilities.getPromocode();

        for (int i = 0; i < promocode.size(); i++) {
            System.out.println("promocode.get(i).get(\"code\") = " + promocode.get(i).get("discount"));
        }
    }

    @Given("select promocode inner")
    public void selectPromocodeInner() {
        List<PPromoCode> promocode_innerClass = DatabaseUtilities.getPromocode_innerClass();

        for (int i = 0; i < promocode_innerClass.size(); i++) {
            System.out.println("promocode_innerClass.get(i).getId() = " + promocode_innerClass.get(i).getId());

        }


        promocode_innerClass.stream().forEach(t -> System.out.println(t.getId() + " " + t.getCode() + " " + t.getDiscount()));

    }

    private String createdPromoCodeName;
    private int createdPromoCodeID;
    private String updatedPromoCodeName;
    private List<PPromoCode> promocode_innerClass;


    @When("create promocode")
    public void createPromocode() {
        createdPromoCodeName = faker.name().firstName();
        updatedPromoCodeName = faker.name().lastName();
        System.out.println("createdPromoCodeName = " + createdPromoCodeName);
        System.out.println("updatedPromoCodeName = " + updatedPromoCodeName);
        DatabaseUtilities.createPromoCode_statement(
                createdPromoCodeName,
                getDateAndTimeForPromocode(-2, 0),
                getDateAndTimeForPromocode(2, 0)
        );


    }

    @Then("is promocode created")
    public void isPromocodeCreated() {

        promocode_innerClass = DatabaseUtilities.getPromocode_innerClass();

        Assert.assertTrue(promocode_innerClass.stream()
                .anyMatch(t -> t.getCode().equals(createdPromoCodeName)));


        promocode_innerClass.stream()
                .filter(t -> t.getCode().equals(createdPromoCodeName))
                .forEach(t -> createdPromoCodeID = t.getId());

        System.out.println("createdPromoCodeID = " + createdPromoCodeID);
    }

    @When("update promocode")
    public void updatePromocode() {
        DatabaseUtilities.updatePomocode_preStatement(updatedPromoCodeName, createdPromoCodeID);
    }

    @Then("is promocode updated")
    public void isPromocodeUpdated() {
        promocode_innerClass = DatabaseUtilities.getPromocode_innerClass();

        Assert.assertTrue(promocode_innerClass.stream()
                .anyMatch(t -> t.getCode().equals(updatedPromoCodeName)));

        Assert.assertTrue(promocode_innerClass.stream()
                .noneMatch(t -> t.getCode().equals(createdPromoCodeName)));
    }

    @When("delete promocode")
    public void deletePromocode() {

        DatabaseUtilities.deletePromocode_statement(createdPromoCodeID);
    }

    @Then("is promocode deleted")
    public void isPromocodeDeleted() {
        promocode_innerClass = DatabaseUtilities.getPromocode_innerClass();

        Assert.assertTrue(promocode_innerClass.stream()
                .noneMatch(t -> t.getId() == createdPromoCodeID));

        Assert.assertTrue(promocode_innerClass.stream()
                .noneMatch(t -> t.getCode().equals(updatedPromoCodeName)));

    }
}
