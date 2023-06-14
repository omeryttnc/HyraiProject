package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.DatabaseUtilities;

import static stepDefinitions.Hooks.driver;

public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;
    private CompanyPage companyPage;
    private ContactPage contactPage;
    private LoginPage loginPage;
    private MeetingsPage meetingsPage;
    private SignUpPage signUpPage;
    private RegistrationUF registrationUF;

    private DatabaseUtilities databaseUtilities;

    public DatabaseUtilities getDatabaseUtilities() {
        if (databaseUtilities == null) {
            databaseUtilities = new DatabaseUtilities();
        }
        return databaseUtilities;
    }

    public SignUpPage getSignUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage();
        }
        return signUpPage;
    }

    public CompanyPage getCompanyPage() {
        if (companyPage == null) {
            companyPage = new CompanyPage();
        }
        return companyPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public ContactPage getContactPage() {
        if (contactPage == null) {
            contactPage = new ContactPage();
        }
        return contactPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MeetingsPage getMeetingsPage() {
        if (meetingsPage == null) {
            meetingsPage = new MeetingsPage();
        }
        return meetingsPage;
    }

    public RegistrationUF getRegistrationUF() {
        if (registrationUF == null) {
            registrationUF = new RegistrationUF();
        }
        return registrationUF;
    }
}
