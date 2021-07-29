package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage {
    WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="email")

    private WebElement emailAddress;
    @FindBy(id="passwd")
    private WebElement password;
    @FindBy(xpath="//*[@class='icon-lock left']")
    private WebElement signInButton;
    @FindBy(xpath = "//*[@title=\"My wishlists\"]")
    private WebElement myWishlistsButton;
    @FindBy(xpath = "//*[@title=\"Addresses\"]")
    private WebElement myAddressesButton;
    public void clickMyWishlistsButton()
    {
        myWishlistsButton.click();
    }
    public void enterEmailAddress(String emailAddress1){

        emailAddress.sendKeys(emailAddress1);
    }
    public void enterPassword(String expectedPassword){
        password.sendKeys(expectedPassword);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickMyAddressesButton()
    {
        myAddressesButton.click();

    }
}

