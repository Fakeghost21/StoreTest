package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatingAccountPage {
    WebDriver driver;

    public CreatingAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="customer_firstname")
    private WebElement customerFirstName;
    @FindBy(id="customer_lastname")
    private WebElement customerLastName;
    @FindBy(id="passwd")
    private WebElement customerPassword;
    @FindBy(id="firstname")
    private WebElement ownerOfTheAddressFirstName;
    @FindBy(id="lastname")
    private WebElement ownerOfTheAddressLastName;
    @FindBy(id="submitAccount")
    private WebElement register;

    public void completingCustomerName(String newCustomerName) {
        customerFirstName.sendKeys(newCustomerName.split(" ")[0]);
        customerLastName.sendKeys(newCustomerName.split(" ")[1]);
        ownerOfTheAddressFirstName.sendKeys(newCustomerName.split(" ")[0]);
        ownerOfTheAddressLastName.sendKeys(newCustomerName.split(" ")[1]);
    }
    public void completingCustomerPassword(String thePassword)
    {
     customerPassword.sendKeys(thePassword);
    }
    public void registerTheCustomer()
    {
        register.click();
    }


}

