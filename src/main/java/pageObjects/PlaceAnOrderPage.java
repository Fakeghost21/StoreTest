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
    public void accessTheStoreTShirts(Actions a)
    {
        a.moveToElement(storeWomen);
        storeWomenTops = driver.findElement(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul/li/a"));
        a.moveToElement(storeWomenTops);
        a.click().build().perform();
        //storeWomen.click();
    }

}

