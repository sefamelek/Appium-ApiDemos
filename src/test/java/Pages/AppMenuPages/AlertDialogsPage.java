package Pages.AppMenuPages;


import conts.AlertDialogPageVariables;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;

import java.util.Random;



public class AlertDialogsPage extends BasePageClass implements AlertDialogPageVariables {



    @AndroidFindBy(xpath = APP_MENU)
    static MobileElement app_Menu;

    @AndroidFindBy(xpath = ALERT_DIALOG)
    static MobileElement alert_Dialog;
    @AndroidFindBy(id = LIST_DIALOG)
    static MobileElement list_Dialog;

    @AndroidFindBy(xpath = COMMAND_ELEMENTS)
    static MobileElement command_Element;

    @AndroidFindBy(id = ALERT_TEXT)
    static MobileElement alert_Text;


    public AlertDialogsPage(AndroidDriver driver) {
        super(driver);
    }




    public static void appMenu() throws InterruptedException {
        androidHelperMethods.click(app_Menu);
    }

    public static void listDialog() throws InterruptedException {
        androidHelperMethods.click(list_Dialog);
    }

    public static void alertDialog() throws InterruptedException {
        androidHelperMethods.click(alert_Dialog);
    }
    public static void SelectCommandElementAndCheckAlert() throws InterruptedException {
        int numberOfElements = androidHelperMethods.CheckListSizeforXpath(COMMAND_ELEMENTS,command_Element);
        Random rand = new Random();
        int randomNumber = rand.nextInt(numberOfElements) + 1;
        System.out.println("Selected Command " + randomNumber);
        String COMMAND_ELEMENT_XPATH= COMMAND_ELEMENTS + "[" +randomNumber + "]";
        androidHelperMethods.clickbyXpath(COMMAND_ELEMENT_XPATH);
        String alertText=androidHelperMethods.GetText(alert_Text);
        if (randomNumber==1){
            Assert.assertEquals(alertText,"You selected: 0 , Command one");
        }
        else if (randomNumber==2){
            Assert.assertEquals(alertText,"You selected: 1 , Command two");
        }
        else if (randomNumber==3){
            Assert.assertEquals(alertText,"You selected: 2 , Command three");
        }
        else if (randomNumber==4){
            Assert.assertEquals(alertText,"You selected: 3 , Command four");
        }

    }

}
