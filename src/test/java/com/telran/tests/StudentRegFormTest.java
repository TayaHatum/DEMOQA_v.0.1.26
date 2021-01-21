package com.telran.tests;

import com.telran.models.StudentRegForm;
import org.testng.annotations.Test;

public class StudentRegFormTest extends TestBase{

    @Test
    public void studentRegFormTest() throws InterruptedException {
        app.student().selectItemForms();
        app.student().selectPracticeForm();
        app.student().fillRegStudetForm(new StudentRegForm().withfName("John").withlName("Doe")
        .withEmail("jhon@mail.com").withGender("Male").withPhone("1234567891"));

        app.student().submit();

    }

}
