package Pages.AppMenuPages;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class ActionBarPage extends BasePageClass {

    public static final String APP_MENU = "//android.widget.TextView[@content-desc=\"App\"]";
    public static final String ACTION_BAR ="//android.widget.TextView[@content-desc=\"Action Bar\"]";
    public static final String ACTION_BAR_TABS="//android.widget.TextView[@content-desc=\"Action Bar Tabs\"]";
    public static final String TOGGLE_CHECK="android:id/action_bar";
    public static final String TOGGLE_BUTTON="android:id/btn_toggle_tabs";



    @AndroidFindBy(xpath = APP_MENU)
    static
    MobileElement app_menu_Btn;

    @AndroidFindBy(xpath = ACTION_BAR)
    static
    MobileElement action_bar_Btn;

    @AndroidFindBy(xpath = ACTION_BAR_TABS)
    static
    MobileElement action_bar_tabs_Btn;

    @AndroidFindBy(id = TOGGLE_CHECK)
    static
    MobileElement toggle_check;

    @AndroidFindBy(id = TOGGLE_BUTTON)
    static
    MobileElement toggle_button;

    public ActionBarPage(AndroidDriver driver) {
        super(driver);
    }

    public static void appMenu_Btn() throws InterruptedException {
        androidHelperMethods.click(app_menu_Btn);
    }

    public static void actionBarBtn() throws InterruptedException {
        androidHelperMethods.click(action_bar_Btn);
    }

    public static void actionBarTabs_Btn() throws InterruptedException {
        androidHelperMethods.click(action_bar_tabs_Btn);
    }

    public static void checkToggleTabMode() throws InterruptedException {
        androidHelperMethods.checkElementAndClick(toggle_check,toggle_button);
    }

//        AndroidElement toggleTabMode = driver.findElementById("com.example.android.apis:id/toggle_tabs");
  //      if (!toggleTabMode.getAttribute("checked").equals("false")) {
    //        toggleTabMode.click();
/*

    // Navigate to the 'Action Bar' menu
        driver.findElementByAccessibilityId("Action Bar").click();

    // Navigate to the 'Action Bar Tabs' menu
        driver.findElementByAccessibilityId("Action Bar Tabs").click();

    // Verify that 'Toggle tab mode' is passive
    AndroidElement toggleTabMode = driver.findElementById("com.example.android.apis:id/toggle_tabs");
        if (!toggleTabMode.getAttribute("checked").equals("false")) {
        toggleTabMode.click();
    }

    // Add 3 new tabs
        for (int i = 0; i < 3; i++) {
        driver.findElementByAccessibilityId("Add new tab").click();
    }

    // Verify that 3 tabs have been added
    List<AndroidElement> tabs = driver.findElementsByClassName("android.app.ActionBar$Tab");
        if (tabs.size() != 3) {
        throw new AssertionError("Expected 3 tabs, but found " + tabs.size());
    }

    // Delete the last added tab
        driver.findElementByAccessibilityId("Remove last tab").click();

    // Verify that the correct tab has been deleted
    tabs = driver.findElementsByClassName("android.app.ActionBar$Tab");
        if (tabs.size() != 2 || !tabs.get(1).getText().equals("Tab 2")) {
        throw new AssertionError("Expected the last tab to be 'Tab 2', but found " + tabs.get(1).getText());
    }

    // Delete all tabs
        driver.findElementByAccessibilityId("Remove all tabs").click();

    // Verify that there are no active tabs in the activity
    tabs = driver.findElementsByClassName("android.app.ActionBar$Tab");
        if (tabs.size() != 0) {
        throw new AssertionError("Expected no tabs, but found " + tabs.size());

    }
 */
}
