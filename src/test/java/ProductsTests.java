import base.TestBase;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

import pages.ProductsPage;

import utils.DriverFactory;

public class ProductsTests extends TestBase {
    @Description("Verify View Product Details")
    @Test (priority = 1)
    public void ProductViewTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        ProductsPage Contact = new ProductsPage(DriverFactory.getDriver());
        Contact.checkHomePage();
        Contact.clickProductsTab();
        Contact.checkViewProduct();
    }
}