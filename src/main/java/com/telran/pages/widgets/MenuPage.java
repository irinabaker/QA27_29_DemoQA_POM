package com.telran.pages.widgets;

import com.telran.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement suSubList;

    @FindBy(xpath = "//a[.='Sub Sub Item 2']")
    WebElement subSubItem2;

    public MenuPage selectSubMenu() {
        hideAd();
        hideFooter();
        Actions actions = new Actions(driver);
        //mouse hover menu options 'Main Item 2'
        actions.moveToElement(mainItem2).perform();
    //    System.out.println(mainItem2.getText());
        //mouse hover menu options 'SUB SUB LIST'
        actions.moveToElement(suSubList).perform();
        suSubList.sendKeys(Keys.SHIFT);
     //   System.out.println(suSubList.getText());
        //mouse hover menu options 'Sub Sub Item 2'
        actions.moveToElement(subSubItem2).perform();
        subSubItem2.sendKeys(Keys.SHIFT);
     //   System.out.println(subSubItem2.getText());
        return this;
    }
}
