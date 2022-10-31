package com.telran.tests.elements;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.elements.UploadAndDownloadPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class UploadAndDownLoadTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectElements();
        new SidePanelPage(driver).selectUploadAndDownload();
    }

    @Test
    public void robotKeyEventTest() throws AWTException {
        new UploadAndDownloadPage(driver).performEventKeyUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains("D1.txt"));
    }

    @Test
    public void robotMouseEventTest() {
        new UploadAndDownloadPage(driver).performMouseEventUsingRobot();
        Assert.assertTrue(new UploadAndDownloadPage(driver).getPath().contains("D1.txt"));
    }
}
