package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationUF extends CommonPage{
    @FindBy(id = "registration_form_firstname")                     public WebElement firstName;
    @FindBy(id = "registration_form_lastname")                      public WebElement lastName;
    @FindBy(id = "registration_form_email")                         public WebElement email;
    @FindBy(id = "registration_form_plainPassword")                 public WebElement password;
    @FindBy(id = "registration_form_confirmPassword")               public WebElement confirmPassword;
    @FindBy(css = "[type='submit']")                                public WebElement submit;
}
