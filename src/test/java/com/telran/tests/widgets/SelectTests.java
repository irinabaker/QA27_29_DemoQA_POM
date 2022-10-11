package com.telran.tests.widgets;

import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.widgets.SelectMenuPage;
import com.telran.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectWidgets();
        new SidePanelPage(driver).getSelectMenu();
    }

    @Test
    public void oldStyleSelectTest() {
        new SelectMenuPage(driver).selectOldStyle("Blue");
    }

    @Test
    public void clickOnMultiSelectDropDownTest() {
        new SelectMenuPage(driver).clickOnMultiSelectDropDown("Green").deselect()
                .clickOnMultiSelectDropDown1("Red","Blue","Green");
    }

    @Test
    public void standardMultiSelectTest() {
        new SelectMenuPage(driver).clickStandardMultiSelect();
        }
    }

