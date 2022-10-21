package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
import com.telran.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).selectForms();
        new SidePanelPage(driver).selectPracticeForm();
    }

    @Test
    public void createNewStudentTest() {
        new PracticeFormPage(driver)
                .hideIframes()
                .enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME, StudentData.EMAIL,
                        StudentData.TEL_NUM);
        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
                .chooseDate("May", "2000", "13")
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .addAddress(StudentData.ADDRESS)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY).submit();
        Assert.assertTrue(new PracticeFormPage(driver).getModalTitle().contains("Thanks for submitting the form"));
        new PracticeFormPage(driver).closeModalDialog();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "usingFile")
    public void createNewStudentWithDataProviderTest(String firstName, String lastName, String email, String phone,
                                                     String birthDate, String file, String address) {
        new PracticeFormPage(driver)
                .hideIframes()
                .enterPersonalData(firstName, lastName, email, phone);
        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
                .typeOfDate(birthDate)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(file)
                .addAddress(address)
                .enterState(StudentData.STATE)
                .enterCity(StudentData.CITY).submit();
        Assert.assertTrue(new PracticeFormPage(driver).getModalTitle().contains("Thanks for submitting the form"));
        new PracticeFormPage(driver).closeModalDialog();
    }
}
