package com.telran.tests;

import com.telran.pages.LoginPage;
import com.telran.pages.ProfilePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void LoginPositiveTest() {
        new LoginPage(driver).login("neuer","Neuer1234!");
        new ProfilePage(driver).verifyUserName("neuer");
    }

    @AfterMethod
    public void logOut() {
        new ProfilePage(driver).logOut();
    }
}
