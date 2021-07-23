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
    @FindBy(id="address1")
    private WebElement address;
    @FindBy(id="city")
    private WebElement city;
    @FindBy(id="id_state")
    private WebElement state;
    @FindBy(id="postcode")
    private WebElement postcode;
    @FindBy(id="id_country")
    private WebElement country;
    @FindBy(id="phone_mobile")
    private WebElement mobilePhone;
    @FindBy(id="alias")
    private WebElement alias;
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
    public void completingTheAddress(String theAddress){
        address.sendKeys(theAddress);
    }
    public void completingTheCustomerCity(String theCity)
    {
        city.sendKeys(theCity);
    }
    public void completingTheState(String newState)
    {
        state.sendKeys(newState);
    }
    public void completingThePostcode(String code)
    {
        postcode.sendKeys(code);
    }
    public void completingTheCustomerCountry(String theCountry)
    {
        country.sendKeys(theCountry);
    }
    public void completingTheCustomerMobilePhone(String theMobilePhone)
    {
        mobilePhone.sendKeys(theMobilePhone);
    }
    public void completingTheAlias(String theAlias)
    {
        alias.sendKeys(theAlias);
    }
    public void registerTheCustomer()
    {
        register.click();
    }


}

