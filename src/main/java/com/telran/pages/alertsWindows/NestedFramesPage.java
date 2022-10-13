package com.telran.pages.alertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    @FindBy(id = "frame1")
    WebElement frame1;

    @FindBy(tagName = "body")
    WebElement body;

    public NestedFramesPage handleNestedFrame() {
        int countIframes = iframe.size();
        System.out.println("Number of Iframes on a page: " + countIframes);
        //switch to frame1
        driver.switchTo().frame(frame1);
        //number of frames on a frame1
       int countIframesInFrame1 = iframe.size();
        System.out.println("Number of iFrames inside the Frame1: " + countIframesInFrame1);
        //switch to child iframe
        driver.switchTo().frame(0);
        String frame2Text = body.getText();
        System.out.println("Frame2 is " + frame2Text);
        return this;
    }

    public String isChildFrameTextPresent() {
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(0);
        return body.getText();
    }

    public NestedFramesPage switchToParentFrame() {
        driver.switchTo().frame(frame1);
        driver.switchTo().frame(0);
        //switch to parent Iframe
        driver.switchTo().parentFrame();
       // driver.switchTo().defaultContent();
        //get the text for frame1
        String frame1Text = body.getText();
        System.out.println("Frame1 is " + frame1Text);
        return this;
    }
}
