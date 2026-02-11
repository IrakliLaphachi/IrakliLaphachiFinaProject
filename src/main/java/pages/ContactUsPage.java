package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.DriverFactory;

public class ContactUsPage extends BasePage  {

    private By pageLogo = By.cssSelector("[class=\"logo pull-left\"] img");
    private By contactUsTab = By.cssSelector("[href=\"/contact_us\"]");
    private By contactForm = By.cssSelector("[class=\"contact-form\"]");

    private By contactName = By.cssSelector("[data-qa=\"name\"]");
    private By contactEmail = By.cssSelector("[data-qa=\"email\"]");
    private By contactSubject = By.cssSelector("[data-qa=\"subject\"]");
    private By contactMessage = By.cssSelector("[data-qa=\"message\"]");
    private By contactFile = By.cssSelector("[name=\"upload_file\"]");
    private By contactSubmit = By.cssSelector("[data-qa=\"submit-button\"]");


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    // Methods (actions)
    public void checkHomePage() {
        Assert.assertTrue(driver.findElement(pageLogo).isDisplayed(), "Home Page is visible");
    }

    public void clickContactUsTab() {
        click(contactUsTab);
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(contactForm, "GET IN TOUCH"))){
            System.out.println("Contact Us Text Is Visible");
        }
    }

    public void fillContactForm(){
        type(contactName, "Test Name");
        type(contactEmail, "testirakli@gmail.com");
        type(contactSubject, "Test Contact Us Subject");
        type(contactMessage, "Test Contact Us Message");
        uploadFile(contactFile,"src/test/resources/files/PlaceholderImage.jpg");
    }

    public void clickContactSubmit(){
        click(contactSubmit);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(contactForm, "Success! Your details have been submitted successfully"))){
            System.out.println("Submitted Text Is Visible");
        }
    }
}
