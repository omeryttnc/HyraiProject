package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static stepDefinitions.Hooks.*;

public class US024 {
    @When("user customer sign Up page")
    public void userCustomerSignUpPage() {
        driver.get("https://hyrai.com/auth?tab=SIGN_UP");
    }

    @Then("name should be visible.")
    public void nameShouldBeVisible() {
        Assert.assertTrue(commonPage.getSignUpPage().firstName.isDisplayed());
    }

    @When("user send one letter like {string} . {string} \\(warning text when letter length does not match)")
    public void userSendOneLetterLikeWarningTextWhenLetterLengthDoesNotMatch(String name, String errorMessage) {
        commonPage.getSignUpPage().firstName.sendKeys(name);
//        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
        String actualWarningMessage = commonPage.getSignUpPage().warningText.get(0).getText();

        Assert.assertEquals(errorMessage, actualWarningMessage);

        commonPage.getSignUpPage().firstName.sendKeys(name);

    }

    @Then("last Name must be visible.")
    public void lastNameMustBeVisible() {
        Assert.assertTrue(commonPage.getSignUpPage().lastName.isDisplayed());
    }

    @When("user send user send one letter like {string} . {string} \\(warning text when letter length does not match)")
    public void userSendUserSendOneLetterLikeWarningTextWhenLetterLengthDoesNotMatch(String lastName, String errorMessage) {

        commonPage.getSignUpPage().lastName.sendKeys(lastName);

        String actualWarningMessage = commonPage.getSignUpPage().warningText.get(0).getText();

        Assert.assertEquals(errorMessage, actualWarningMessage);

        commonPage.getSignUpPage().lastName.sendKeys(lastName);
    }

    @Then("The text Email must be visible.")
    public void theTextEmailMustBeVisible() {
        Assert.assertTrue(commonPage.getSignUpPage().email.isDisplayed());

    }

    @Then("Email should except proper email")
    public void email_should_except_proper_email(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps();


        for (int i = 0; i < data.size(); i++) {

            String email = data.get(i).get("email");
            String isAccepted = data.get(i).get("isAccepted");
            String message = data.get(i).get("message");

            commonPage.getSignUpPage().email.sendKeys(email);
            actions.sendKeys(Keys.TAB).build().perform();

            if (!Boolean.parseBoolean(isAccepted)) {
                String actualWarning = commonPage.getSignUpPage().warningText.get(0).getText();
                Assert.assertEquals(message, actualWarning);
            }
            commonPage.getSignUpPage().email.click();
            cleanWebelement(commonPage.getSignUpPage().email);

//            commonPage.getSignUpPage().email.clear();
        }
        commonPage.getSignUpPage().email.sendKeys("omeryttnc@gmail.com");

    }

    /**
     * the method is used to clear text of webelement
     *
     * @param webelement icerisindeki yazinin silinecegi webelement
     */
    public void cleanWebelement(WebElement webelement) {
        String value = webelement.getAttribute("value");

        for (int i = 0; i < value.length(); i++) {
            actions.sendKeys(Keys.BACK_SPACE).build().perform();
        }


    }

    public void cleanWebelement2(WebElement webelement) {

        webelement.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.BACK_SPACE);
//            Assert.assertEquals("%",getCompanyHireScreenPage().matchBoxes5Pieces.get(i).getAttribute("value"));

    }

    @Then("Password must be visible.")
    public void password_must_be_visible() {
        Assert.assertTrue(commonPage.getSignUpPage().firstPassword.isDisplayed());


    }

    @When("user send password less than six characters like {string}. {string} \\(warning text when characters length does not match)")
    public void user_send_password_less_than_characters_like_warning_text_when_characters_length_does_not_match(String password, String message) {
        commonPage.getSignUpPage().firstPassword.sendKeys(password);


        Assert.assertTrue(commonPage.getSignUpPage().warningText.stream().anyMatch(t -> t.getText().equals(message)));

//        String actualWarningMessage = commonPage.getSignUpPage().warningText.get(0).getText();
//
//        Assert.assertEquals(message, actualWarningMessage);

        commonPage.getSignUpPage().firstPassword.sendKeys(password);

    }

    @When("The text Confirm Password should be visible.")
    public void the_text_should_be_visible() {
        commonPage.getSignUpPage().secondPassword.sendKeys("abcabc");
        Assert.assertTrue(commonPage.getSignUpPage().secondPassword.isDisplayed());


    }

    @When("{string} text must be visible.")
    public void text_must_be_visible(String message) {
        String actualWarningMessage = commonPage.getSignUpPage().policy.getText();

        Assert.assertEquals(message, actualWarningMessage);
    }

    @When("The {string} button must be active. When I click it, I should see {string} in the sign up window.")
    public void the_button_must_be_active_when_i_click_it_i_should_see_in_the_sign_up_window(String string, String string2) {
        String signUpAsACandidateText = commonPage.getSignUpPage().signUpAsACandidate.getText();

        Assert.assertEquals(signUpAsACandidateText, string);

        commonPage.getSignUpPage().submit.click();
    }

}
