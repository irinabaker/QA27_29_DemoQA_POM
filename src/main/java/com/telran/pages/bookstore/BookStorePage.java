package com.telran.pages.bookstore;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    @FindBy(id = "searchBox")
    WebElement searchInput;

    public BookStorePage typeInSearchBookInput(String bookName) {
        type(searchInput, bookName);
        return this;
    }

    @FindBy(css = ".mr-2")
    WebElement nameOfBook;

    public String takeNameOfBook() {
        return nameOfBook.getText();
    }

    public BookStorePage clickOnBookTitleLink() {
        click(nameOfBook);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionButton;

    public BookStorePage clickOnAddBookButton() {
        clickWithJSExecutor(addToCollectionButton, 0, 500);
        pause(500);
        return this;
    }

}
