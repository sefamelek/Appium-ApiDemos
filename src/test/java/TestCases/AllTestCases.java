package TestCases;

import Pages.AppMenuPages.*;
import Pages.ViewsMenuPages.*;

import org.testng.annotations.Test;

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
        NotificationMenuPage.notificationMenu();
        NotificationMenuPage.incomingMessage();
        NotificationMenuPage.showNotificationBtn();
        NotificationMenuPage.checkNotifications();
        NotificationMenuPage.clickNotificationAndCheck();
    }

    @Test
    public void Scenario_07() throws Exception{
        TabsPage.deleteApp();
        TabsPage.installAppAndViewsMenu();
        TabsPage.tabsMenu();
        TabsPage.scrollableBtn();
        TabsPage.swipeTabsAndCheck();
    }




}
