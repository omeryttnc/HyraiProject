package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends CommonPage {
    @FindBy(css = "[name='firstName']")
    public WebElement firstName;

    @FindBy(css = "input[name='lastName']")
    public WebElement lastName;

    @FindBy(css = "input[name='email'].bKkllf")
    public WebElement email;

    @FindBy(css = "input[name='first'].bKkllf")
    public WebElement firstPassword;

    @FindBy(css = "input[name='second'].bKkllf")
    public WebElement secondPassword;

    @FindBy(css = ".eikqEd")
    public WebElement submit;

    @FindBy(css = ".qBTWA")
    public List<WebElement> warningText;

    @FindBy(css = "div.sign-up_policy__2hyLn")
    public WebElement policy;

    @FindBy(css = ".ant-btn.ant-btn-link>span")
    public WebElement signUpAsACandidate;


}
