package ui_tests.OlgaCh;

import helpers.DataHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StartPage;
import ui_tests.TestBase;

public class RegistrationTests extends TestBase {
    StartPage startPage;

    @BeforeMethod
    public void pageInit(){
        startPage = PageFactory.initElements(driver, StartPage.class);
    }

    @Test
    public void registrationPositiveTest(){
        String email = DataHelper.generateEmail(4);
        String name = "Name" + DataHelper.randomNumeric(4);
        String password = "Qwe" + DataHelper.randomNumeric(6);

        startPage.clickSignInButton();
        Assert.assertTrue(startPage.signInFormIsVisible());
        startPage.clickSignUpButton();
        startPage.fillNameField(name);
        startPage.fillEmailField(email);
        startPage.fillPassword1(password);
        startPage.fillPassword2(password);
        startPage.clickSubmitButton();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
