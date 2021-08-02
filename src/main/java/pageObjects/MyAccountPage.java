package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath="//*[@class='info-account']")
    private WebElement welcomeMsg;
    @FindBy(xpath="//*[@class='logout']")
    private WebElement logOut;
    @FindBy(xpath="//*[@class='is_required validate account_input form-control']")
    private WebElement emailAddress;
    @FindBy(id="SubmitCreate")
    private WebElement createAccountButton;
    @FindBy(xpath = "//*[@title=\"My wishlists\"]")
    private WebElement myWishlistsButton;
    @FindBy(xpath = "//*[@title=\"Addresses\"]")
    private WebElement myAddressesButton;
    @FindBy(xpath = "//*[@title=\"Information\"]")
    private WebElement myPersonalInformationButton;
    public void clickMyAddressesButton()
    {
        myAddressesButton.click();

    }
    public void clickMyWishlistsButton()
    {
        myWishlistsButton.click();
    }
    public void clickMyPersonalInformationButton(){myPersonalInformationButton.click();}
    public void verifyWelcomeMsg(String expectedWelcomeMsg){
        Assert.assertEquals(expectedWelcomeMsg, welcomeMsg.getText());
    }
    public void loggingOut(){
        logOut.click();
    }
    public void typingEmailAddress(String newEmail)
    {
        emailAddress.sendKeys(newEmail);
    }
    public void creatingNewAccount()
    {
        createAccountButton.click();
    }

}
