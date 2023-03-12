package ui_tests.AlexMed;

import dataProvider.DPForLogin;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginRegistrationPage;
import pages.StartPage;
import ui_tests.TestBase;

public class LoginTests extends TestBase {

    @Test(dataProvider = "DpFile_loginPositiveTest", dataProviderClass = DPForLogin.class,
            groups = {"positiveGroup"})
    public void loginPositiveTest(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLoginRegistrationPage_clickButtonSignIn()
                .fillFormSignIn(UserModel.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .clickButtonSubmit()
                .isTextElementPresent_Logout())
                ;
    }

    @Test(dataProvider = "DpFile_loginNegativeTest_WrongEmail", dataProviderClass = DPForLogin.class,
            groups = {"negativeGroup"})
    public void loginNegativeTest_WrongEmail(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLoginRegistrationPage_clickButtonSignIn()
                .fillFormSignIn(UserModel.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isTextPresent_ForgotPassword())
                ;
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        HomePage homePage = new HomePage(driver);
        if (homePage.isTextElementPresent_Logout())
            homePage.clickButtonLogout();
        else new LoginRegistrationPage(driver).clickButtonCansel();
    }
}
