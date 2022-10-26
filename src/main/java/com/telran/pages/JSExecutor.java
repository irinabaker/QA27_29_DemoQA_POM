package com.telran.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JSExecutor extends BasePage{

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public JSExecutor enterDataWithJS(String userName, String userEmail) {

        if (userName != null && userEmail != null) {
            js.executeScript("document.getElementById('userName').value='" + userName + "';");
            js.executeScript("document.getElementById('userName').style.border='3px solid red';");
            js.executeScript("document.getElementById('userEmail').value='" + userEmail + "';");
        }
        return this;
    }

    public JSExecutor clickOnSubmitWithJS() {
        //to click element and make red background
        js.executeScript("document.querySelector('#submit').style.backgroundColor='red';");
        js.executeScript("document.getElementById('submit').click();");
        return this;
    }

    public JSExecutor checkBoxWithJS() {
        //to handle checkbox
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=false;");
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
        return this;
    }

    public JSExecutor getTitlePageAndURLWithJS() {
        String text = js.executeScript("return document.title;").toString();
        System.out.println(text);
        String url = js.executeScript("return document.URL;").toString();
        System.out.println(url);
        return this;
    }
}
