package TestCases;

import Pages.AppMenuPages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.TestListener;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import reportManager.ExtentManager;

import static reportManager.ExtentManager.createInstance;
import static reportManager.ExtentManager.extentReports;
import static util.BannerUtil.paintBanner;

public class AllTestCases extends BaseTest {

    @Test
    public void Scenario_01() throws Exception {
        ActionBarPage.appMenu_Btn();
        ActionBarPage.actionBarBtn();
        ActionBarPage.actionBarTabs_Btn();
        ActionBarPage.checkToggleTabMode();
        ActionBarPage.AddNewTab();
        ActionBarPage.CheckTabSize();
        ActionBarPage.RemoveLastTab();
        ActionBarPage.CheckDeletedTab();
        ActionBarPage.RemoveAllTab();
        ActionBarPage.CheckTabSizeZero();
    }

    @Test
    public void Scenario_02() throws Exception {
        ActivityPage.CacheClear();
        ActivityPage.appMenu();
        ActivityPage.activity();
        ActivityPage.customTitle_Btn();
        ActivityPage.checkNavigationBarText();
        ActivityPage.getNavigationBarText();
    }
    @Test
    public void Scenario_03() throws Exception {
        AlertDialogsPage.appMenu();
        AlertDialogsPage.alertDialog();
        AlertDialogsPage.listDialog();
        AlertDialogsPage.SelectCommandElementAndCheckAlert();
    }
    @Test
    public void Scenario_04() throws Exception {
        FragmentContextMenuPage.appMenu();
        FragmentContextMenuPage.fragmentMenu();
        FragmentContextMenuPage.contextMenu();
        FragmentContextMenuPage.longTouchBtn();
        FragmentContextMenuPage.checkMenuAandMenuB();
    }
    @Test
    public void Scenario_05() throws Exception {
        FragmentHideAndShowMenuPage.appMenu();
        FragmentHideAndShowMenuPage.fragmentMenu();
        FragmentHideAndShowMenuPage.hideAndShowMenu();
        FragmentHideAndShowMenuPage.checkHideButtons();
        FragmentHideAndShowMenuPage.clickAndCheckHideButtons() ;
    }
    @Test
    public void Scenario_06() throws Exception{
        NotificationMenuPage.appMenu();
        NotificationMenuPage.fragmentMenu();
        NotificationMenuPage.incomingMessage();
        NotificationMenuPage.showNotificationBtn();
        NotificationMenuPage.checkNotifications();
        NotificationMenuPage.clickNotificationAndCheck();
    }


}
