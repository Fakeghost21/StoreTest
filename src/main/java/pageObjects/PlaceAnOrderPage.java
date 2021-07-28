package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class PlaceAnOrderPage {
    WebDriver driver;

    public PlaceAnOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath= "//*[@class='sf-with-ul']")
    private WebElement storeWomen;
    private WebElement storeWomenTops;
    @FindBy(xpath="//*[@id=\"subcategories\"]/ul/li[2]/div/a")
    private WebElement storeWomenTopsBlouses;
    @FindBy(xpath="//*[@class='product_list grid row']/li")
    private WebElement storeWomenOrderContainer;
    @FindBy(id="color_8")
    private WebElement storeWomenTopsBlousesWhite;
    @FindBy(xpath="//*[@class='exclusive']")
    private WebElement addToCartButton;
    @FindBy(xpath="//*[@class='button-container']/span")
    private WebElement continueShoppingButton;
    @FindBy(xpath="//*[@class='shopping_cart']/a/span")
    private WebElement cartQuantity;
    @FindBy(xpath="//*[@class=\"submenu-container clearfix first-in-line-xs\"]/li/ul/li/a")
    private WebElement storeWomenTShirts;
    @FindBy(xpath = "//*[@class=\"wishlist\"]/a")
    private WebElement addToWishlistButton;
    @FindBy(xpath = "//*[@title='View my customer account']")
    private WebElement viewMyCustomerAccountButton;
    public void accessTheStoreTops(Actions a)
    {
        a.moveToElement(storeWomen);
        storeWomenTops = driver.findElement(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul/li/a"));
        a.moveToElement(storeWomenTops);
        a.click().build().perform();
        //storeWomen.click();
    }
    public void accessTheStoreTShirts(Actions a)
    {
        a.moveToElement(storeWomen);
        a.moveToElement(storeWomenTShirts);
        a.click().build().perform();
    }
    public void addTShirtToTheWishlist(Actions a)
    {
        a.moveToElement(storeWomenOrderContainer);
        a.moveToElement(addToWishlistButton);
        a.click().build().perform();
    }
    public void clickOnViewMyAccountButton()
    {
        viewMyCustomerAccountButton.click();
    }
    public void accessTheStoreTopsBlouses()
    {
        storeWomenTopsBlouses.click();
    }
    public void changeTheColourOfTheBlouse(Actions a)
    {
        a.moveToElement(storeWomenOrderContainer);
        a.moveToElement(storeWomenTopsBlousesWhite);
        a.click().build().perform();
    }
    public void addToCart()
    {
        addToCartButton.click();
    }
    public void continueShopping()
    {
        continueShoppingButton.click();
    }
    public void verifyQuantity(String expectedQuantity)
    {
        Assert.assertEquals(expectedQuantity, cartQuantity.getText());
    }

}

