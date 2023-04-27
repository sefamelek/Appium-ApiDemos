package Pages.AppMenuPages;


import actionHelper.AndroidHelperMethods;
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
        AndroidHelperMethods.logger.info("App Button Clicked");

    }
    public static void fragmentMenu() throws InterruptedException {
        androidHelperMethods.click(fragment_Menu);
        AndroidHelperMethods.logger.info("Fragment Button Clicked");

    }

    public static void hideAndShowMenu() throws InterruptedException {
        androidHelperMethods.click(hide_And_Show_Menu);
        AndroidHelperMethods.logger.info("Hide And Show Button Clicked");

    }

    public static void checkHideButtons() throws InterruptedException {

        boolean text1 = androidHelperMethods.checkVisible(text_Fragment_1);
        boolean text2 = androidHelperMethods.checkVisible(text_Fragment_2);
        boolean hideBtn1 = androidHelperMethods.checkVisible(hide_Btn_1);
        boolean hideBtn2 = androidHelperMethods.checkVisible(hide_Btn_2);
        Assert.assertEquals(text1,true);
        AndroidHelperMethods.logger.info("Texbox 1 visible");

        Assert.assertEquals(text2,true);
        AndroidHelperMethods.logger.info("Texbox 2 visible");

        Assert.assertEquals(hideBtn1,true);

        Assert.assertEquals(hideBtn2,true);

        String Hide1=androidHelperMethods.GetText(hide_Btn_1);
        String Hide2=androidHelperMethods.GetText(hide_Btn_2);
        Assert.assertEquals(Hide1,"HIDE");
        AndroidHelperMethods.logger.info("Hide Button 1 visible");
        Assert.assertEquals(Hide2,"HIDE");
        AndroidHelperMethods.logger.info("Hide Button 2 visible");


    }

    public static void clickAndCheckHideButtons() throws InterruptedException {
        androidHelperMethods.click(hide_Btn_2);
        AndroidHelperMethods.logger.info("Hide Button 2 clicked");

        boolean text2 = androidHelperMethods.checkNotVisible(text_Fragment_2);
        Assert.assertEquals(text2,false);
        AndroidHelperMethods.logger.info("Texbox 2 invisible");

        boolean text1 = androidHelperMethods.checkVisible(text_Fragment_1);
        boolean hideBtn1 = androidHelperMethods.checkVisible(hide_Btn_1);
        boolean hideBtn2 = androidHelperMethods.checkVisible(hide_Btn_2);
        Assert.assertEquals(text1,true);
        AndroidHelperMethods.logger.info("Texbox 1 visible");

        Assert.assertEquals(hideBtn1,true);
        Assert.assertEquals(hideBtn2,true);
        String Hide1=androidHelperMethods.GetText(hide_Btn_1);
        String Hide2=androidHelperMethods.GetText(hide_Btn_2);
        Assert.assertEquals(Hide1,"HIDE");
        AndroidHelperMethods.logger.info("Hide Button 1 visible");

        Assert.assertEquals(Hide2,"SHOW");
        AndroidHelperMethods.logger.info("Hide Button 2 invisible and Show Button visible");


    }
}
