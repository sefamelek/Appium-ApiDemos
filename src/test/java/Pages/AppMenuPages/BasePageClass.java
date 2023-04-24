package Pages.AppMenuPages;

import actionHelper.AndroidHelperMethods;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePageClass {
    protected AndroidDriver androidDriver;
    static AndroidHelperMethods androidHelperMethods;

    public BasePageClass(AndroidDriver driver) {
        this.androidDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        androidHelperMethods= new AndroidHelperMethods(androidDriver);
    }
}
