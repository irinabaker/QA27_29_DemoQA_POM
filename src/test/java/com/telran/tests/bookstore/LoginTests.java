package com.telran.tests.bookstore;

import com.telran.data.UserData;
import com.telran.pages.bookstore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.pages.bookstore.LoginPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
        new BookStorePage(driver).clickOnLoginButton();
    }

    @Test
    public void LoginPositiveTest() {
        new LoginPage(driver).login(UserData.USER_NAME,UserData.USER_PASSWORD);
        new ProfilePage(driver).verifyUserName(UserData.USER_NAME);
    }

    @AfterMethod
    public void logOut() {
        new ProfilePage(driver).logOut();
    }
}
