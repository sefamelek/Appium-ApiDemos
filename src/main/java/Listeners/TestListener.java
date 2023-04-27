package Listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;


import reportManager.ExtentManager;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import static DriverManager.DriverManager.driver;

public class TestListener implements ITestListener {
    Logger logger;
    private ConcurrentHashMap<String, ExtentTest> allTests = new ConcurrentHashMap<>();
    String reportFolderPath = System.getProperty("user.dir") + "/AutomationReports/";
    String reportName = "AutomationReport.html";

    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        ExtentTest extentTest = ExtentManager.createInstance(reportFolderPath, reportName).createTest(iTestResult.getMethod().getMethodName());
        allTests.put(iTestResult.getClass().getSimpleName(), extentTest);
        ExtentManager.setTest(extentTest);
        extentTest.log(Status.INFO, MarkupHelper.createLabel("Test started: " + iTestResult.getMethod().getMethodName(), ExtentColor.BLUE));
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        String base64Screenshot = screenshotDriver.getScreenshotAs(OutputType.BASE64);
        ExtentManager.getTest().get().addScreenCaptureFromBase64String(base64Screenshot,"Sefa2");
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentManager.getTest().get().assignCategory(iTestResult.getClass().getSimpleName());
        ExtentManager.getTest().get().createNode(MarkupHelper.createLabel("Test passed", ExtentColor.GREEN).getMarkup());
        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        String base64Screenshot = screenshotDriver.getScreenshotAs(OutputType.BASE64);
        ExtentManager.getTest().get().addScreenCaptureFromBase64String(base64Screenshot,"Sefa1");
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            ExtentManager.getTest().get().createNode(MarkupHelper.createLabel("Test Failed", ExtentColor.RED).getMarkup())
                    .fail(iTestResult.getThrowable());
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            String base64Screenshot = screenshotDriver.getScreenshotAs(OutputType.BASE64);
            ExtentManager.getTest().get().addScreenCaptureFromBase64String(base64Screenshot,"Sefa2");
            ExtentManager.getInstance().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }
}