package com.telran.tests.alertsWindows;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.alertsWindows.NestedFramesPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFramesTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectNestedFrames();
    }

    @Test
    public void handleNestedFramesTest() {
      //  new NestedFramesPage(driver).handleNestedFrame();
        Assert.assertTrue(new NestedFramesPage(driver).isChildFrameTextPresent().contains("Child Iframe"));
    }

    @Test
    public void switchToParentFrameTest() {
        new NestedFramesPage(driver).switchToParentFrame();
    }
}
