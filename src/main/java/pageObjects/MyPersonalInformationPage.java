package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPersonalInformationPage {
    WebDriver driver;

    public MyPersonalInformationPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    private WebElement userFirstnameTextBox;
    @FindBy(xpath = "//*[@id=\"lastname\"]")
    private WebElement userLastnameTextBox;
    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement userEmailTextBox;
    @FindBy(xpath = "//*[@id=\"old_passwd\"]")
    private WebElement userOldPasswordTextBox;
    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement userNewPasswordTextBox;
    @FindBy(xpath = "//*[@id=\"confirmation\"]")
    private WebElement userNewPasswordConfirmationTextBox;
    @FindBy(xpath = "//*[@name=\"submitIdentity\"]")
    private WebElement saveNewPersonalInformationButton;
    public void setUserFirstnameTextBox(String newUserFirstname)
    {
        userFirstnameTextBox.clear();
        userFirstnameTextBox.sendKeys(newUserFirstname);
    }
    public void setUserLastnameTextBox(String newUserLastname)
    {
        userLastnameTextBox.clear();
        userLastnameTextBox.sendKeys(newUserLastname);
    }
    public void setUserEmailTextBox(String newUserEmail)
    {
        userEmailTextBox.clear();
        userEmailTextBox.sendKeys(newUserEmail);
    }
    public void setUserOldPasswordTextBox(String oldUserPassword)
    {
        userOldPasswordTextBox.sendKeys(oldUserPassword);
    }
    public void setUserNewPasswordTextBox(String newUserPassword)
    {
        userNewPasswordTextBox.sendKeys(newUserPassword);
    }
    public void setUserNewPasswordConfirmationTextBox(String newUserPasswordConfirmation)
    {
        userNewPasswordConfirmationTextBox.sendKeys(newUserPasswordConfirmation);
    }
    public void clickSaveNewInformationButton()
    {
        saveNewPersonalInformationButton.click();
    }
}
