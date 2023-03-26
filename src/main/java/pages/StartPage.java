package pages;

import helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPage extends PageHelper {
    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(text(),'Sign in')]")
    WebElement signInButton;
    @FindBy(css = ".sc-bUrLeq")
    WebElement signInForm;
    @FindBy (xpath = "//div[contains(text(),'Sign up')]")
    WebElement signUpButton;
    @FindBy(xpath = "//div[contains(text(),'Name:')]/..//input")
    WebElement nameField;
    //(//input[@class="sc-hJJRrs jCNhsI"])[1]

    @FindBy(xpath = "//div[contains(text(),'Email:')]/..//input")
    WebElement emailField;
    @FindBy(xpath = "//div[contains(text(),'Password:')]/..//input[@class=\"sc-hJJRrs jCNhsI\"]")
    WebElement password1;
    @FindBy(xpath = "//div[contains(text(),'Password:')]/..//input[@class=\"sc-hJJRrs kznLLG\"]")
    WebElement password2;
    @FindBy(xpath = "//div[@class=\"sc-bGqPaL hGSLKi\"]")
    WebElement submitButton;


    public void clickSignInButton() {
        click(signInButton);
    }

    public boolean signInFormIsVisible() {
        return signInForm.isDisplayed() && signUpButton.isDisplayed();
    }

    public void clickSignUpButton(){
        click(signUpButton);
    }

    public void fillNameField(String name){
        inputText(nameField, name);
    }

    public void fillEmailField(String name){
        inputText(emailField, name);
    }

    public void fillPassword1(String password) {
        inputText(password1, password);
    }

    public void fillPassword2(String password) {
        inputText(password2, password);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }
}
