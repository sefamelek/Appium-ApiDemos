package TestCases;

import Pages.AppMenuPages.ActionBarPage;
import Pages.AppMenuPages.ActivityPage;
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
}
