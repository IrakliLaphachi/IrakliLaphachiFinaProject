import base.TestBase;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

import pages.ContactUsPage;

import utils.DriverFactory;

public class ContactUsTests extends TestBase {
    @Description("Verify Contact Us Form")
    @Test (priority = 1)
    public void SubmitContactUsTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        ContactUsPage Contact = new ContactUsPage(DriverFactory.getDriver());
        Contact.checkHomePage();
        Contact.clickContactUsTab();
        Contact.fillContactForm();
        Contact.clickContactSubmit();
    }
}