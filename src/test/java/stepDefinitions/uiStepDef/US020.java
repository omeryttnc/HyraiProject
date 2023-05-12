package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import utilities.ConfigurationReader;

import static stepDefinitions.Hooks.browserUtilities;
import static stepDefinitions.Hooks.driver;

public class US020 extends CommonPage {
    @Given("user goes to company sign up page")
    public void userGoesToCompanySignUpPage() {
        driver.get(ConfigurationReader.getProperty("company_login"));
    }

    @When("user click on forgot password link")
    public void userClickOnForgotPasswordLink() {
        getLoginPage().forgotPassword.click();
    }

    @Then("user is able to see the text {string} should be displayed")
    public void userIsAbleToSeeTheTextShouldBeDisplayed(String expectedMessage) {

        Assert.assertTrue(getLoginPage().verify_text.isDisplayed());
        String actualText = getLoginPage().verify_text.getText();

        Assert.assertEquals(expectedMessage, actualText);
    }

    @And("Verify email button should be visible")
    public void verifyEmailButtonShouldBeVisible() {
        Assert.assertTrue(getLoginPage().verify_button.isDisplayed());
    }


    @When("a valid {string} address is entered")
    public void aValidAddressIsEntered(String email) {
        getLoginPage().verify_box.sendKeys(email);
        getLoginPage().verify_button.click();
    }


    @Then("assert toast message if {string} {string} {string} Text must be visible")
    public void assertToastMessageIfTextMustBeVisible(String isPass, String positiveMessage, String negativeMessage) {


    }


    @Then("assert toast message {string} if {string} {string} {string} Text must be visible")
    public void assertToastMessageIfTextMustBeVisible(String email, String isPass, String positiveMessage, String negativeMessage) {
        if (Boolean.parseBoolean(isPass)) {
//            browserUtilities.waitForVisibility(getLoginPage().warningMail);
            String actualMail = getLoginPage().warningMail.getText();
            Assert.assertEquals(
                    email,
                    actualMail);
            String actualMessage = getLoginPage().warningText.getText();
            Assert.assertEquals(positiveMessage, actualMessage);
        } else {

//            browserUtilities.waitForVisibility(getLoginPage().toastMessage);
            String actualToastMessage = getLoginPage().toastMessage.getText();
            Assert.assertEquals(negativeMessage, actualToastMessage);

        }

    }
}
