package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collection;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage acceptTimerAlert() {
        click(timerAlertButton);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage chooseConfirmButton(String text) {
        click(confirmButton);
        if (text != null && text.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (text != null && text.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public String getConfirmResult() {
        return confirmResult.getText();
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage sendTextToAlert(String message) {
        clickWithJSExecutor(promtButton,0,200);
        if(message != null) {
            driver.switchTo().alert().sendKeys(message);
        }
        driver.switchTo().alert().accept();
        return this;
    }
}
