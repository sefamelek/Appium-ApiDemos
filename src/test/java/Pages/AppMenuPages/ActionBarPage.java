package Pages.AppMenuPages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class ActionBarPage extends BasePageClass {

    public static final String CONTINUE_BTN = "com.nobroker.app:id/bottomPermission";
    public static final String BUY_BTN ="com.nobroker.app:id/buyLayout";
    public static final String SEARCH_BTN="com.nobroker.app:id/searchEditBar";


    @AndroidFindBy(id = CONTINUE_BTN)
    MobileElement allowContinue_Btn;

    @AndroidFindBy(id = BUY_BTN)
    MobileElement but_Btn;

    @AndroidFindBy(id = SEARCH_BTN)
    MobileElement search_Btn;

    public ActionBarPage(AndroidDriver driver) {
        super(driver);
    }

    public void allowContinue_Btn() throws InterruptedException {
        androidHelperMethods.click(allowContinue_Btn);
    }

    public void buyBtn() throws InterruptedException {
        androidHelperMethods.click(but_Btn);
    }

    public void search_Btn() throws InterruptedException {
        androidHelperMethods.click(search_Btn);
    }


    // Navigate to the 'App' menu

    public void ClickAppMenu() throws InterruptedException {
        androidHelperMethods.click(search_Btn);
    }


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
}
