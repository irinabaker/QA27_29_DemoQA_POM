package com.telran.tests.bookstore;

import com.telran.data.BookData;
import com.telran.pages.bookstore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectBookStoreApp();
    }

    @Test
    public void searchBookPositiveTestForGuest() {
        new BookStorePage(driver).typeInSearchBookInput(BookData.BOOK_NAME);
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(BookData.BOOK_NAME));
    }


}
