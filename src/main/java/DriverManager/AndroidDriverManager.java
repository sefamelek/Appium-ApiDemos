package DriverManager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import util.utility;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AndroidDriverManager {
    Properties properties;
    private static Map<String, AndroidDriver> mobileDriverPool = new HashMap();
    static DesiredCapabilities capabilities;
    AndroidDriver driver;

    public AndroidDriver getAndroidDriver(String propertyPath) {
        try {

            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "src/main/resources/apk");
            File app = new File (appDir, "API Demos.apk");

            properties = utility.loadProperties(propertyPath);
            String deviceName = properties.getProperty("deviceName");
            String nodeURL = properties.getProperty("nodeURL");
            String appPackage = properties.getProperty("appPackage");
            String appActivity = properties.getProperty("appActivity");
            String platformName = properties.getProperty("platformName");

            String apps = properties.getProperty("apkPath");
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", app.getAbsolutePath());
           // capabilities.setCapability("app", "/Users/scorp/Downloads/Appium-ApiDemos/src/main/resources/apk/API Demos.apk");

            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("platformName", platformName);
            capabilities.setCapability("deviceName", deviceName);

            URL url = new URL(nodeURL);

            AndroidDriver driver = new AndroidDriver(url, capabilities);
            System.out.println("Session: "+ driver.getSessionDetails());
            return driver;

        } catch (Exception e) {
            System.out.println("Not able to create Android Driver " + e.getMessage());
        }
        return driver;
    }
}
