package storeTests;

import org.junit.Test;

public class LogInTests extends BaseTests {
    @Test
    public void shouldSuccessfullyLogIn(){

        homePage.clickSignInButton();
        autPage.enterEmailAddress("ksfvdj@tss.ro");
        autPage.enterPassword("cDu2Z!F@eeyGgXR");
        autPage.clickSignInButton();
        myPg.verifyWelcomeMsg("Welcome to your account. Here you can manage all of your personal information and orders.");
        myPg.loggingOut();

    }
    @Test
    public void shouldSuccessfullyCreateAnAccount()
    {
        homePage.clickSignInButton();
        myPg.typingEmailAddress("testAddress@test.uk");
        myPg.creatingNewAccount();
        createAccount.completingCustomerName("First Test");
        createAccount.completingCustomerPassword("testPassword1!");
        createAccount.completingTheAddress("The test's address");
        createAccount.completingTheCustomerCity("Oklahoma");
        createAccount.completingTheState("Arkansas");
        createAccount.completingThePostcode("40000");
        createAccount.completingTheCustomerCountry("United States");
        createAccount.completingTheCustomerMobilePhone("9999999999");
        createAccount.completingTheAlias("");
        createAccount.registerTheCustomer();

    }
    @Test
    public void shouldSuccessfullyAddToCart()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("ksfvdj@tss.ro");
        autPage.enterPassword("cDu2Z!F@eeyGgXR");
        autPage.clickSignInButton();
        orderPage.accessTheStoreTops(a);
        orderPage.accessTheStoreTopsBlouses();
        orderPage.changeTheColourOfTheBlouse(a);
        orderPage.addToCart();
        orderPage.continueShopping();
        orderPage.verifyQuantity("1");
        checkOutPage.proceedToCheckout(a);
        checkOutPage.verifyProductName("Blouse");
        checkOutPage.verifyProductDescription("Color : White, Size : S");
        checkOutPage.verifyProductUnitPrice("$27.00");
    }

}
