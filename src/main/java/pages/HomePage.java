package pages;

import helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageHelper {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //private By yourByIdendifier => By.XPath("//button[text()='Hello World']");
    @FindBy(xpath = "//div[@class='sc-fvhFOF eMfMFQ']")
    WebElement buttonLogout;

    //By buttonLogout1 = By.xpath("//div[@class='sc-fvhFOF eMfMFQ']");

    public boolean isTextElementPresent_Logout() {
        return isTextInElementPresent(buttonLogout, "Logout", 3);
        //return isTextInElementPresent(driver.findElement(buttonLogout1), "Logout", 3);
    }

    public StartPage clickButtonLogout(){
        //click(driver.findElement(buttonLogout1));
        click(buttonLogout);
        return new StartPage(driver);
    }
}
