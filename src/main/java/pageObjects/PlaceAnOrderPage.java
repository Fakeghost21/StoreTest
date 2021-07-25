package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class PlaceAnOrderPage {
    WebDriver driver;

    public PlaceAnOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath= "//*[@class='sf-with-ul']")
    private WebElement storeWomen;
    private WebElement storeWomenTops;
    @FindBy(xpath="//*[@id=\"subcategories\"]/ul/li[2]/div/a")
    private WebElement storeWomenTopsBlouses;
    @FindBy(xpath="//*[@class='product_list grid row']/li")
    private WebElement storeWomenTopsBlousesHover;
    @FindBy(id="color_8")
    private WebElement storeWomenTopsBlousesWhite;
    @FindBy(xpath="//*[@class='exclusive']")
    private WebElement addToCartButton;
    public void accessTheStoreTops(Actions a)
    {
        a.moveToElement(storeWomen);
        storeWomenTops = driver.findElement(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul/li/a"));
        a.moveToElement(storeWomenTops);
        a.click().build().perform();
        //storeWomen.click();
    }
    public void accessTheStoreTopsBlouses()
    {
        storeWomenTopsBlouses.click();
    }
    public void changeTheColourOfTheBlouse(Actions a)
    {
        a.moveToElement(storeWomenTopsBlousesHover);
        a.moveToElement(storeWomenTopsBlousesWhite);
        a.click().build().perform();
    }
    public void addToCart()
    {
        addToCartButton.click();
    }

}

