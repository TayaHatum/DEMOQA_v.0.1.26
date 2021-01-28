package com.telran.tests;

import com.telran.models.StudentRegForm;
import org.testng.annotations.Test;

public class StudentRegFormTest extends TestBase {

    @Test
    public void studentRegFormTest() throws InterruptedException {
        app.student().selectItemForms();
        app.student().selectPracticeForm();
        app.student().fillRegStudetForm(new StudentRegForm()
                .withfName("John")
                .withlName("Doe")
                .withEmail("jhon@mail.com")
                .withGender("Male")
                .withPhone("1234567891")
                .withbDay("25 May 1999")
                .withSubject("Maths")
                .withHobbies("Sport")
                .withAddress("Haifa")
                .withState("NCR")
                .withCity("Gurgaon"));

        app.student().submit();

    }


}
