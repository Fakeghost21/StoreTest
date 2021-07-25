package storeTests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    public WebDriver driver;
    public HomePage homePage;
    public AuthenticationPage autPage;
    public MyAccountPage myPg;
    public CreatingAccountPage createAccount;
    public PlaceAnOrderPage orderPage;
    public ProceedToCheckOutPage checkOutPage;
    public Actions a;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        a = new Actions(driver);
        homePage = PageFactory.initElements(driver,HomePage.class);
        autPage = PageFactory.initElements(driver,AuthenticationPage.class);
        myPg = PageFactory.initElements(driver,MyAccountPage.class);
        createAccount = PageFactory.initElements(driver,CreatingAccountPage.class);
        orderPage = PageFactory.initElements(driver,PlaceAnOrderPage.class);
        checkOutPage = PageFactory.initElements(driver,ProceedToCheckOutPage.class);

    }
//   @After
//   public void after(){
//        driver.quit();
//   }

}
