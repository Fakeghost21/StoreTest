package storeTests;

import org.junit.Test;

public class LogInTests extends BaseTests {
    @Test
    public void shouldSuccessfullyLogIn(){

        homePage.clickSignInButton();
        autPage.enterEmailAddress("emailUpdated@tss.uk");
        autPage.enterPassword("new1Passwd@TestUpdated!");
        autPage.clickSignInButton();
        myAccountPage.verifyWelcomeMsg("Welcome to your account. Here you can manage all of your personal information and orders.");
        myAccountPage.loggingOut();

    }
    @Test
    public void shouldSuccessfullyCreateAnAccount()
    {
        homePage.clickSignInButton();
        myAccountPage.typingEmailAddress("testAddress3@test.uk");
        myAccountPage.creatingNewAccount();
        createAccount.completingCustomerName("First Test");
        createAccount.completingCustomerPassword("testPassword1!");
        myAddressesPage.setNewAddress("The test address");
        myAddressesPage.setNewCity("City");
        myAddressesPage.setNewState("Alaska");
        myAddressesPage.setNewPostcode("50000");
        myAddressesPage.setNewMobilePhone("7467844698");
        myAddressesPage.completingTheCustomerCountry("United States");
        myAddressesPage.completingTheAlias("");
        createAccount.registerTheCustomer();

    }
    @Test
    public void shouldSuccessfullyAddToCartAndProceedToCheckout()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("emailUpdated@tss.uk");
        autPage.enterPassword("new1Passwd@TestUpdated!");
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
    public void shouldSuccessfullyAddToAWishlist() throws InterruptedException {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("emailUpdated@tss.uk");
        autPage.enterPassword("new1Passwd@TestUpdated!");
        autPage.clickSignInButton();
        myAccountPage.clickMyWishlistsButton();
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
        myAccountPage.clickMyWishlistsButton();
        wishlistPage.verifyTheFirstWishlistQuantity("0");
        wishlistPage.verifyTheSecondWishlistQuantity("0");
        wishlistPage.clickOnTheFirstWishlistFromTheTable();
        wishlistPage.clickOnTheFirstWishlistFromTheTable();
        //wishlistPage.verifyTheContentOfTheWishlist("Faded Short Sleeve T-shirts");
        wishlistPage.clickOnDeleteWishlistButton(2);

    }
    @Test
    public void shouldAddANewAddress()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("emailUpdated@tss.uk");
        autPage.enterPassword("new1Passwd@TestUpdated!");
        autPage.clickSignInButton();
        myAccountPage.clickMyAddressesButton();
        myAddressesPage.clickAddAnAddressButton();
        myAddressesPage.setNewAddress("New Test address");
        myAddressesPage.setNewCity("Test City");
        myAddressesPage.setNewState("Alaska");
        myAddressesPage.setNewPostcode("50000");
        myAddressesPage.setNewMobilePhone("4846794977");
        myAddressesPage.completingTheAlias("2");
        myAddressesPage.clickSaveTheAddressButton();
        //to delete the second address
        myAddressesPage.clickDeleteTheAddressButton();
    }
    @Test
    public void shouldUpdateUserPersonalInformation()
    {
        homePage.clickSignInButton();
        autPage.enterEmailAddress("emailUpdated@tss.uk");
        autPage.enterPassword("new1Passwd@TestUpdated!");
        autPage.clickSignInButton();
        myAccountPage.clickMyPersonalInformationButton();
        myPersonalInformationPage.setUserFirstnameTextBox("UpdatedFN");
        myPersonalInformationPage.setUserLastnameTextBox("UpdatedLN");
        myPersonalInformationPage.setUserEmailTextBox("emailUpdated@tss.uk");
        myPersonalInformationPage.setUserOldPasswordTextBox("cDu2Z!F@eeyGgXR");
        myPersonalInformationPage.setUserNewPasswordTextBox("new1Passwd@TestUpdated!");
        myPersonalInformationPage.setUserNewPasswordConfirmationTextBox("new1Passwd@TestUpdated!");
        myPersonalInformationPage.clickSaveNewInformationButton();
    }




}
