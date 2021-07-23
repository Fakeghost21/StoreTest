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
    private WebElement emailAdress;
    @FindBy(id="SubmitCreate")
    private WebElement createAccountButton;

    public void verifyWelcomeMsg(String expectedWelcomeMsg){
        Assert.assertTrue(expectedWelcomeMsg.equals(welcomeMsg.getText()));
    }
    public void loggingOut(){
        logOut.click();
    }
    public void typingEmailAddress(String newEmail)
    {
        emailAdress.sendKeys(newEmail);
    }
    public void creatingNewAccount()
    {
        createAccountButton.click();
    }
}
