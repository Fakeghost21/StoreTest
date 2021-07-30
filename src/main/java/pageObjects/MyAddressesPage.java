package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressesPage {
    WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@title=\"Add an address\"]")
    private WebElement addAnAddressButton;
    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement newAddress;
    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement newCity;
    @FindBy(xpath = "//*[@id=\"id_state\"]")
    private WebElement newState;
    @FindBy(xpath = "//*[@id=\"postcode\"]")
    private WebElement newPostcode;
    @FindBy(xpath = "//*[@id=\"phone_mobile\"]")
    private WebElement newMobilePhone;
    @FindBy(xpath = "//*[@id=\"submitAddress\"]")
    private WebElement saveTheAddressButton;
    @FindBy(id="alias")
    private WebElement alias;
    @FindBy(id="id_country")
    private WebElement country;
    @FindBy(xpath = "//*[@class=\"last_item alternate_item box\"]/li[9]/a[2]")
    private WebElement deleteAddressButton;
    public void clickAddAnAddressButton()
    {
        addAnAddressButton.click();
    }
    public void setNewAddress(String theNewAddress)
    {
        newAddress.sendKeys(theNewAddress);
    }
    public void setNewCity(String theNewCity)
    {
        newCity.sendKeys(theNewCity);
    }
    public void setNewState(String theNewState)
    {
        newState.sendKeys(theNewState);
    }
    public void setNewPostcode(String theNewPostcode)
    {
        newPostcode.sendKeys(theNewPostcode);
    }
    public void setNewMobilePhone(String theNewMobilePhone)
    {
        newMobilePhone.sendKeys(theNewMobilePhone);
    }
    public void clickSaveTheAddressButton()
    {
        saveTheAddressButton.click();
    }
    public void completingTheAlias(String theAlias)
    {
        alias.sendKeys(theAlias);
    }
    public void completingTheCustomerCountry(String theCountry)
    {
        country.sendKeys(theCountry);
    }
    public void clickDeleteTheAddressButton(){deleteAddressButton.click();
        driver.switchTo().alert().accept();}

}
