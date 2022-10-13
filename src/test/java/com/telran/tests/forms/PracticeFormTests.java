package com.telran.tests.forms;

import com.telran.data.StudentData;
import com.telran.pages.HomePage;
import com.telran.pages.SidePanelPage;
import com.telran.pages.forms.PracticeFormPage;
import com.telran.tests.TestBase;
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
//        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME,StudentData.LAST_NAME,StudentData.EMAIL,
//                StudentData.TEL_NUM,StudentData.ADDRESS);
        new PracticeFormPage(driver).selectGender(StudentData.GENDER)
                .typeOfDate(StudentData.DATE)
                .addSubject(StudentData.SUBJECTS)
                .chooseHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH);
//                .enterState(StudentData.STATE)
//                .enterCity(StudentData.CITY);
    }
}
