package TestCases;

import org.testng.annotations.Test;

public class LoginTestCases extends BaseTest {


    @Test
    public void TEST_CASE_ONE() throws Exception {
        System.out.println("Sefaa");
        homePage.allowContinue_Btn();
        homePage.buyBtn();
        homePage.search_Btn();
        buyPage.click_two_Bhk();
        buyPage.click_three_Bhk();
    }
}
