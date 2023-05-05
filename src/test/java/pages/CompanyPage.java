package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompanyPage extends CommonPage{
    @FindBy(css = "[name='name']")
    public WebElement name;

    @FindBy(css = "[name='companyName']")
    public WebElement companyName;

    @FindBy(css = "[name='title']")
    public WebElement title;

    @FindBy(css = "[name='phone']")
    public WebElement phone;

    @FindBy(css = "[name='email']")
    public WebElement email;

    @FindBy(css = "[type='submit']")
    public WebElement submit;

    @FindBy(css = ".text__Text-sc-1j50qoj-0.bTMoFt")
    public WebElement warningText;

    @FindBy(css = ".ant-modal-content h1")
    public WebElement positiveText;

    @FindBy(xpath = "//span[text()='Contact']")         public WebElement contactFooter;
}
