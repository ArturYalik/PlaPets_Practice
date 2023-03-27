package ui_tests.ArturYalik;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.StartPage;

public class SingIn_Test extends TestBase {
    StartPage startPage;
    @BeforeMethod
    public void pageInit(){
        startPage = PageFactory.initElements(driver, StartPage.class);
    }

    @Test
    public void singInPositiveTest(){
        String email = "asd@mail.com";
        String password = "qwerty1699!";

        startPage.clickSignInButton();
        Assert.assertTrue(startPage.signInFormIsVisible());
        startPage.fillEmailField(email);
        startPage.fillPassword(password);
        startPage.clickSubmitButton();
        Assert.assertTrue(startPage.homeButtonVisible());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
