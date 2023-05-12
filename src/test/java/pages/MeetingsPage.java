package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MeetingsPage extends CommonPage {

    @FindBy(css = "[value='month']")                                                                            public WebElement monthButton;
    @FindBy(xpath = "//span[@class='ant-radio-button ant-radio-button-checked']/following-sibling::span")       public WebElement monthSpan;
    @FindBy(css = "[value='year']")                                                                             public WebElement yearButton;
    @FindBy(xpath= "//input[@value='year']/../following-sibling::span")                                         public WebElement yearSpan;
    @FindBy(css = "#rc_select_0")                                                                               public WebElement yearDropdown;
    @FindBy(css = "#rc_select_1")                                                                               public WebElement monthDropdown;
    @FindBy(css = "span[title='2023']")                                                                         public WebElement yearAssert;
    @FindBy(css = "span[title='May']")                                                                          public WebElement monthAssert;
    @FindBy(xpath = "(//div[@class='rc-virtual-list-holder-inner'])[1]/div/div")                                public List<WebElement> years;
    @FindBy(xpath = "(//div[@class='rc-virtual-list-holder-inner'])[2]/div/div")                                public List<WebElement> months;
    @FindBy(css = ".ant-picker-calendar-date-today > div.ant-picker-calendar-date-value")                       public WebElement todaysDate;
    @FindBy(css = ".ant-picker-calendar-date-value")                                                            public List<WebElement> allDates;
    @FindBy(css = ".events > li")                                                                               public List<WebElement> meetings;
    @FindBy(css = ".ant-picker-calendar-date-value")                                                            public List<WebElement> allMonths;
    @FindBy(css = ".ant-picker-calendar-date-today > .ant-picker-calendar-date-value")                          public WebElement currentMonth;
    @FindBy(css = ".ant-picker-calendar-date-today")                                                            public WebElement currentMonthBox;

}
