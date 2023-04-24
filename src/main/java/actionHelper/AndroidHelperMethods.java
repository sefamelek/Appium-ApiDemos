package actionHelper;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AndroidHelperMethods {
    private AndroidDriver driver;

    public AndroidHelperMethods(AndroidDriver driver) {
        this.driver = driver;
    }

    public void click(MobileElement element) throws InterruptedException {
        Thread.sleep(5000);
        element.click();
        System.out.println("Element is getting clicked");
    }

    public void checkElementAndClick(MobileElement elementCheck, MobileElement elementClick) throws InterruptedException {
        if (elementCheck.isEnabled() == true) {
            System.out.println("Element is active");
            elementClick.click();
            System.out.println("Element is getting passive");

        } else {
            System.out.println("Element is passive");
        }

    }


    public void enter(MobileElement element, String input) {
        element.clear();
        element.sendKeys(input);

        System.out.println("Element is getting entered" + input);
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
            System.out.println("Not able to enter" + e.getMessage());
        }
    }

    public void WaitTillVisible(MobileElement element) {

        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(element));

    }

    public int CheckListSize(String element) {
        List<AndroidElement> tabs = driver.findElementsByClassName(element);
        int size= tabs.size();
        return size;
    }

    public AndroidElement CheckListIndex(String element, int ElementIndex) {
        List<AndroidElement> tabs = driver.findElementsByClassName(element);
        AndroidElement get= tabs.get(ElementIndex);
        return get;
    }
}