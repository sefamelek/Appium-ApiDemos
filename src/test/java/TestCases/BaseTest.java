package TestCases;


import DriverManager.DriverManager;
import DriverManager.DriverManagerType;
import Pages.AppMenuPages.ActionBarPage;
import Pages.AppMenuPages.ActivityPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    static WebDriver driver;
    ActionBarPage actionBarPage;
    ActivityPage activityPage;
    @BeforeSuite
    public void setUp() {
        try {
            driver = DriverManager.getDriver(DriverManagerType.ANDROID);

            actionBarPage = new ActionBarPage((AndroidDriver)driver);
            activityPage = new ActivityPage((AndroidDriver) driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @AfterSuite
    public void destroyDriver() throws Exception {
    driver.quit();
    }
}