package pages;

import helpers.PageHelper;
import models.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends PageHelper {
    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Cancel']")
    WebElement buttonCansel;

    @FindBy(xpath = "//div[text()='Submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='sc-edoYdd cZhezb']")
    WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='sc-edoYdd WPXJZ']")
    WebElement buttonSignUp;

    @FindBy(xpath = "//input[@placeholder='Peter']")
    WebElement name;

    @FindBy(xpath = "//input[@placeholder='peter@gmail.com']")
    WebElement email;

    @FindBy(xpath = "//div[@class='sc-jlIlqL CnIuH']/div[3]/input")
    WebElement password;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordLogin;

    @FindBy(xpath = "//div[@class='sc-jlIlqL CnIuH']/div[4]/input")
    WebElement confirmPassword;

    @FindBy(xpath = "//div[@class='sc-fxNMLY bXYHzn']")
    WebElement buttonForgotPassword;

    @FindBy(xpath = "//div[text()='Email not valid']")
    WebElement errorMessage_WrongEmail;

    @FindBy(xpath = "//div[@class='sc-hYAvtR exMbkk']")
    WebElement errorMessage_PasNotMatch;

    @FindBy(xpath = "//div[@class='sc-hYAvtR exMbkk']")
    WebElement errorMessage_UserExist;

    @FindBy(xpath = "//div[@class='sc-dkaWRx ikqQip']")
    WebElement text_PasswordMustHave;

    public boolean isTextPresent_ForgotPassword(){
        return isTextInElementPresent(buttonForgotPassword, "Forgot password?", 5);
    }

    public LoginRegistrationPage clickTabSignUp() {
        click(buttonSignUp);
        return this;
    }

    public LoginRegistrationPage fillFormSignUp(UserModel user) {
        inputText(name, user.getName());
        inputText(email, user.getEmail());
        inputText(password, user.getPassword());
        inputText(confirmPassword, user.getConfirmPassword());
        return this;
    }

    public HomePage clickButtonSubmit() {
        click(buttonSubmit);
        return new HomePage(driver);
    }

    public LoginRegistrationPage clickButtonSubmitNegative() {
        click(buttonSubmit);
        return this;
    }

    public boolean isMessageErrorPresent_Email_not_valid() {
        return isTextInElementPresent(errorMessage_WrongEmail, "Email not valid", 5);
    }

    public StartPage clickButtonCansel(){
        buttonCansel.click();
        return new StartPage(driver);
    }

    public LoginRegistrationPage fillFormSignIn(UserModel user) {
        inputText(email, user.getEmail());
        inputText(passwordLogin, user.getPassword());
        return this;
    }
}
