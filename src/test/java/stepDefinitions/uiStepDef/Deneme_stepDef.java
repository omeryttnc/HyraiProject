package stepDefinitions.uiStepDef;

import enums.UserInfo;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import utilities.ConfigurationReader;

import java.util.List;

public class Deneme_stepDef {


    @Given("tag kullanarak")
    public void tagKullanarak() {

    }

    @Given("Scenario Outline {string} and {string}")
    public void scenarioOutlineAnd(String email, String password) {

        System.out.println("email : " + email + " password : " + password);
    }

    @Given("Configuration properties kullanarak")
    public void configurationPropertiesKullanarak() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("companyUser_email") +
                        " password : " + ConfigurationReader.getProperty("companyUser_password")
        );

    }

    @Given("Enum kullanarak")
    public void enumKullanarak() {
        System.out.println(
                "email : " + UserInfo.COMPANY.getEmail() +
                        " password : " + UserInfo.COMPANY.getPassword()
        );
    }

    @Given("Data table kullanarak")
    public void dataTableKullanarak(DataTable dataTable) {
        List<String> emails = dataTable.column(0);
        List<String> passwords = dataTable.column(1);

        for (int i = 0; i < emails.size(); i++) {
            System.out.println("email : " + emails.get(i) + " password : " + passwords.get(i));


        }
    }

    @Given("Scenario icinde {string} and {string}")
    public void scenarioIcindeAnd(String email, String password) {
        System.out.println("email : " + email + " password : " + password);

    }


}
