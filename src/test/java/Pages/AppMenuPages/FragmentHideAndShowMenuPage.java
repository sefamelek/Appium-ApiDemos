package Pages.AppMenuPages;


import conts.AppMenu.FragmentHideAndShowMenuPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class FragmentHideAndShowMenuPage extends BasePageClass implements FragmentHideAndShowMenuPageVariables {
    private static WebDriverWait wait;

    @AndroidFindBy(xpath = APP_MENU)
    static MobileElement app_Menu;

    @AndroidFindBy(xpath = FRAGMENT_MENU)
    static MobileElement fragment_Menu;
    @AndroidFindBy(xpath = HIDE_AND_SHOW_MENU)
    static MobileElement hide_And_Show_Menu;

    @AndroidFindBy(id = HIDE_BUTTON_1)
    static MobileElement hide_Btn_1;

    @AndroidFindBy(id = HIDE_BUTTON_2)
    static MobileElement hide_Btn_2;

    @AndroidFindBy(id = TEXT_FRAGMENT_1)
    static MobileElement text_Fragment_1;

    @AndroidFindBy(id = TEXT_FRAGMENT_2)
    static MobileElement text_Fragment_2;

    public FragmentHideAndShowMenuPage(AndroidDriver driver) {
        super(driver);
    }



    public static void appMenu() throws InterruptedException {
        androidHelperMethods.LaunchApp();
        androidHelperMethods.click(app_Menu);
    }
    public static void fragmentMenu() throws InterruptedException {
        androidHelperMethods.click(fragment_Menu);
    }

    public static void hideAndShowMenu() throws InterruptedException {
        androidHelperMethods.click(hide_And_Show_Menu);
    }

    public static void checkHideButtons() throws InterruptedException {

        boolean text1 = androidHelperMethods.checkVisible(text_Fragment_1);
        boolean text2 = androidHelperMethods.checkVisible(text_Fragment_2);
        boolean hideBtn1 = androidHelperMethods.checkVisible(hide_Btn_1);
        boolean hideBtn2 = androidHelperMethods.checkVisible(hide_Btn_2);
        Assert.assertEquals(text1,true);
        Assert.assertEquals(text2,true);
        Assert.assertEquals(hideBtn1,true);
        Assert.assertEquals(hideBtn2,true);
        String Hide1=androidHelperMethods.GetText(hide_Btn_1);
        String Hide2=androidHelperMethods.GetText(hide_Btn_2);
        Assert.assertEquals(Hide1,"HIDE");
        Assert.assertEquals(Hide2,"HIDE");

    }

    public static void clickAndCheckHideButtons() throws InterruptedException {
        androidHelperMethods.click(hide_Btn_2);
        boolean text2 = androidHelperMethods.checkNotVisible(text_Fragment_2);
        Assert.assertEquals(text2,false);

        boolean text1 = androidHelperMethods.checkVisible(text_Fragment_1);
        boolean hideBtn1 = androidHelperMethods.checkVisible(hide_Btn_1);
        boolean hideBtn2 = androidHelperMethods.checkVisible(hide_Btn_2);
        Assert.assertEquals(text1,true);
        Assert.assertEquals(hideBtn1,true);
        Assert.assertEquals(hideBtn2,true);
        String Hide1=androidHelperMethods.GetText(hide_Btn_1);
        String Hide2=androidHelperMethods.GetText(hide_Btn_2);
        Assert.assertEquals(Hide1,"HIDE");
        Assert.assertEquals(Hide2,"SHOW");

    }
}
