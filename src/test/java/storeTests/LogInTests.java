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
}
