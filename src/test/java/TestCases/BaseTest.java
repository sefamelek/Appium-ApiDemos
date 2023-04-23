package TestCases;


import DriverManager.DriverManager;
import DriverManager.DriverManagerType;
import Pages.AppMenuPages.BuyPage;
import Pages.AppMenuPages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    static WebDriver driver;
    HomePage homePage;
    BuyPage buyPage;

    @BeforeSuite
    public void setUp() {
        try {
            driver = DriverManager.getDriver(DriverManagerType.ANDROID);

            homePage = new HomePage((AndroidDriver)driver);
            buyPage = new BuyPage((AndroidDriver)driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @AfterSuite
    public void destroyDriver() throws Exception {
        System.out.println("bundan sonra");
    driver.close();
    System.out.println("son");
    }
}