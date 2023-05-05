package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import utilities.BrowserUtilities;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US014 {
    @And("user clicks on Contact at the bottom of the page")
    public void userClicksOnContactAtTheBottomOfThePage() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");
        BrowserUtilities.waitFor(3);
        BrowserUtilities.clickWithJs(commonPage.getCompanyPage().contactFooter);
//        commonPage.getCompanyPage().contactFooter.click();
    }

    @Then("user verifies address and contact information are visible")
    public void userVerifiesAddressAndContactInformationAreVisible() {
        Assert.assertTrue(commonPage.getContactPage().address.isDisplayed());
        Assert.assertEquals("4701 Patrick Henry DrUnit 25 Santa Clara, CA 95054United States", commonPage.getContactPage().address.getText().replaceAll("\n", ""));
        System.out.println(("4701 Patrick Henry Dr Unit 25 Santa Clara, CA 95054 United States\n" + commonPage.getContactPage().address.getText().replaceAll("\n", "")));
        Assert.assertTrue(commonPage.getContactPage().phone.isDisplayed());
        Assert.assertTrue(commonPage.getContactPage().email1.isDisplayed());

    }

    @When("user fills out the contact us form")
    public void userFillsOutTheContactUsForm(DataTable dataTable) {
        List<String> firstName = dataTable.column(0);
        List<String> lastName = dataTable.column(1);
        List<String> email = dataTable.column(2);
        List<String> subject = dataTable.column(3);
        List<String> message = dataTable.column(4);
        List<String> numberOfMessage = dataTable.column(5);
     /*   List<Integer> noOfMessage = new ArrayList<>();
        for (int i = 0; i < numberOfMessage.size(); i++) {
            noOfMessage.add(Integer.parseInt(numberOfMessage.get(i)));
        }*/
        List<String> messages = dataTable.column(6);

        //tum senaryolarimizi denemek icin
        for (int i = 0; i < messages.size(); i++) {
            BrowserUtilities.scrollToElement(commonPage.getContactPage().firstName);
            commonPage.getContactPage().firstName.sendKeys(firstName.get(i));
            commonPage.getContactPage().lastName.sendKeys(lastName.get(i));
            BrowserUtilities.scrollToElement(commonPage.getContactPage().email);
            commonPage.getContactPage().email.sendKeys(email.get(i));
            commonPage.getContactPage().subject.sendKeys(subject.get(i));
            BrowserUtilities.scrollToElement(commonPage.getContactPage().message);
            commonPage.getContactPage().message.sendKeys(message.get(i));
//            commonPage.getContactPage().sendMessage.click();
            BrowserUtilities.clickWithJs(commonPage.getContactPage().sendMessage);
            Assert.assertEquals(Integer.parseInt(numberOfMessage.get(i)), (int) commonPage.getContactPage().alertMessages.size());

            String[] arr = messages.get(i).split(",");
            for (String alMes : arr) {
                Assert.assertTrue(commonPage.getContactPage().alertMessages.stream().anyMatch(t -> t.getText().contains(alMes)));
            }

            BrowserUtilities.clearValue(commonPage.getContactPage().firstName);
            BrowserUtilities.clearValue(commonPage.getContactPage().lastName);
            BrowserUtilities.clearValue(commonPage.getContactPage().email);
            BrowserUtilities.clearValue(commonPage.getContactPage().subject);
            BrowserUtilities.clearValue(commonPage.getContactPage().message);

        }

    }

    @When("user clicks on For Companies button")
    public void userClicksOnForCompaniesButton() {
        commonPage.getHomePage().btn_forCompanies.click();
    }


    @When("user fills out the contact us form successfully")
    public void userFillsOutTheContactUsFormSuccessfully() {
        commonPage.getContactPage().firstName.sendKeys("aaa");
        commonPage.getContactPage().lastName.sendKeys("aaa");
        commonPage.getContactPage().email.sendKeys("aaaaa@aaaa.aaa");
        commonPage.getContactPage().subject.sendKeys("aaaaaaaaaaaaaaaaa");
        commonPage.getContactPage().message.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        BrowserUtilities.clickWithJs(commonPage.getContactPage().sendMessage);
    }

    @Then("user verifies toast message is visible")
    public void userVerifiesToastMessageIsVisible() {
        BrowserUtilities.waitFor(2);
        Assert.assertTrue(commonPage.getContactPage().toastMessage.isDisplayed());
        Assert.assertEquals("Your message has been sent successfully", commonPage.getContactPage().toastMessage.getText());
    }

    @DataTableType(replaceWithEmptyString = "[blank]")
    public String stringType(String cell) {
        return cell;
    }

}
