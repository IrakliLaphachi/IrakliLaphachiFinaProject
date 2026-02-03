import base.TestBase;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

import pages.LoginPage;

import utils.DriverFactory;

public class UserTests extends TestBase {
    @Description("Verify Registering New User")
    @Test (priority = 1)
    public void NewUserTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        LoginPage NewUser = new LoginPage(DriverFactory.getDriver());
        NewUser.checkHomePage();
        NewUser.clickLoginTab();
        NewUser.fillSignupFields();
        NewUser.clickSignupButton();
        NewUser.checkNewUserSignup();
        NewUser.fillAccountInfo();
        NewUser.fillAddressInfo();
        NewUser.clickCreateAccount();
    }

    @Description("Verify Registering Existing User")
    @Test (priority = 2, dependsOnMethods = "NewUserTest")
    public void ExistingUser(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        LoginPage ExistingUser = new LoginPage(DriverFactory.getDriver());
        ExistingUser.checkHomePage();
        ExistingUser.clickLoginTab();
        ExistingUser.fillSignupFields();
        ExistingUser.clickSignupButton();
        ExistingUser.checkExistingAccount();
    }

    @Description("Verify Incorrect User Login")
    @Test (priority = 3)
    public void IncorrectLogin(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        LoginPage IncorrectUser = new LoginPage(DriverFactory.getDriver());
        IncorrectUser.checkHomePage();
        IncorrectUser.clickLoginTab();
        IncorrectUser.fillIncorrectLoginFields();
        IncorrectUser.clickLoginButton();
        IncorrectUser.checkIncorrectLogin();
    }

    @Description("Verify Correct User Login")
    @Test (priority = 4, dependsOnMethods = "NewUserTest")
    public void CorrectLogin(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        LoginPage CorrectUser = new LoginPage(DriverFactory.getDriver());
        CorrectUser.checkHomePage();
        CorrectUser.clickLoginTab();
        CorrectUser.fillLoginFields();
        CorrectUser.clickLoginButton();
        CorrectUser.checkLogin();
    }

    @Description("Verify User Logout")
    @Test (priority = 5, dependsOnMethods = "CorrectLogin")
    public void UserLogout(){
        DriverFactory.getDriver().get("https://automationexercise.com/");
        LoginPage UserLogout = new LoginPage(DriverFactory.getDriver());
        UserLogout.clickLoginTab();
        UserLogout.fillLoginFields();
        UserLogout.clickLoginButton();
        UserLogout.clickLogoutBtn();
    }
}