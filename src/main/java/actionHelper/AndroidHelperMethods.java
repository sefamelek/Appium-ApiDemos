package actionHelper;
import DriverManager.DriverManager;
import io.appium.java_client.TouchAction;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.utility;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class AndroidHelperMethods {
    private AndroidDriver driver;
    private WebDriverWait wait;
    public static Logger logger;
    TouchAction touchAction;
    Properties properties;


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

    public Boolean checkVisible(MobileElement element) throws InterruptedException {
        wait = new WebDriverWait(driver, 5);
        boolean Visibility;

        if (element.isEnabled() == true ) {
            Visibility = true;
        }
        else{
            Visibility = false;
        }
        return Visibility;
    }

    public Boolean checkNotVisible(MobileElement element) throws InterruptedException {
        wait = new WebDriverWait(driver, 5);

        boolean notVisible;
        try {
            notVisible = element.isEnabled();

        } catch (Exception e) {
            notVisible = false;
        }
        return notVisible;
    }


    public void OpenNotifications() throws InterruptedException {
        driver.openNotifications();
    }
    public void CloseNotifications(MobileElement element) throws InterruptedException {
        element.click();
    }

    public void removeApp() throws InterruptedException {
        String propertyPath = System.getProperty("user.dir") + "/src/main/resources/android.properties";
        properties = utility.loadProperties(propertyPath);
        String appPackage = properties.getProperty("appPackage");
        driver.removeApp(appPackage);
    }

    public void ScrollDown(MobileElement element) {
        Dimension dimensions = driver.manage().window().getSize();
        int scrollStart = (int) (dimensions.getHeight() * 0.8);
        int scrollEnd = (int) (dimensions.getHeight() * 0.2);
        boolean elementVisible;
        try {
            elementVisible = element.isDisplayed();

        } catch (Exception e) {
            elementVisible = false;
        }
        while (!elementVisible) {
            new TouchAction(driver).press(PointOption.point(0, scrollStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    //.moveTo(ElementOption.element(element))
                    .moveTo(PointOption.point(0, scrollEnd))
                    .release()
                    .perform();
            try {
                elementVisible = element.isDisplayed();

            } catch (Exception e) {
                elementVisible = false;
            }
        }
    }
    public void swipeBetweenTabs(MobileElement element) {

        Dimension dimensions = driver.manage().window().getSize();
        int scrollStart = (int) (dimensions.getWidth() * 0.8);
        int scrollEnd = (int) (dimensions.getWidth() * 0.2);
        boolean elementVisible;
        try {
            elementVisible = element.isDisplayed();

        } catch (Exception e) {
            elementVisible = false;
        }
        while (!elementVisible) {
            new TouchAction(driver).press(PointOption.point(0, element.getLocation().getX()))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(0, scrollEnd))
                    .release()
                    .perform();
            try {
                elementVisible = element.isDisplayed();

            } catch (Exception e) {
                elementVisible = false;
            }
        }

    }
}