package ui_tests.AlexMed;

import dataProvider.DPForRegistration;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginRegistrationPage;
import pages.StartPage;
import ui_tests.TestBase;



public class RegistrationTests extends TestBase {


    @Test(dataProvider = "DpFile_registrationPositiveTest", dataProviderClass = DPForRegistration.class,
    groups = {"positiveGroup"})
    public void registrationPositiveTest(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLoginRegistrationPage_clickButtonSignIn()
                .clickTabSignUp()
                .fillFormSignUp(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmit()
                .isTextElementPresent_Logout())
        ;
    }
    @Test(dataProvider = "DpFile_registrationNegativeTest_WrongEmail", dataProviderClass = DPForRegistration.class,
            groups = {"negativeGroup"})
    public void registrationNegativeTest_WrongEmail(UserModel user){
        Assert.assertTrue(new StartPage(driver)
                .openLoginRegistrationPage_clickButtonSignIn()
                .clickTabSignUp()
                .fillFormSignUp(UserModel.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .confirmPassword(user.getConfirmPassword())
                        .build())
                .clickButtonSubmitNegative()
                .isMessageErrorPresent_Email_not_valid())
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