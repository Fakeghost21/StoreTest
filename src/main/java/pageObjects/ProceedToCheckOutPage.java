package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProceedToCheckOutPage {
    WebDriver driver;

    public ProceedToCheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath="//*[@class='button-container']/a")
    private WebElement proceedToCheckout;
    public void checkingOut()
    {
        proceedToCheckout.click();
    }
}
