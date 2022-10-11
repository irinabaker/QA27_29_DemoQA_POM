package com.telran.pages.bookstore;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage login(String name, String pwd) {
        typeWithJSExecutor(userName,name,0,300);
        type(password,pwd);
        click(loginButton);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String name, String pwd) {
        type(userName,name);
        type(password,pwd);
        click(loginButton);
        return this;
    }
}
