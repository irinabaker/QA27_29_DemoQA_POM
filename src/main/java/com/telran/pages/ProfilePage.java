package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    // userName-value
    // submit

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    @FindBy(id = "submit")
    WebElement logOutButton;

    public ProfilePage verifyUserName(String userName) {
        if (userNameValue.getText().equalsIgnoreCase(userName)) {
            System.out.println("Correct user name: " + userNameValue.getText());
        } else {
            System.out.println("Incorrect user name: " + userNameValue.getText());
        }
        return this;
    }

    public LoginPage logOut() {
        click(logOutButton);
        return new LoginPage(driver);
    }
}
