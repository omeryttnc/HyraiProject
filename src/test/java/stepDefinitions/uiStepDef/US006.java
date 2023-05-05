package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US006 {
    HomePage hp = new HomePage();

    @Given("user goes to homepage")
    public void userGoesToHomepage() {
        driver.get(ConfigurationReader.getProperty("baseUrl"));
    }

    @Then("user verifies social media icons are visible")
    public void userVerifiesSocialMediaIconsAreVisible() throws InterruptedException {
//        Thread.sleep(5000);
//        int size = commonPage.getHomePage().socialMediaIcons2.size();
        for (int i = 0; i < commonPage.getHomePage().socialMediaIcons.size(); i++) {
            Assert.assertTrue(commonPage.getHomePage().socialMediaIcons.get(i).isDisplayed());
        }

//        Assert.assertTrue(commonPage.getHomePage().socialMediaIcons.get(0).isDisplayed());
//        Assert.assertTrue(commonPage.getHomePage().socialMediaIcons.get(1).isDisplayed());
//        Assert.assertTrue(commonPage.getHomePage().socialMediaIcons.get(2).isDisplayed());
    }

    @Then("user verifies social media icons are clickable")
    public void userVerifiesSocialMediaIconsAreClickable() {
        for (int i = 0; i < commonPage.getHomePage().socialMediaIcons2.size(); i++) {
            Assert.assertTrue(commonPage.getHomePage().socialMediaIcons2.get(i).isEnabled());
        }

//        Assert.assertTrue(commonPage.getHomePage().socialMediaIcons2.get(0).isEnabled());
//        Assert.assertTrue(commonPage.getHomePage().socialMediaIcons2.get(1).isEnabled());
//        Assert.assertTrue(commonPage.getHomePage().socialMediaIcons2.get(2).isEnabled());
    }

    @Then("user verifies related pages are visible")
    public void userVerifiesRelatedPagesAreVisible(DataTable dataTable) {
        List<String> links = dataTable.column(0);

        for (int i = 0; i < links.size(); i++) {
            commonPage.getHomePage().socialMediaIcons.get(i).click();
            List<String> handles = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(handles.get(1));
            //hepsi icin gecerli
            Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("hyrai"));

            //sadece linkedini ayristirmak istersek
            if (links.get(i).contains("linkedin"))
                Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("hyrai"));
            else
                Assert.assertEquals(links.get(i), driver.getCurrentUrl());

            driver.close();
            driver.switchTo().window(handles.get(0));
        }

      /*  for (String handle: driver.getWindowHandles()){
            if(!handle.equals(winHand1))
                driver.switchTo().window(handle);
        }*/


    }
}
