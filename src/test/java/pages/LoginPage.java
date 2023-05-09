package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @FindBy(xpath = "//span[text()='Forgot Password']")
    public WebElement forgotPassword;

    @FindBy(css = ".dMPWJF")
    public WebElement verify_text;

    @FindBy(css = ".djJXEC")
    public WebElement verify_box;

    @FindBy(css = ".llHjeb")
    public WebElement verify_button;

    @FindBy(css = ".Toastify__toast-body")
    public WebElement toastMessage;

    @FindBy(xpath = "//div[text()='Whooops... Something went wrong.']")
    public WebElement toastMessageError;

    @FindBy(css = ".gahnKg")
    public WebElement warningMail;

    @FindBy(css = ".eRPtLU")
    public WebElement warningText;


}
