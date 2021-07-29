package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage {
    WebDriver driver;

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id=\"order-list\"]/tbody/tr[1]/td[2]")
    private WebElement expectedOrderDate;
    public void verifyTheOrderDate(String actualOrderDate)
    {
        //Assert.assertEquals(actualOrderDate,expectedOrderDate.getText());
        String[] dates = expectedOrderDate.getText().split("/");
        Assert.assertEquals(java.time.LocalDate.now().getMonthValue(),Integer.parseInt(dates[0]));
        Assert.assertEquals(java.time.LocalDate.now().getDayOfMonth(),Integer.parseInt(dates[1]));
        Assert.assertEquals(java.time.LocalDate.now().getYear(),Integer.parseInt(dates[2]));
    }
}
