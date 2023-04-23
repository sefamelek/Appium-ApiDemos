package Pages.AppMenuPages;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class ActivityPage extends BasePageClass {

    public static final String CONTINUE_BTN = "com.nobroker.app:id/bottomPermission";
    public static final String BUY_BTN ="com.nobroker.app:id/buyLayout";
    public static final String SEARCH_BTN="com.nobroker.app:id/searchEditBar";


    @AndroidFindBy(id = CONTINUE_BTN)
    MobileElement allowContinue_Btn;

    @AndroidFindBy(id = BUY_BTN)
    MobileElement but_Btn;

    @AndroidFindBy(id = SEARCH_BTN)
    MobileElement search_Btn;

    public ActivityPage(AndroidDriver driver) {
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
}
