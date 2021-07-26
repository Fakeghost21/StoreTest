package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProceedToCheckOutPage {
    WebDriver driver;

    public ProceedToCheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath="//*[@class='shopping_cart']/a")
    private WebElement shoppingCart;
    @FindBy(xpath="//*[@id=\"button_order_cart\"]")
    private WebElement proceedToCheckout;
    @FindBy(xpath="//*[@class=\"cart_description\"]/p/a")
    private WebElement cartProductName;
    @FindBy(xpath ="//*[@class=\"cart_description\"]/small[2]/a")
    private WebElement cartProductDescription;
    @FindBy(xpath="//*[@class=\"cart_unit\"]/span/span")
    private WebElement cartProductUnitPrice;
    public void proceedToCheckout(Actions a)
    {
        a.moveToElement(shoppingCart).perform();
        proceedToCheckout.click();
        //a.moveToElement(proceedToCheckout);
        //a.click().build().perform();
        //driver.findElement(By.xpath("//*[@id=\"button_order_cart\"]")).click();
    }
    public void verifyProductName(String productName)
    {
        Assert.assertEquals(productName,cartProductName.getText());
    }
    public void verifyProductDescription(String productDescription)
    {
        Assert.assertEquals(productDescription,cartProductDescription.getText());
    }
    public void verifyProductUnitPrice(String productUnitPrice)
    {
        Assert.assertEquals(productUnitPrice, cartProductUnitPrice.getText());
    }




}
