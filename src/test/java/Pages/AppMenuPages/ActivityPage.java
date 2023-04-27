package Pages.AppMenuPages;


import actionHelper.AndroidHelperMethods;
import conts.AppMenu.ActivityPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;


public class ActivityPage extends BasePageClass implements ActivityPageVariables {

    @AndroidFindBy(xpath = APP_MENU)
    static MobileElement app_Menu;

    @AndroidFindBy(xpath = ACTIVITY_BAR)
    static MobileElement activity_Bar;

    @AndroidFindBy(xpath = CUSTOM_TITLE)
    static MobileElement custom_Title;

    @AndroidFindBy(id = LEFT_NAVIGATION_BAR)
    static MobileElement left_Navigation_Bar;

    @AndroidFindBy(id = RIGHT_NAVIGATION_BAR)
    static MobileElement right_Navigation_Bar;

    @AndroidFindBy(id = LEFT_TEXTBOX)
    static MobileElement left_Textbox;

    @AndroidFindBy(id = RIGHT_TEXTBOX)
    static MobileElement right_Textbox;

    @AndroidFindBy(id = CHANGE_LEFT_BUTTON)
    static MobileElement Change_Left_Button;
    @AndroidFindBy(id = CHANGE_RIGHT_BUTTON)
    static MobileElement Change_Right_Button;


    public ActivityPage(AndroidDriver driver) {
        super(driver);
    }
    public static void CacheClear() throws InterruptedException {
        androidHelperMethods.CasheClear();
        AndroidHelperMethods.logger.info("cache cleared");
    }

    public static void appMenu() throws InterruptedException {
        androidHelperMethods.click(app_Menu);
        AndroidHelperMethods.logger.info("App Button Clicked");

    }

    public static void activity() throws InterruptedException {
        androidHelperMethods.click(activity_Bar);
        AndroidHelperMethods.logger.info("Activity Button Clicked");

    }

    public static void customTitle_Btn() throws InterruptedException {
        androidHelperMethods.click(custom_Title);
        AndroidHelperMethods.logger.info("Custom Title Button Clicked");

    }
    public static void checkNavigationBarText() throws InterruptedException {
        String leftBar=androidHelperMethods.GetText(left_Navigation_Bar);
        String rightBar= androidHelperMethods.GetText(right_Navigation_Bar);

        Assert.assertEquals(leftBar,"Left is best");
        Assert.assertEquals(rightBar,"Right is always right");
        AndroidHelperMethods.logger.info("Navigation Bar Checked");

    }

    public static void getNavigationBarText() throws InterruptedException {
        androidHelperMethods.click(left_Textbox);
        androidHelperMethods.enter(left_Textbox,"Left New Left");
        androidHelperMethods.click(Change_Left_Button);
        androidHelperMethods.click(right_Textbox);
        androidHelperMethods.enter(right_Textbox,"Right New Right");
        androidHelperMethods.click(Change_Right_Button);
        AndroidHelperMethods.logger.info("Navigation Bar Updated");

        String leftBar=androidHelperMethods.GetText(left_Navigation_Bar);
        String rightBar= androidHelperMethods.GetText(right_Navigation_Bar);

        Assert.assertEquals(leftBar,"Left New Left");
        Assert.assertEquals(rightBar,"Right New Right");
        AndroidHelperMethods.logger.info("New Navigation Bar Checked");

    }

}
