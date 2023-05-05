package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePage extends CommonPage {
    @FindBy(xpath = "//div[@class='section1_socialIcons__3sY9u']/a")
    public List<WebElement> socialMediaIcons;
    @FindBy(xpath = "(//a[@href='https://www.facebook.com/Hyrai-100747998806269'])[1]")
    public WebElement facebookIcon;
    @FindBy(xpath = "(//a[@href='https://twitter.com/Hyrai7'])[1]")
    public WebElement twitterIcon;
    @FindBy(xpath = "(//a[@href='https://www.linkedin.com/company/hyraicorp/'])[1]")
    public WebElement linkedinIcon;

    @FindBy(css = ".navbar_gg10__2fDwo")
    public WebElement logo;

    @FindBy(css = ".text__Text-sc-1j50qoj-0.CDTmU")
    public List<WebElement> navbarList;

    public List<WebElement> socialMediaIcons2 = new ArrayList<>(Arrays.asList(facebookIcon, twitterIcon, linkedinIcon));
    @FindBy(xpath = "//a[@href='/company']") public WebElement btn_forCompanies;
}
