package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TestCasesPage extends BasePage{

    private By pageLogo = By.cssSelector("[class=\"logo pull-left\"] img");
    private By testCasesTab = By.cssSelector("[href=\"/test_cases\"]");
    private By testCaseTitle = By.cssSelector("h2[class=\"title\"]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    // Methods (actions)
    public void checkHomePage() {
        Assert.assertTrue(driver.findElement(pageLogo).isDisplayed(), "Home Page is visible");
    }

    public void clickTestCaseTab(){
        click(testCasesTab);
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(testCaseTitle, "Test Cases"))){
            System.out.println("Test Cases Tab Is Visible");
        }
    }
}
