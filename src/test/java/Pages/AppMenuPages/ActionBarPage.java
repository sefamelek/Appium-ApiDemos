package Pages.AppMenuPages;



import conts.ActionBarPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class ActionBarPage extends BasePageClass implements ActionBarPageVariables{

    @AndroidFindBy(xpath = APP_MENU)
    static MobileElement app_menu_Btn;

    @AndroidFindBy(xpath = ACTION_BAR)
    static MobileElement action_bar_Btn;

    @AndroidFindBy(xpath = ACTION_BAR_TABS)
    static MobileElement action_bar_tabs_Btn;

    @AndroidFindBy(id = TOGGLE_CHECK)
    static MobileElement toggle_check;

    @AndroidFindBy(id = TOGGLE_BUTTON)
    static MobileElement toggle_button;

    @AndroidFindBy(id = ADD_NEW_TAB)
    static MobileElement add_new_tab;


    @AndroidFindBy(className = TAB_SIZE)
    static MobileElement tab_size;

    @AndroidFindBy(id = REMOVE_LAST_TAB)
    static MobileElement remove_last_tab;

    @AndroidFindBy(id = REMOVE_ALL_TABS)
    static MobileElement remove_all_tabs;

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
        androidHelperMethods.checkElementAndClick(toggle_check, toggle_button);
    }

    public static void AddNewTab() throws InterruptedException {
        // Add 3 new tabs
        for (int i = 0; i < 3; i++) {
            androidHelperMethods.click(add_new_tab);

        }
    }

    // Verify that 3 tabs have been added
    public static void CheckTabSize() throws InterruptedException {
        int tabSize = androidHelperMethods.CheckListSize(TAB_SIZE);

        if (androidHelperMethods.CheckListSize(TAB_SIZE) != 3) {
            throw new AssertionError("Expected 3 tabs, but found " + tabSize);
        }
    }


    public static void RemoveLastTab() throws InterruptedException {

        // Delete the last added tab
        androidHelperMethods.click(remove_last_tab);
    }

    public static void CheckDeletedTab() throws InterruptedException {
        // Verify that the correct tab has been deleted

        int tabSize = androidHelperMethods.CheckListSize(TAB_SIZE);
        AndroidElement getIndex = androidHelperMethods.CheckListIndex(TAB_SIZE, 1);
        if (androidHelperMethods.CheckListSize(TAB_SIZE) != 2) {
            throw new AssertionError("Expected the last tab to be 'Tab 2', but found " + getIndex.getText());
        }
    }



    public static void RemoveAllTab() throws InterruptedException {
        // Delete all tabs
        androidHelperMethods.click(remove_all_tabs);
    }

    // Verify that there are no active tabs in the activity
    public static void CheckTabSizeZero() throws InterruptedException {
        int tabSize = androidHelperMethods.CheckListSize(TAB_SIZE);

        if (androidHelperMethods.CheckListSize(TAB_SIZE) != 0) {

            throw new AssertionError("Expected no tabs, but found " + tabSize);
        }



    }


    }

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

