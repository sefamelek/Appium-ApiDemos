package Pages.AppMenuPages;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import conts.ActionBarPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import sun.security.ssl.SSLLogger;


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
        ExtentTest extentTest;
                //.log(Status.INFO, "Senaryo adı belirlendi ve senaryo açıklaması eklendi.");

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
        int tabSize = androidHelperMethods.CheckListSizeforClassName(TAB_SIZE);

        if (androidHelperMethods.CheckListSizeforClassName(TAB_SIZE) != 3) {
            throw new AssertionError("Expected 3 tabs, but found " + tabSize);
        }
    }


    public static void RemoveLastTab() throws InterruptedException {

        // Delete the last added tab
        androidHelperMethods.click(remove_last_tab);
    }

    public static void CheckDeletedTab() throws InterruptedException {
        // Verify that the correct tab has been deleted

        int tabSize = androidHelperMethods.CheckListSizeforClassName(TAB_SIZE);
        AndroidElement getIndex = androidHelperMethods.CheckListIndex(TAB_SIZE, 1);
        if (androidHelperMethods.CheckListSizeforClassName(TAB_SIZE) != 2) {
            throw new AssertionError("Expected the last tab to be 'Tab 2', but found " + getIndex.getText());
        }
    }



    public static void RemoveAllTab() throws InterruptedException {
        // Delete all tabs
        androidHelperMethods.click(remove_all_tabs);
    }

    // Verify that there are no active tabs in the activity
    public static void CheckTabSizeZero() throws InterruptedException {
        int tabSize = androidHelperMethods.CheckListSizeforClassName(TAB_SIZE);

        if (androidHelperMethods.CheckListSizeforClassName(TAB_SIZE) != 0) {

            throw new AssertionError("Expected no tabs, but found " + tabSize);
        }



    }


    }
