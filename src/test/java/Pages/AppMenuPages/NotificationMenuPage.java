package Pages.AppMenuPages;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import conts.NotificationPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class NotificationMenuPage extends BasePageClass implements NotificationPageVariables {
    private static WebDriverWait wait;

    @AndroidFindBy(xpath = APP_MENU)
    static MobileElement app_Menu;

    @AndroidFindBy(xpath = NOTIFICATION_MENU)
    static MobileElement notification_Menu;
    @AndroidFindBy(xpath = INCOMING_MESSAGE)
    static MobileElement incoming_Message;

    @AndroidFindBy(id = SHOW_NOTIFICATION_BTN)
    static MobileElement show_Notification_Btn;

    @AndroidFindBy(xpath = APP_NOTIFICATION_APP_NAME_TEXT)
    static MobileElement app_Notification_App_Name_Text;

    @AndroidFindBy(xpath = APP_NOTIFICATION_TITLE)
    static MobileElement app_Notification_Title;

    @AndroidFindBy(xpath = APP_NOTIFICATION_TEXT)
    static MobileElement app_Notification_Text;

    @AndroidFindBy(xpath = APP_NOTIFICATION_SCREEN)
    static MobileElement app_Notification_Screen;

    @AndroidFindBy(xpath = APP_NOTIFICATION_SCREEN_MESSAGE)
    static MobileElement app_Notification_Screen_Message;

    @AndroidFindBy(id = CLOSE_NOTIFICATIONS)
    static MobileElement close_App_Notif;


    public NotificationMenuPage(AndroidDriver driver) {
        super(driver);
    }

    public static void appMenu() throws InterruptedException {

       // extentTest.log(Status.INFO, "Senaryo adı belirlendi ve senaryo açıklaması eklendi.");
        // Senaryo adı ve açıklaması burada belirtilir.

        // Senaryo adı için diğer işlemler burada gerçekleştirilir.

        //extentTest.log(Status.PASS, "Senaryo başarıyla tamamlandı.");
        androidHelperMethods.LaunchApp();
        androidHelperMethods.click(app_Menu);
    }
    public static void fragmentMenu() throws InterruptedException {
        androidHelperMethods.click(notification_Menu);
    }

    public static void incomingMessage() throws InterruptedException {
        androidHelperMethods.click(incoming_Message);
    }
    public static void showNotificationBtn() throws InterruptedException {
        androidHelperMethods.click(show_Notification_Btn);
    }


    public static void checkNotifications() throws InterruptedException {
    androidHelperMethods.OpenNotifications();
    String AppName= androidHelperMethods.GetText(app_Notification_App_Name_Text);
    String NotificationTitle= androidHelperMethods.GetText(app_Notification_Title);
    String NotificationText= androidHelperMethods.GetText(app_Notification_Text);


    Assert.assertEquals(AppName,"API Demos");
    Assert.assertEquals(NotificationTitle,"Joe");
    Assert.assertEquals(NotificationText,"kthx. meet u for dinner. cul8r");

    }

    public static void clickNotificationAndCheck() throws InterruptedException {
        androidHelperMethods.click(app_Notification_Title);
        String NotificationScreenTitle= androidHelperMethods.GetText(app_Notification_Screen);
        String NotificationScreenMessage= androidHelperMethods.GetText(app_Notification_Screen_Message);
        Assert.assertTrue(NotificationScreenMessage.contains("kthx. meet u for dinner. cul8r"));
        androidHelperMethods.OpenNotifications();
        boolean checkNotifDeleted = androidHelperMethods.checkNotVisible(app_Notification_App_Name_Text);
        if (checkNotifDeleted == false){
            System.out.println("Notification is deleted");
        }
        androidHelperMethods.CloseNotifications(close_App_Notif);

    }
}
