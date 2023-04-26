package Pages.ViewsMenuPages;
import Pages.AppMenuPages.BasePageClass;

import conts.ViewsMenu.TabsPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class TabsPage extends BasePageClass implements TabsPageVariables {
    private static WebDriverWait wait;

    @AndroidFindBy(xpath = TABS_MENU)
    static MobileElement tabs_Menu;

    @AndroidFindBy(xpath = VIEWS_MENU)
    static MobileElement views_Menu;
    @AndroidFindBy(xpath = SCROLLABLE_BTN)
    static MobileElement scrollable_Btn;

    @AndroidFindBy(xpath = TAB_30)
    static MobileElement tab_30;

    @AndroidFindBy(xpath = TAB_30_SCREEN)
    static MobileElement tab_30_Screen;

    @AndroidFindBy(id = TABS)
    static MobileElement tabs;


    public TabsPage(AndroidDriver driver) {
        super(driver);
    }

    public static void deleteApp() throws InterruptedException {

        androidHelperMethods.removeApp();
    }

    public static void installAppAndViewsMenu() throws InterruptedException {

        androidHelperMethods.LaunchApp();
        androidHelperMethods.click(views_Menu);
    }

    public static void tabsMenu() throws InterruptedException {
        androidHelperMethods.ScrollDown(tabs_Menu);
        androidHelperMethods.click(tabs_Menu);
    }

    public static void scrollableBtn() throws InterruptedException {
        androidHelperMethods.click(scrollable_Btn);
    }

    public static void swipeTabsAndCheck() throws InterruptedException {
        androidHelperMethods.swipeBetweenTabs(tabs,tab_30, 0.8, 0.2, 0.5, 2000);
        androidHelperMethods.click(tab_30);
        String tabScreenText=androidHelperMethods.GetText(tab_30_Screen);
        Assert.assertEquals(tabScreenText,"Content for tab with tag Tab 30");
    }
    }

