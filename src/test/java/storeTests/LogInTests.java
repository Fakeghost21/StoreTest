package storeTests;

import org.junit.Test;

public class LogInTests extends BaseTests {
    @Test
    public void shouldSuccessfullyLogIn(){

        homePage.clickSignInButton();
        autPage.enterEmailAddress("ksfvdj@tss.ro");
        autPage.enterPassword("cDu2Z!F@eeyGgXR");
        autPage.clickSignInButton();
        myAccountPage.verifyWelcomeMsg("Welcome to your account. Here you can manage all of your personal information and orders.");
        myAccountPage.loggingOut();

    }
    @Test
    public void shouldSuccessfullyCreateAnAccount()
    {
        homePage.clickSignInButton();
        myAccountPage.typingEmailAddress("testAddress@test.uk");
        myAccountPage.creatingNewAccount();
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
    public void shouldSuccessfullyAddToCartAndProceedToCheckout()
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
        checkOutPage.clickBackToOrdersButton();
        orderHistoryPage.verifyTheOrderDate(java.time.LocalDate.now().toString());
    }
    //Add correctly to the wishlist,but ony in the first wishlist created(no other option)
    @Test
    public void shouldSuccessfullyAddToAWishlist()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("ksfvdj@tss.ro");
        autPage.enterPassword("cDu2Z!F@eeyGgXR");
        autPage.clickSignInButton();
        autPage.clickMyWishlistsButton();
        wishlistPage.giveANameToTheWishlist("Wishlist 1");
        wishlistPage.clickTheSaveButtonForWishlist();
        wishlistPage.verifyTheNameOfTheNewWishlist("Wishlist 1");
        wishlistPage.verifyTheCreationDateOfTheWishlist(java.time.LocalDate.now().toString());
        //create another wishlist
        wishlistPage.giveANameToTheWishlist("Wishlist 2");
        wishlistPage.clickTheSaveButtonForWishlist();
        wishlistPage.clickOnBackToYourAccountButton();
        orderPage.accessTheStoreTShirts(a);
        orderPage.addTShirtToTheWishlist(a);
        orderPage.clickOnViewMyAccountButton();
        autPage.clickMyWishlistsButton();
        wishlistPage.verifyTheFirstWishlistQuantity("0");
        wishlistPage.verifyTheSecondWishlistQuantity("0");
        wishlistPage.clickOnTheFirstWishlistFromTheTable();
        wishlistPage.clickOnTheFirstWishlistFromTheTable();
        wishlistPage.verifyTheContentOfTheWishlist("Faded Short Sleeve T-shirts");
        wishlistPage.clickOnDeleteWishlistButton(2);

    }
    @Test
    public void shouldAddANewAddress()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("ksfvdj@tss.ro");
        autPage.enterPassword("cDu2Z!F@eeyGgXR");
        autPage.clickSignInButton();

    }




}
