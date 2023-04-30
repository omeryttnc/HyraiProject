package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtilities {
//
//    /**
//     * javascript methodlari kullanarak webelementine click yapmak icin kullanildi
//     *
//     * @param webElement click yapilacak webelement
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public void clickWithJS(WebElement webElement) {
//
//    }
//
//    /**
//     * javascript methodlari kullanarak webelementin oldugu yere gitmek icin kullanildi
//     * note:  sadece asagi dogru gidilecekse ise yariyor
//     *
//     * @param webElement uzerine gidilecek webelement
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public void scrollWithJS(WebElement webElement) {
//    }
//
//    /**
//     * javascript methodlari kullanarak webelementin oldugu yere gidip uzerine click yapmak icin kullanildi
//     * note:  sadece asagi dogru gidilecekse ise yariyor
//     *
//     * @param webElement uzerine gidilip clikc yapilacak webelement
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public void scrollAndClickWithJS(WebElement webElement) {
//
//
//    }
//
//    /**
//     * beklenen url gorene kadar beklenmesi icin kullanildi
//     *
//     * @param partialUrl bekleyecegimiz url den bir kisim
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public void waitForPageToLoad(String partialUrl) {
//
//    }
//
//    /**
//     * method hard wait yapmak icin kullanildi
//     *
//     * @param second saniye olarak toplam bekleme suresi
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public static void wait(int second) {
//
//    }
//
//
//    /**
//     * method sayfa yuklene kadar beklemek icin kullanildi
//     *
//     * @param timeOutInSeconds saniye olarak toplam bekleme suresi
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public static void waitForPageToLoad(long timeOutInSeconds) {
//        ExpectedCondition<Boolean> expectation = driver -> {
//            assert driver != null;
//            return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//        };
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
//            wait.until(expectation);
//        } catch (Throwable error) {
//            error.printStackTrace();
//        }
//    }
//
//    /**
//     * method webelementin UI da gozukup gozukmedigini anlamamiza yarayacak
//     *
//     * @param webElement bakacagimiz webelement
//     * @return eger gozukuyorsa true gozukmuyorsa false donecek
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public static boolean isDisplayed(WebElement webElement) {
//
//    }
//
//    /**
//     * method webelemente tiklayabilecegimiz ana kadar bekliyecek
//     *
//     * @param webElement bekleyecegimiz webelement note: bekleme suresini default olarak 10 saniye yaptim
//     * @return bekledigimiz webelement
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public static WebElement waitForClickable(WebElement webElement) {
//
//    }
//
//    /**
//     * method webelementi gorene kadar beklemek icin kullanildi
//     *
//     * @param webElement UI da gormeyi bekledigimiz webelement
//     * @param second     saniye olarak toplam bekleme suresi
//     * @return UI da gormeyi bekledigimiz webelement
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//
//    public static WebElement waitForVisibility(WebElement webElement, int second) {
//
//    }
//
//    /**
//     * method webelementi gorene kadar beklemek icin kullanildi
//     *
//     * @param webElement UI da gormeyi bekledigimiz webelement bekleme suresi default olarak 10 saniye
//     * @return UI da gormeyi bekledigimiz webelement
//     * @author omeryttnc
//     * @since 30.04.2023
//     */
//    public static WebElement waitForVisibility(WebElement webElement) {
//
//    }
}
