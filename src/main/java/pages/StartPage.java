package pages;

import helpers.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends PageHelper {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Sign in']")
    WebElement buttonSignIn;

    @FindBy(xpath = "//span[text()='I lost my pet!']")
    WebElement buttonILostMyPet;

    @FindBy(xpath = "//span[text()='I found a pet!']")
    WebElement buttonIFoundAPet;

    @FindBy(xpath = "//span[text()='join']")
    WebElement buttonJoin;

    public LoginRegistrationPage openLoginRegistrationPage_clickButtonSignIn(){
        click(buttonSignIn);
        return new LoginRegistrationPage(driver);
    }
}
