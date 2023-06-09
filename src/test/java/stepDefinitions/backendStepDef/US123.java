package stepDefinitions.backendStepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.BrowserUtilities;
import utilities.DatabaseUtilities;

import java.sql.*;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;
import static utilities.DatabaseUtilities.resultSet;

public class US123 {
    Faker faker = new Faker();
    Connection connection;
    String email = faker.internet().emailAddress();

    @Given("user goes to urbanicfarm register page")
    public void userGoesToUrbanicfarmRegisterPage() {
        driver.get("https://test.urbanicfarm.com/auth/register");
    }

    @When("user fills out the registration form")
    public void userFillsOutTheRegistrationForm() {
        commonPage.getRegistrationUF().firstName.sendKeys(faker.name().firstName());
        commonPage.getRegistrationUF().lastName.sendKeys(faker.name().lastName());
        commonPage.getRegistrationUF().email.sendKeys(email);
        String password = faker.internet().password(8, 16, true, true, true);
        commonPage.getRegistrationUF().password.sendKeys(password);
        commonPage.getRegistrationUF().confirmPassword.sendKeys(password);
    }

    @And("user clicks on the register button")
    public void userClicksOnTheRegisterButton() {
        BrowserUtilities.clickWithJs(commonPage.getRegistrationUF().submit);

    }

    @Given("user connects to the database")
    public void userConnectsToTheDatabase() {
        DatabaseUtilities.createConnection();

    }

    @Then("user verifies the registered user exists")
    public void userVerifiesTheRegisteredUserExists() throws SQLException {
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        DatabaseUtilities.executeQuery("SELECT * FROM user");
        boolean flag = false;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("email"));
            if (resultSet.getString("email").equals(email)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
        flag=false;
        System.out.println("set2");

//        ResultSet resultSet2 = statement.executeQuery("SELECT * FROM user WHERE email='" + email + "'");
        DatabaseUtilities.executeQuery("SELECT * FROM user WHERE email='" + email + "'");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("email"));
            if (resultSet.getString("email").equals(email)) {
                flag = true;
                break;
            }
        }

        if(resultSet.next()){
            System.out.println("User exists");
            Assert.assertEquals(email, resultSet.getString("email"));
        }else{
            System.out.println("User doesnt exist");
        }
        Assert.assertTrue(flag);

        flag=false;

        System.out.println("set3");
//        ResultSet resultSet3 = statement.executeQuery("SELECT * FROM user ORDER BY id DESC");
        DatabaseUtilities.executeQuery("SELECT * FROM user ORDER BY id DESC");

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("email"));
            if (resultSet.getString("email").equals(email)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);



    }

    @And("user closes connection")
    public void userClosesConnection() {
        DatabaseUtilities.closeConnection();
    }
}
