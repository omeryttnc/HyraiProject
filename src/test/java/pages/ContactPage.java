package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage extends CommonPage{
    @FindBy(xpath = "//span[@class='text__StyledText-sc-1s1i12s-0 TTbWn']")                 public WebElement address;
    @FindBy(xpath = "(//span[@class='text__StyledText-sc-1s1i12s-0 dcwTaJ'])[1]")           public WebElement phone;
    @FindBy(xpath = "(//span[@class='text__StyledText-sc-1s1i12s-0 dcwTaJ'])[2]")           public WebElement email1;
    @FindBy(css = "[name='firstName']")                                                     public WebElement firstName;
    @FindBy(css = "[name='lastName']")                                                      public WebElement lastName;
    @FindBy(css = "[name='email']")                                                         public WebElement email;
    @FindBy(css = "[name='subject']")                                                       public WebElement subject;
    @FindBy(css = "[name='message']")                                                       public WebElement message;
    @FindBy(css = "[type='submit']")                                                        public WebElement sendMessage;
    @FindBy(xpath = "//span[@color='#E03724']")                                             public List<WebElement> alertMessages;
    @FindBy(css = ".Toastify__toast-body")                                                  public WebElement toastMessage;
}
