package com.telran.pages.elements;

import com.telran.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class BrokenLinksImages extends BasePage {

    public BrokenLinksImages(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public BrokenLinksImages checkAllLinks() {
        System.out.println("Total links on the Webpage: " + links.size());
        String url = "";
        Iterator<WebElement> iterator = links.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public BrokenLinksImages checkBrokenLinks() {
        for (int i = 0; i < links.size(); i++) {
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }

    private void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //create url connection and get status code
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.connect();
            if(httpURLConnection.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(linkUrl + " - " + httpURLConnection.getResponseMessage());
            }
        } catch (Exception e) {
            System.out.println(linkUrl + " - " + e.getMessage() + " is a broken link");
        }
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenLinksImages checkBrokenImages() {
        System.out.println("We have " + images.size() + " images");
        //check links
        for (int index = 0; index < images.size(); index++) {
            WebElement element = images.get(index);
            String imageUrl = element.getAttribute("src");
            System.out.println("URL of Images " + (index + 1) + " is: " + imageUrl);
            verifyLinks(imageUrl);

            //check to display image with JS executor
            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth > 0);", element);
           if(imageDisplayed) {
               System.out.println("DISPLAY - OK");
               System.out.println("*******************************************");
           } else {
               System.out.println("DISPLAY - BROKEN");
           }
            }catch (Exception e) {
                System.out.println("Error occurred");
            }
        }
        return this;
    }
}
