package actionHelper;
import io.appium.java_client.TouchAction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import static DriverManager.DriverManager.capabilities;

public class AndroidHelperMethods {
    private AndroidDriver driver;
    private WebDriverWait wait;
    public static Logger logger;
    TouchAction touchAction;

    public AndroidHelperMethods(AndroidDriver driver) {
        this.driver = driver;
    }

    public void click(MobileElement element) throws InterruptedException {
        //Thread.sleep(5000);
        logger= Logger.getLogger("Api Demos Mobil Automation");//added Logger
        logger.setLevel(Level.DEBUG);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("Element is getting clicked");
    }

    public void sendKeys(MobileElement element, String key) throws InterruptedException {
        //Thread.sleep(5000);
        logger= Logger.getLogger("Api Demos Mobil Automation");//added Logger
        logger.setLevel(Level.DEBUG);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(key);
        logger.info("Send Key");
    }

    public void checkElementAndClick(MobileElement elementCheck, MobileElement elementClick) throws InterruptedException {
        if (elementCheck.isEnabled() == true) {
            System.out.println("Element is active");
            logger.info("Element is active");
            elementClick.click();
            logger.info("Element is getting passive");

        } else {
            logger.info("Element is passive");
        }
    }

    public void CasheClear() throws InterruptedException {
        driver.resetApp();
        driver.launchApp();

    }
    public void LaunchApp() throws InterruptedException {
        driver.launchApp();

    }




    public void enter(MobileElement element, String input) {
        element.clear();
        element.sendKeys(input);

        logger.info("Element is getting entered" + input);
    }

    public void inputValuesSlowly(MobileElement element, String value) {
        try {
            String val = value;
            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                String s = new StringBuilder().append(c).toString();
                System.out.println(s);
                element.setValue(s);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            logger.info("Not able to enter" + e.getMessage());
        }
    }

    public void WaitTillVisible(MobileElement element) {

        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));

    }

    public int CheckListSizeforClassName(String element) {
        List<AndroidElement> tabs = driver.findElementsByClassName(element);
        int size= tabs.size();
        return size;
    }
    public int CheckListSizeforXpath(String element , MobileElement element1) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfAllElements(element1));

        List<AndroidElement> tabs = driver.findElementsByXPath(element);
        int size= tabs.size();
        return size;
    }
    public void clickbyXpath(String element) throws InterruptedException {
        //Thread.sleep(5000);
        logger.setLevel(Level.DEBUG);
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element))).click();
        logger.info("Element is getting clicked");
    }
    public AndroidElement CheckListIndex(String element, int ElementIndex) {
        List<AndroidElement> tabs = driver.findElementsByClassName(element);
        AndroidElement get= tabs.get(ElementIndex);
        return get;
    }

    public String GetText(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
        String text = element.getText();
        return text;
    }

    public void LongTouch(MobileElement element){
        touchAction = new TouchAction(driver);
        LongPressOptions longPressOptions = new LongPressOptions();
        longPressOptions.withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(3));
        new TouchAction<>(driver).longPress(longPressOptions).release().perform();

    }


}