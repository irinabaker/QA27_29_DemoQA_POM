package com.telran.pages.alertsWindows;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> frames;

    @FindBy(id = "frame1")
    WebElement frame1;

    public FramesPage returnListOfFrames() {
        //by executing JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(js.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
        //by findoing all the web elements using iframe tag
        System.out.println("The total number of iframes are " + frames.size());
        return this;
    }

    public FramesPage switchToFrameByIndex(int index) {
        //switch to index
        driver.switchTo().frame(index);
        body.getText();
        System.out.println(body.getText());
        return this;
    }

    @FindBy (tagName = "body")
    WebElement body;

    public FramesPage switchToFrameById() {
        //swicth to frame by ID
        driver.switchTo().frame(frame1);
        body.getText();
        System.out.println(body.getText());
   //     driver.switchTo().defaultContent();
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement text;

    public FramesPage getTextFromFrame() {
        //finding the text of the frame1 heading
        driver.switchTo().frame(frame1);
        String frameText = this.text.getText();
        System.out.println("Text of the frame1 heading is " + frameText);
        return this;
    }

    @FindBy(tagName = "h1")
    WebElement textOfFrame;

    public String isFrameTextPresent() {
        return textOfFrame.getText();
    }
}
