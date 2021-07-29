package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {
    WebDriver driver;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(id="name")
    private WebElement wishlistsNameInput;
    @FindBy(id="submitWishlist")
    private WebElement saveTheWishlistButton;
    @FindBy(xpath="//*[@class=\"table table-bordered\"]/tbody/tr/td/a")
    private WebElement actualNameOfTheWishlistBox;
    @FindBy(xpath = "//*[@class=\"table table-bordered\"]/tbody/tr/td[4]")
    private WebElement actualCreationDateOfTheWishlist;
    @FindBy(xpath="//*[@class=\"table table-bordered\"]/tbody/tr/td/a")
    private WebElement firstWishlistInTheWishlistTable;
    @FindBy(xpath = "//*[@class=\"footer_links clearfix\"]/li/a")
    private WebElement backToYourAccountButton;
    @FindBy(xpath = "//*[@class=\"table table-bordered\"]/tbody/tr/td[2]")
    private WebElement firstWishlistQuantity;
    @FindBy(xpath = "//*[@class=\"table table-bordered\"]/tbody/tr[2]/td[2]")
    private WebElement secondWishlistQuantity;
    @FindBy(xpath = "//*[@class=\"product_infos\"]/p")
    private WebElement productNameFromTheWishlist;
    @FindBy(xpath = "//*[@class=\"wishlist_delete\"]/a")
    private WebElement deleteTheWishlistButton;
    public void giveANameToTheWishlist(String wishlistsName)
    {
        wishlistsNameInput.sendKeys(wishlistsName);
    }
    public void clickTheSaveButtonForWishlist()
    {
        saveTheWishlistButton.click();
    }
    public void verifyTheNameOfTheNewWishlist(String expectedNameOfTheWishlist)
    {
        Assert.assertEquals(expectedNameOfTheWishlist,actualNameOfTheWishlistBox.getText());
    }
    public void verifyTheCreationDateOfTheWishlist(String expectedCreationDateOfTheWishlist)
    {
        Assert.assertEquals(expectedCreationDateOfTheWishlist,actualCreationDateOfTheWishlist.getText());
    }
    public void clickOnTheFirstWishlistFromTheTable()
    {
        firstWishlistInTheWishlistTable.click();
    }
    public void clickOnBackToYourAccountButton()
    {
        backToYourAccountButton.click();
    }
    public void verifyTheFirstWishlistQuantity(String notActualFirstWishlistQuantity)
    {
        Assert.assertNotEquals(firstWishlistQuantity.getText(),notActualFirstWishlistQuantity);
    }
    public void verifyTheSecondWishlistQuantity(String actualSecondWishlistQuantity)
    {
        Assert.assertEquals(actualSecondWishlistQuantity,secondWishlistQuantity.getText());
    }
    public void verifyTheContentOfTheWishlist(String actualContentOfTheWishlist)
    {
        Assert.assertEquals(actualContentOfTheWishlist,productNameFromTheWishlist.getText());
    }
    public void clickOnDeleteWishlistButton(int numberOfWishlists)
    {
        //while(!driver.findElements(By.xpath("//*[@class=\"wishlist_delete\"]")).isEmpty())
        for(int i = 0;i<numberOfWishlists;i++){
            deleteTheWishlistButton.click();
            //handling the popup
            driver.switchTo().alert().accept();
            WebDriverWait wait = new WebDriverWait(driver,10);
        }
    }
}
