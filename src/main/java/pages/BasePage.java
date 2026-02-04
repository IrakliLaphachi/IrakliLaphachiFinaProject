package pages;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "var ads = document.querySelectorAll('.adsbygoogle, .adsbygoogle-noablate');" +
                            "for(var i=0; i<ads.length; i++) { ads[i].remove(); }"
            );
            js.executeScript(
                    "document.documentElement.style.overflow = 'auto';" +
                            "document.body.style.overflow = 'auto';" +
                            "document.documentElement.classList.remove('google-anno-vignette');"
            );
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }
    }

    protected void type(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected void hover(By locator){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(driver.findElement(locator));
    }

    protected void clear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(Keys.CLEAR);
    }

    protected String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void uploadFile(By locator, String file) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    protected boolean checkText(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}