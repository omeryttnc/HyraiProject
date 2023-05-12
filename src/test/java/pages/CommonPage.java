package pages;

import org.openqa.selenium.support.PageFactory;

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
}
