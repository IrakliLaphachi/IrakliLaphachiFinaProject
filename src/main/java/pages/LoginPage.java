package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage  {

    private By pageLogo = By.cssSelector("[class=\"logo pull-left\"] img");
    private By loginTab = By.cssSelector("[href=\"/login\"]");
    private By signupForm = By.cssSelector("[class=\"signup-form\"]");

    private By signupName = By.cssSelector("[data-qa=\"signup-name\"]");
    private By signupEmail = By.cssSelector("[data-qa=\"signup-email\"]");
    private By signupButton = By.cssSelector("[data-qa=\"signup-button\"]");

    private By signupPageForm = By.cssSelector("[class=\"login-form\"]");
    private By signupTitle = By.id("uniform-id_gender1");
    private By signupPassword = By.id("password");
    private By signupDaySelector = By.id("days");
    private By signupMonthSelector = By.id("months");
    private By signupYearSelector = By.id("years");
    private By signupValue1 = By.cssSelector("[value=\"1\"]");
    private By signupNewsletter = By.id("newsletter");
    private By signupOffers = By.id("optin");

    private By signupFirstName = By.id("first_name");
    private By signupLastName = By.id("last_name");
    private By signupCompany = By.id("company");
    private By signupAddress1 = By.id("address1");
    private By signupAddress2 = By.id("address2");
    private By signupCountrySelector = By.id("country");
    private By signupCountryValue = By.cssSelector("[value=\"Canada\"]");
    private By signupState = By.id("state");
    private By signupCity = By.id("city");
    private By signupZipcode = By.id("zipcode");
    private By signupNumber = By.id("mobile_number");
    private By createAccountBtn = By.cssSelector("[data-qa=\"create-account\"]");
    private By accountCreated = By.cssSelector("[data-qa=\"account-created\"]");
    private By continueBtn = By.cssSelector("[data-qa=\"continue-button\"]");
    private By accountDeleteBtn = By.cssSelector("[href=\"/delete_account\"]");
    private By accountDeleted = By.cssSelector("[data-qa=\"account-deleted\"");
    private By logoutBtn = By.cssSelector("[href=\"/logout\"]");

    private By loginEmail = By.cssSelector("[data-qa=\"login-email\"]");
    private By loginPassword = By.cssSelector("[data-qa=\"login-password\"]");
    private By loginBtn = By.cssSelector("[data-qa=\"login-button\"]");
    private By loginFormError = By.cssSelector("[class=\"login-form\"] p");


    public LoginPage(WebDriver driver) {
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

    public void fillSignupFields(){
        type(signupName, "Test Name");
        type(signupEmail, "testirakli@gmail.com");
    }

    public void clickSignupButton(){
        click(signupButton);
    }

    public void checkNewUserSignup(){
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(signupPageForm, "ENTER ACCOUNT INFORMATION"))){
            System.out.println("Enter Info Text Is Visible");
        }
    }

    public void fillAccountInfo(){
        click(signupTitle);
        type(signupPassword, "test1234");
        click(signupDaySelector);
        click(signupValue1);
        click(signupMonthSelector);
        click(signupValue1);
        click(signupYearSelector);
        click(signupValue1);
        click(signupNewsletter);
        click(signupOffers);
    }

    public void fillAddressInfo(){
        type(signupFirstName, "Test");
        type(signupLastName, "Name");
        type(signupCompany, "Test Company Inc.");
        type(signupAddress1, "101 Test Str., Test Company Incorporated");
        type(signupAddress2, "Test City, Test State, Canada");
        click(signupCountrySelector);
        click(signupCountryValue);
        type(signupState, "Test State");
        type(signupCity, "Test City");
        type(signupZipcode, "1010101");
        type(signupNumber, "599555999");
    }

    public void clickCreateAccount(){
        click(createAccountBtn);
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(accountCreated, "ACCOUNT CREATED!"))){
            System.out.println("Account Created Text Is Visible");
        }
        click(continueBtn);
    }

    public void clickAccountDelete(){
        click(accountDeleteBtn);
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(accountDeleted, "ACCOUNT DELETED!"))){
            System.out.println("Account Deleted Text Is Visible");
        }
        click(continueBtn);
    }

    public void checkExistingAccount(){
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(signupForm, "Email Address already exist!"))){
            System.out.println("User Exists Text Is Visible");
        }
    }

    public void clickLogoutBtn(){
        click(logoutBtn);
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(signupForm, "Login to your account"))){
            System.out.println("Login Page Is Visible");
        }
    }

    public void fillIncorrectLoginFields(){
        type(loginEmail, "testirakli@gmail.com");
        type(loginPassword, "test12345");
    }

    public void checkIncorrectLogin(){
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(loginFormError, "Email Address already exist!"))){
            System.out.println("User Exists Text Is Visible");
        }
    }

    public void fillLoginFields(){
        type(loginEmail, "testirakli@gmail.com");
        type(loginPassword, "test1234");
    }

    public void checkLogin(){
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(signupForm, "Logged in as irakli"))){
            System.out.println("User Logged In Text Is Visible");
        }
    }

    public void clickLoginButton(){
        click(loginBtn);
    }
}
