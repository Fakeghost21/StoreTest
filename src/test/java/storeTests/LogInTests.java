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
        checkOutPage.verifyCartProductQuantity();
        checkOutPage.verifyCartTotalDelivery();
        checkOutPage.proceedToCheckoutToTheAddress();
        checkOutPage.proceedToCheckoutButtonToTheShipping();
        checkOutPage.verifyTheShippingOptionBox();
        checkOutPage.checkTheTermsOfServiceBox();
        checkOutPage.proceedToCheckoutButtonToThePayment();
        checkOutPage.payByBankWire();
        checkOutPage.verifyConfirmationOfPaymentByBankWire();
        checkOutPage.confirmTheOrder();
    }
    //Add correctly to the wishlist,but ony in the first wishlist created(no other option)
    @Test
    public void shouldSuccessfullyAddToAWishlist()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("ksfvdj@tss.ro");
        autPage.enterPassword("cDu2Z!F@eeyGgXR");
        autPage.clickSignInButton();
        wishlistPage.clickMyWishlistsButton();
        wishlistPage.giveANameToTheWishlist("Wishlist 1");
        wishlistPage.clickTheSaveButtonForWishlist();
        wishlistPage.verifyTheNameOfTheNewWishlist("Wishlist 1");
        wishlistPage.verifyTheCreationDateOfTheWishlist(java.time.LocalDate.now().toString());
        //create another wishlist
        wishlistPage.giveANameToTheWishlist("Wishlist 2");
        wishlistPage.clickTheSaveButtonForWishlist();
        //wishlistPage.clickOnTheSecondWishlistFromTheTable();
        wishlistPage.clickOnBackToYourAccountButton();
        orderPage.accessTheStoreTShirts(a);
        orderPage.addTShirtToTheWishlist(a);
        orderPage.clickOnViewMyAccountButton();
        wishlistPage.clickMyWishlistsButton();
        wishlistPage.verifyTheFirstWishlistQuantity("0");
        wishlistPage.verifyTheSecondWishlistQuantity("0");
        wishlistPage.clickOnTheFirstWishlistFromTheTable();
        wishlistPage.verifyTheContentOfTheWishlist("Faded Short Sleeve T-shirts");

    }



}
