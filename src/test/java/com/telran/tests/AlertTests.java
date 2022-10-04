package com.telran.tests;

import com.telran.pages.AlertsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectAlertsFrameWindows();
        new SidePanelPage(driver).selectAlerts();
    }

    @Test
    public void alertWaitTest() {
        new AlertsPage(driver).acceptTimerAlert();
    }

    @Test
    public void alertConfirmTest() {
        new AlertsPage(driver).chooseConfirmButton("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Cancel"));
    }

    @Test
    public void alertSendTextTest() {
        new AlertsPage(driver).sendTextToAlert("Hello World");
       // Assert.assertTrue(new AlertsPage(driver).getConfirmMessageResult().contains("World"));
    }

}
