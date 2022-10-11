package com.telran.tests.alertsWindows;

import com.telran.pages.alertsWindows.BrowserWindowsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectBrowserWindows();
    }

    @Test
    public void newTabTest() {
        new BrowserWindowsPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowsPage(driver).getTextFromNewTab().contains("sample"));
    }
}
