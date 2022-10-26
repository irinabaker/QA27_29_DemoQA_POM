package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.BrokenLinksImages;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectBrokenLinksImages();
    }

    @Test
    public void checkBrokenLinksTest() {
        new BrokenLinksImages(driver).checkAllLinks().checkBrokenLinks();
    }

    @Test
    public void checkBrokenImagesTest() {
        new BrokenLinksImages(driver).checkBrokenImages();
    }
}
