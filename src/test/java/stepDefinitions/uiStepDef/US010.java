package stepDefinitions.uiStepDef;

import enums.MAIL_DATA;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import pages.CommonPage;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class US010 extends CommonPage {
    @Then("assert appropriate warning appears")
    public void assertAppropriateWarningAppears(DataTable dataTable) {
        List<String> name = dataTable.column(0);
        List<String> company = dataTable.column(1);
        List<String> title = dataTable.column(2);
        List<String> phoneNumber = dataTable.column(3);
        List<String> email = dataTable.column(4);
        List<String> warningMessage = dataTable.column(5);
        List<String> isPass = dataTable.column(6);


        for (int i = 0; i < name.size(); i++) {
            getCompanyPage().name.sendKeys(name.get(i));
            getCompanyPage().companyName.sendKeys(company.get(i));
            getCompanyPage().title.sendKeys(title.get(i));
            getCompanyPage().phone.sendKeys(phoneNumber.get(i));
            getCompanyPage().email.sendKeys(email.get(i));

            if (Boolean.parseBoolean(isPass.get(i))) {
                String actualMessage = getCompanyPage().positiveText.getText();
                Assert.assertEquals(warningMessage.get(i), actualMessage);
            } else {

                String actualMessage = getCompanyPage().warningText.getText();
                Assert.assertEquals(warningMessage.get(i), actualMessage);
            }

            driver.navigate().refresh();

        }


    }

    /**
     * method is used to check object if null
     *
     * @param webElement gonderilecek element
     * @param str gonderecegim text
     * @since 09.05.2023
     * @author omer
     */
    public void nullChecker(WebElement webElement, String str) {
        if (str != null) {
           webElement.sendKeys(str);

        }

    }

    @Test
    public void name() {
        System.out.println("MAIL_DATA.V1.getEmail() = " + MAIL_DATA.V1.getEmail());
    }
}
