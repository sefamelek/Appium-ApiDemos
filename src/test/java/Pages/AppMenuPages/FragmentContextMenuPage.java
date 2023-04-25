package Pages.AppMenuPages;


import conts.FragmentContextMenuPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.Random;


public class FragmentContextMenuPage extends BasePageClass implements FragmentContextMenuPageVariables {

    @AndroidFindBy(xpath = APP_MENU)
    static MobileElement app_Menu;

    @AndroidFindBy(xpath = FRAGMENT_MENU)
    static MobileElement fragment_Menu;
    @AndroidFindBy(xpath = CONTEXT_MENU)
    static MobileElement context_Menu;

    @AndroidFindBy(id = LONG_PRESS_BTN)
    static MobileElement long_Press_Btn;

    @AndroidFindBy(xpath = LONG_PRESS_MENU_A)
    static MobileElement long_Press_Menu_A;

    @AndroidFindBy(xpath = LONG_PRESS_MENU_B)
    static MobileElement long_Press_Menu_B;

    public FragmentContextMenuPage(AndroidDriver driver) {
        super(driver);
    }



    public static void appMenu() throws InterruptedException {
        androidHelperMethods.LaunchApp();
        androidHelperMethods.click(app_Menu);
    }
    public static void fragmentMenu() throws InterruptedException {
        androidHelperMethods.click(fragment_Menu);
    }

    public static void contextMenu() throws InterruptedException {
        androidHelperMethods.click(context_Menu);
    }

    public static void longTouchBtn() throws InterruptedException {
        androidHelperMethods.LongTouch(long_Press_Btn);
    }
    public static void checkMenuAandMenuB() throws InterruptedException {
        String menuA=androidHelperMethods.GetText(long_Press_Menu_A);
        String menuB=androidHelperMethods.GetText(long_Press_Menu_B);
        Assert.assertEquals(menuA,"Menu A");
        Assert.assertEquals(menuB,"Menu B");



    }
}
