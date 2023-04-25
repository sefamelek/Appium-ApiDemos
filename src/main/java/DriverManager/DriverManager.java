package DriverManager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Properties;

public class DriverManager {
    static Properties properties;
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;

    public static WebDriver getDriver(DriverManagerType browserName) throws Exception {

                String propertyPath = System.getProperty("user.dir") + "/src/main/resources/android.properties";
                Thread.sleep(10000);
                return driver = new AndroidDriverManager().getAndroidDriver(propertyPath);


    }
    public static WebDriver quitDriver(DriverManagerType browserName) throws Exception {
        driver.quit();
        return null;
    }
}
