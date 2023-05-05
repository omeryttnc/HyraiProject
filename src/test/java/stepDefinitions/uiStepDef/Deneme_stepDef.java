package stepDefinitions.uiStepDef;

import enums.LINKS;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigurationReader;

import java.util.List;

public class Deneme_stepDef {

    @Given("Step Definition icinde user and password")
    public void step_definition_icinde_user_and_password() {
        System.out.println("user name password");
    }

    @Given("Scenariom icinde {string} and {int} ve {double} {string}")
    public void scenarioIcindeAndVe(String arg0, int arg1, double arg2, String arg4) {

        System.out.println(arg0);
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(Boolean.parseBoolean(arg4));
    }

    @Given("Configuration properties kullanarak")
    public void configurationPropertiesKullanarak() {

        System.out.println(ConfigurationReader.getProperty("baseUrl"));
    }


    @Given("Enum kullanarak")
    public void enumKullanarak() {

        System.out.println(LINKS.BASEURL.getLink());

    }

    @Given("Scenariom Outline {string} and {int} {double} {string}")
    public void scenariom_outline_and(String string, int int1, double double1, String string2) {

    }

    @Then("bir basamak daha olsa {int}")
    public void bir_basamak_daha_olsa(int int1) {

    }

    @Given("Data table kullanarak")
    public void data_table_kullanarak(DataTable dataTable) {
        List<String> usernames = dataTable.column(0);


        List<String> password = dataTable.column(1);

        for (int i = 0; i < usernames.size(); i++) {

            System.out.println("usernames.get(i) = " + usernames.get(i));
            System.out.println("password.get(i) = " + password.get(i));
        }


    }

    @Then("bir basamak daha olsa")
    public void bir_basamak_daha_olsa() {

    }

    @Given("tag kullanarak")
    public void tagKullanarak() {

    }
}
