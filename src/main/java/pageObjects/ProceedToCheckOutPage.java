package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

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
    @FindBy(xpath="//*[@class='cart_quantity_up btn btn-default button-plus']")
    private WebElement cartProductAddingQuantityButton;
    @FindBy(xpath="//*[@class='cart_quantity text-center']/input")
    private WebElement cartProductUnits;
    @FindBy(xpath="//*[@class='cart_total']/span")
    private WebElement cartTotal;
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
    public void uppingTheCartProductQuantity(int productQuantity)
    {
        for(int i=0;i<productQuantity;i++) {
            //Integer v = i+1;
            //Assert.assertEquals(v.toString(), cartProductUnits.getAttribute("value"));
            cartProductAddingQuantityButton.click();
        }
    }
    public void verifyCartProductQuantity()
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals("6", cartProductUnits.getAttribute("value"));
    }
    public void verifyCartTotal(double totalPrice)
    {
        double cartTotalPrice = Double.parseDouble(cartTotal.getText().split("[$]")[1]);
        //Assert.assertTrue(totalPrice==cartTotalPrice);
        //System.out.println(cartTotalPrice);
    }



}
