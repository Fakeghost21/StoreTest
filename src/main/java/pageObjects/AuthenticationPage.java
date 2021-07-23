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
    public void enterEmailAddress(String emailAddress1){

        emailAddress.sendKeys(emailAddress1);
    }
    public void enterPassword(String expectedPassword){
        password.sendKeys(expectedPassword);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
