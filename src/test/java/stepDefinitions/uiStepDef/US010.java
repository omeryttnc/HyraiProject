package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
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
                //todo eger false ise yapilacak islemler
            } else {
                //todo eger true ise yapilacak islemler
            }

            driver.navigate().refresh();

        }


    }
}
