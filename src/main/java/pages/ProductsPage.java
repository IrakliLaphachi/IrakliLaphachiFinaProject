package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage{

    private By pageLogo = By.cssSelector("[class=\"logo pull-left\"] img");
    private By productsTab = By.cssSelector("[href=\"/products\"]");
    private By productsContainer = By.cssSelector("[class=\"features_items\"]");
    private By viewProduct1 = By.cssSelector("[href=\"/product_details/1\"]");
    private By productInfo = By.cssSelector("[class=\"product-information\"]");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // Methods (actions)
    public void checkHomePage() {
        Assert.assertTrue(driver.findElement(pageLogo).isDisplayed(), "Home Page is visible");
    }

    public void clickProductsTab(){
        click(productsTab);
        Assert.assertTrue(driver.findElement(productsContainer).isDisplayed(), "Products Page is visible");
    }

    public void checkViewProduct(){
        click(viewProduct1);
        if (checkText(productInfo, "Blue Top") &&
                checkText(productInfo, "Category: Women > Tops") &&
                checkText(productInfo, "Rs. 500") &&
                checkText(productInfo, "Availability: In Stock") &&
                checkText(productInfo, "Condition: New") &&
                checkText(productInfo, "Brand: Polo")){
            System.out.println("Product Information Text Is Visible");
        }
    }
}
