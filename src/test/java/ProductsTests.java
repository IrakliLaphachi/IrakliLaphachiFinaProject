import base.TestBase;

import io.qameta.allure.Description;

import org.testng.annotations.Test;

import pages.ProductsPage;

import utils.DriverFactory;

public class ProductsTests extends TestBase {
    @Description("Verify View Product Details")
    @Test
    public void ProductViewTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        ProductsPage Product = new ProductsPage(DriverFactory.getDriver());
        Product.checkHomePage();
        Product.clickProductsTab();
        Product.checkViewProduct();
    }

    @Description("Verify Product Search Functionality")
    @Test
    public void ProductSearchTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        ProductsPage Products = new ProductsPage(DriverFactory.getDriver());
        Products.checkHomePage();
        Products.clickProductsTab();
        Products.fillSearchBar();
        Products.checkSearch();
    }

    @Description("Verify Product Add To Cart Functionality")
    @Test
    public void ProductToCartTest() {
        DriverFactory.getDriver().get("https://automationexercise.com/");
        ProductsPage Products = new ProductsPage(DriverFactory.getDriver());
        Products.checkHomePage();
        Products.clickProductsTab();
        Products.addProduct1ToCart();
        Products.addProduct2ToCart();
        Products.viewCart();
    }
}