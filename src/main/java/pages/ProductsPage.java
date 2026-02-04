package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage{

    private By pageLogo = By.cssSelector("[class=\"logo pull-left\"] img");
    private By productsTab = By.cssSelector("[href=\"/products\"]");
    private By productsContainer = By.cssSelector("[class=\"features_items\"]");
    private By productsTitle = By.cssSelector("[class=\"features_items\"] [class=\"title text-center\"]");
    private By viewProduct1 = By.cssSelector("[href=\"/product_details/1\"]");
    private By productInfo = By.cssSelector("[class=\"product-information\"]");
    private By searchBar = By.id("search_product");
    private By searchBtn = By.id("submit_search");
    private By productCardText = By.cssSelector("[class=\"col-sm-4\"]:nth-child(1) p");
    private By productCard1 = By.cssSelector("[class=\"col-sm-4\"]:nth-child(1)");
    private By productAdd1 = By.cssSelector("[data-product-id=\"1\"]");
    private By continueShopping = By.cssSelector("[data-dismiss=\"modal\"]");
    private By productCard2 = By.cssSelector("[class=\"col-sm-4\"]:nth-child(2)");
    private By productAdd2 = By.cssSelector("[data-product-id=\"2\"]");
    private By viewCartBtn = By.cssSelector("[href=\"/view_cart\"]");
    private By cartTable = By.id("cart_info_table");
    private By cartItem1Title = By.cssSelector("[id=\"product-1\"] h4");
    private By cartItem1Price = By.cssSelector("[id=\"product-1\"] [class=\"cart_price\"]");
    private By cartItem2Title = By.cssSelector("[id=\"product-1\"] h4");
    private By cartItem2Price = By.cssSelector("[id=\"product-1\"] [class=\"cart_price\"]");


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

    public void fillSearchBar(){
        type(searchBar, "Blue Top");
        click(searchBtn);
    }

    public void checkSearch(){
        if (checkText(productsTitle, "SEARCHED PRODUCTS") && checkText(productCardText, "Blue Top")){
            System.out.println("Searched Text & Searched Product Is Visible");
        }
    }

    public void addProduct1ToCart(){
        hover(productCard1);
        click(productAdd1);
        click(continueShopping);
    }

    public void addProduct2ToCart(){
        hover(productCard2);
        click(productAdd2);
    }

    public void viewCart(){
        click(viewCartBtn);
        Assert.assertTrue(driver.findElement(cartTable).isDisplayed(), "Cart is visible");
    }
}
