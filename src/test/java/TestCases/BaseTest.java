package TestCases;


import DriverManager.DriverManager;
import DriverManager.DriverManagerType;
import Pages.AppMenuPages.*;
import Pages.ViewsMenuPages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static reportManager.ExtentManager.extentReports;
import static util.BannerUtil.paintBanner;

public class BaseTest {


    static WebDriver driver;
    ActionBarPage actionBarPage;
    ActivityPage activityPage;
    AlertDialogsPage alertDialogsPage;
    FragmentContextMenuPage fragmentContextMenuPage;
    FragmentHideAndShowMenuPage fragmentHideAndShowMenuPage;
    NotificationMenuPage notificationMenuPage;
    TabsPage tabsPage;
    @BeforeSuite
    public void setUp() {
        try {
//           htmlReporter = new ExtentHtmlReporter("extent.html");

            paintBanner();
            driver = DriverManager.getDriver(DriverManagerType.ANDROID);
            actionBarPage = new ActionBarPage((AndroidDriver)driver);
            activityPage = new ActivityPage((AndroidDriver) driver);
            alertDialogsPage = new AlertDialogsPage((AndroidDriver) driver);
            fragmentContextMenuPage = new FragmentContextMenuPage((AndroidDriver) driver);
            fragmentHideAndShowMenuPage = new FragmentHideAndShowMenuPage((AndroidDriver) driver);
            notificationMenuPage = new NotificationMenuPage((AndroidDriver) driver);;
            tabsPage = new TabsPage((AndroidDriver) driver);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @AfterSuite
    public void destroyDriver() throws Exception {
    driver.quit();
    }
}