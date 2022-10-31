package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;

    public TextBoxPage keyBoardEvent() {
        //enter username
        type(userName,"Till Lindemann");
        //enter email
        type(userEmail,"till@gmail.com");
        //enter current address
        typeWithJSExecutor(currentAddress,"Friedrichstrasse 176-179, 10117 Berlin",0,200);
        //create object of the Action class
        Actions actions = new Actions(driver);
        pause(500);
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press the tab Key to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past the current address in the permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

//        System.out.println(currentAddress.getAttribute("value"));
//        System.out.println(permanentAddress.getAttribute("value"));
        return this;
    }

    public String getAttribute() {
        return permanentAddress.getAttribute("value");
    }
}
