package com.telran.pages;

import com.telran.pages.alertsWindows.AlertsPage;
import com.telran.pages.alertsWindows.BrowserWindowsPage;
import com.telran.pages.alertsWindows.FramesPage;
import com.telran.pages.bookstore.ProfilePage;
import com.telran.pages.elements.ButtonsPage;
import com.telran.pages.widgets.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends BasePage{

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".show #item-3")
    WebElement profileButton;

    public ProfilePage selectProfile() {
        clickWithJSExecutor(profileButton,0,500);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsButton;

    public AlertsPage selectAlerts() {
        clickWithJSExecutor(alertsButton,0,300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsButton;

    public BrowserWindowsPage selectBrowserWindows() {
        clickWithJSExecutor(browserWindowsButton,0,200);
        return new BrowserWindowsPage(driver);
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public ButtonsPage selectButtons() {
        clickWithJSExecutor(buttons,0,500);
        return new ButtonsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public SelectMenuPage getSelectMenu() {
        clickWithJSExecutor(selectMenu,0,500);
        return new SelectMenuPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;

    public FramesPage selectFrame() {
        clickWithJSExecutor(frames,0,300);
        return new FramesPage(driver);
    }
}
