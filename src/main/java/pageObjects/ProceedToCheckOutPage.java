package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(xpath = "//*[@id=\"total_shipping\"]")
    private WebElement cartTotalShipping;
    @FindBy(xpath="//*[@id=\"total_price\"]")
    private WebElement cartTotalPrice;
    @FindBy(xpath = "//*[@class=\"cart_navigation clearfix\"]/a[1]")
    private WebElement proceedToCheckoutButtonToTheAddress;
    @FindBy(xpath="//*[@name=\"processAddress\"]")
    private WebElement proceedToCheckoutButtonToTheShipping;
    @FindBy(xpath = "//*[@name=\"delivery_option[541694]\"]")
    private WebElement shippingOptionBox;
    @FindBy(xpath="//*[@name=\"cgv\"]")
    private WebElement termsOfServiceBox;
    @FindBy(xpath = "//*[@name=\"processCarrier\"]")
    private WebElement proceedToCheckoutButtonToThePayment;
    @FindBy(xpath="//*[@class=\"bankwire\"]")
    private WebElement payByBankWireButton;
    @FindBy(xpath="//*[@class=\"cheque-indent\"]/strong")
    private WebElement confirmationOfPaymentByBankWire;
    @FindBy(xpath="//*[@class=\"cheque-indent\"]/strong")
    private WebElement confirmationOfTheOrder;
    @FindBy(xpath="//*[@class=\"button btn btn-default button-medium\"]")
    private WebElement confirmTheOrderButton;
    public void proceedToCheckout(Actions a)
    {
        //hover over the element then click in the hover result
        a.moveToElement(shoppingCart).perform();
        proceedToCheckout.click();

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

    public void verifyCartProductQuantity()
    {
        Assert.assertEquals("1", cartProductUnits.getAttribute("value"));
        cartProductAddingQuantityButton.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.attributeContains(cartProductUnits,"value","2")));

    }
    public void verifyCartTotalDelivery()
    {
        //double cartTotalPrice = Double.parseDouble(cartTotal.getText().split("[$]")[1]);
        //Assert.assertEquals(54.00,cartTotalPrice,0.01);
        Assert.assertEquals(cartTotal.getText(),"$54.00");
        Assert.assertEquals(cartTotalShipping.getText(),"$2.00");
        Assert.assertEquals(cartTotalPrice.getText(),"$56.00");

    }
    public void proceedToCheckoutToTheAddress()
    {
        proceedToCheckoutButtonToTheAddress.click();
    }
    public void proceedToCheckoutButtonToTheShipping()
    {
        proceedToCheckoutButtonToTheShipping.click();
    }
    public void verifyTheShippingOptionBox()
    {
        Assert.assertTrue(shippingOptionBox.isSelected());
    }
    public void checkTheTermsOfServiceBox()
    {
        termsOfServiceBox.click();
    }
    public void proceedToCheckoutButtonToThePayment()
    {
        proceedToCheckoutButtonToThePayment.click();
    }
    public void payByBankWire()
    {
        payByBankWireButton.click();
    }
    public void verifyConfirmationOfPaymentByBankWire()
    {
        Assert.assertEquals("You have chosen to pay by bank wire. Here is a short summary of your order:",confirmationOfPaymentByBankWire.getText());
    }
    public void confirmTheOrder()
    {
        confirmTheOrderButton.click();
        Assert.assertEquals("Your order on My Store is complete.",confirmationOfTheOrder.getText());
    }
}
