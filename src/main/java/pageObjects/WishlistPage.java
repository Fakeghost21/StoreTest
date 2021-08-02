package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage {
    WebDriver driver;
    String half1OfDeleteWishlistButtonAddress ="//*[@class=\"table table-bordered\"]/tbody/tr[";
    String half2OfDeleteWishlistButtonAddress ="]/td[6]/a";

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
    //@FindBy(xpath = "//*[@class=\"wishlist_delete\"]/a")
    private WebElement deleteTheWishlistButton;
    @FindBy(xpath = "//*[@id=\"block-history\"]")
    private WebElement table;
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
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(productNameFromTheWishlist));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productNameFromTheWishlist);
        Assert.assertEquals(actualContentOfTheWishlist,productNameFromTheWishlist.getText());
    }
    public void clickOnDeleteWishlistButton(Integer numberOfWishlists) throws InterruptedException {
        //while(!driver.findElements(By.xpath("//*[@class=\"wishlist_delete\"]")).isEmpty())

//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
//        for(int i = 0;i<numberOfWishlists;i++){
//            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
//            deleteTheWishlistButton.click();
//            //handling the popup
//            Thread.sleep(1000);
//            driver.switchTo().alert().accept();
//            driver.navigate().refresh();
//            WebDriverWait wait = new WebDriverWait(driver,5);
//            wait.until(ExpectedConditions.visibilityOf(deleteTheWishlistButton));
//            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", table);
//            deleteTheWishlistButton.click();

        //deletes the wishlists from the wishlist table starting up from bottom to top
        for(Integer i=numberOfWishlists;i>0;i--)
        {
            deleteTheWishlistButton=driver.findElement(By.xpath(half1OfDeleteWishlistButtonAddress +i.toString()+ half2OfDeleteWishlistButtonAddress));//I split the address in two
            deleteTheWishlistButton.click();                                    //so it can work with in index
            driver.switchTo().alert().accept();
            WebDriverWait wait = new WebDriverWait(driver,5);
            wait.until(ExpectedConditions.visibilityOf(deleteTheWishlistButton));
        }
    }
}
