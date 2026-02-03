package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverFactory;
import org.testng.Assert;

public class HomePage extends BasePage  {

    private By pageLogo = By.cssSelector("[class=\"logo pull-left\"] img");
    private By loginTab = By.cssSelector("[href=\"/login\"]");
    private By signupForm = By.cssSelector("[class=\"signup-form\"]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Methods (actions)
    public void checkHomePage() {
        Assert.assertTrue(driver.findElement(pageLogo).isDisplayed(), "Home Page is visible");
    }

    public void clickLoginTab(){
        click(loginTab);
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(signupForm, "New User Signup!"))){
            System.out.println("Sign Up Text Is Visible");
        }
    }
}
