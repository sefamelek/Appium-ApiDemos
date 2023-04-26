package Pages.AppMenuPages;

import actionHelper.AndroidHelperMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BasePageClass {
    ExtentHtmlReporter htmlReporter;
    static ExtentReports extent;
    protected AndroidDriver androidDriver;
    static AndroidHelperMethods androidHelperMethods;

    public BasePageClass(AndroidDriver driver) {
        this.androidDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        androidHelperMethods= new AndroidHelperMethods(androidDriver);

    }
}
