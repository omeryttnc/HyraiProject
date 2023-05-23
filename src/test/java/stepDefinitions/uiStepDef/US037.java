package stepDefinitions.uiStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static stepDefinitions.Hooks.*;

public class US037 {
    @Given("user logs in as a company")
    public void userLogsInAsACompany() {
        driver.get("https://hyrai.com/company/auth?tab=SIGN_IN");
        commonPage.getLoginPage().email.sendKeys(ConfigurationReader.getProperty("companyUser_email"));
        commonPage.getLoginPage().password.sendKeys(ConfigurationReader.getProperty("companyUser_password"));
        BrowserUtilities.clickWithJs(commonPage.getLoginPage().signInButton);
        MOCKSESSID = driver.manage().getCookieNamed("MOCKSESSID").getValue();

//        System.out.println("driver.manage().getCookieNamed(\"MOCKSESSID\").toJson() = " + driver.manage().getCookieNamed("MOCKSESSID").toJson());
//        System.out.println("driver.manage().getCookieNamed(\"MOCKSESSID\").toString() = " + driver.manage().getCookieNamed("MOCKSESSID").toString());
//        System.out.println("driver.manage().getCookieNamed(\"MOCKSESSID\").getName() = " + driver.manage().getCookieNamed("MOCKSESSID").getName());
//        System.out.println("driver.manage().getCookieNamed(\"MOCKSESSID\").getValue() = " + driver.manage().getCookieNamed("MOCKSESSID").getValue());
    }

    @When("user clicks on Meetings")
    public void userClicksOnMeetings() {
        BrowserUtilities.clickWithJs(commonPage.getCompanyPage().meetings);
    }

    @Then("user verifies Month button is functional")
    public void userVerifiesMonthButtonIsFunctional() {
        Assert.assertTrue(commonPage.getMeetingsPage().monthButton.isEnabled());
        Assert.assertEquals("Month", commonPage.getMeetingsPage().monthSpan.getText());
    }

    @And("user verifies Year button is functional")
    public void userVerifiesYearButtonIsFunctional() {
        Assert.assertTrue(commonPage.getMeetingsPage().yearButton.isEnabled());
        Assert.assertEquals("Year", commonPage.getMeetingsPage().yearSpan.getText());
    }

    @And("user verifies Year dropdown is functional")
    public void userVerifiesYearDropdownIsFunctional() {
        Assert.assertTrue(commonPage.getMeetingsPage().yearDropdown.isEnabled());
    }

    @And("user verifies Month dropdown is functional")
    public void userVerifiesMonthDropdownIsFunctional() {
        Assert.assertTrue(commonPage.getMeetingsPage().monthDropdown.isEnabled());

    }

    @And("user verifies years in year dropdown is in order")
    public void userVerifiesYearsInYearDropdownIsInOrder() {
        List<Integer> years = new ArrayList<>();
        for (int i = 0; i < commonPage.getMeetingsPage().years.size(); i++) {
            years.add(Integer.parseInt(commonPage.getMeetingsPage().years.get(i).getText()));
        }
//        Assert.assertEquals(years, Collections.sort(years));
        List<Integer> sortedYears = years.stream().sorted().toList();
        Assert.assertTrue(years.equals(sortedYears));
        Assert.assertEquals(sortedYears, years);
    }

    @And("user verifies year dropdown shows current year")
    public void userVerifiesYearDropdownShowsCurrentYear() {
        String year = commonPage.getMeetingsPage().yearAssert.getText();
//        SimpleDateFormat sdf= new SimpleDateFormat("yyyy");
//        Date date = new Date();
//        String currentYear = sdf.format(date);
        String currentYear = BrowserUtilities.getCurrentYear();
        Assert.assertEquals(BrowserUtilities.getCurrentYear(), year);
    }

    @And("user verifies months in month dropdown is in order")
    public void userVerifiesMonthsInMonthDropdownIsInOrder() {
        List<String> orderedMonths = new ArrayList<>(Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"));
        for (int i = 0; i < commonPage.getMeetingsPage().months.size(); i++) {
            Assert.assertEquals(orderedMonths.get(i), commonPage.getMeetingsPage().months.get(i).getText());
        }
    }

    @And("user verifies month dropdown shows current month")
    public void userVerifiesMonthDropdownShowsCurrentMonth() {
        String month = commonPage.getMeetingsPage().monthAssert.getText();
        SimpleDateFormat format = new SimpleDateFormat("MMM");
        Date date = new Date();
        String currentMonth = format.format(date);
        Assert.assertEquals(currentMonth, month);
    }

    @And("user verifies calendar shows today's date in different color")
    public void userVerifiesCalendarShowsTodaySDateInDifferentColor() {
        Assert.assertEquals("rgba(24, 144, 255, 1)", commonPage.getMeetingsPage().todaysDate.getCssValue("color"));
        String currentDay = BrowserUtilities.getCurrentDay();
        for (int i = 0; i < commonPage.getMeetingsPage().allDates.size(); i++) {
            if (commonPage.getMeetingsPage().allDates.get(i).getText().equals(currentDay)) {
                Assert.assertEquals("rgba(24, 144, 255, 1)", commonPage.getMeetingsPage().todaysDate.getCssValue("color"));
            } else {
                Assert.assertNotEquals("rgba(24, 144, 255, 1)", commonPage.getMeetingsPage().allDates.get(i).getCssValue("color"));
            }
        }
    }

    @And("user verifies scheduled meetings are shown in calendar")
    public void userVerifiesScheduledMeetingsAreShownInCalendar() {
        Assert.assertTrue(commonPage.getMeetingsPage().meetings.size() > 1);
        for (int i = 0; i < commonPage.getMeetingsPage().meetings.size(); i++) {
            Assert.assertTrue(commonPage.getMeetingsPage().meetings.get(i).isDisplayed());
        }

        commonPage.getMeetingsPage().meetings.forEach(t -> Assert.assertTrue(t.isDisplayed()));
    }

    @When("user clicks on Year button")
    public void userClicksOnYearButton() {
        BrowserUtilities.clickWithJs(commonPage.getCompanyPage().getMeetingsPage().yearButton);
    }

    @Then("user verifies current month is shown in different color")
    public void userVerifiesCurrentMonthIsShownInDifferentColor() {
        Assert.assertEquals("rgba(24, 144, 255, 1)", commonPage.getMeetingsPage().currentMonth.getCssValue("color"));
        String currentMonth = BrowserUtilities.getCurrentMonth();
        for (int i = 0; i < commonPage.getMeetingsPage().allMonths.size(); i++) {
            if (commonPage.getMeetingsPage().allMonths.get(i).getText().equals(currentMonth)) {
                Assert.assertEquals("rgba(24, 144, 255, 1)", commonPage.getMeetingsPage().currentMonth.getCssValue("color"));
                Assert.assertEquals("rgba(230, 247, 255, 1)", commonPage.getMeetingsPage().currentMonthBox.getCssValue("background-color"));
            } else {
                Assert.assertNotEquals("rgba(24, 144, 255, 1)", commonPage.getMeetingsPage().allMonths.get(i).getCssValue("color"));
            }
        }
    }


}
