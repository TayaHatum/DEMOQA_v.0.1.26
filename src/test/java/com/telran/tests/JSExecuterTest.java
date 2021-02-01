package com.telran.tests;

import org.testng.annotations.Test;

public class JSExecuterTest extends TestBase{
    @Test
    public void jsexcuterTest() throws InterruptedException {
        app.js().selectItemElements();
        app.js().selectTextBox();
        app.js().typeJS("Lola","lola@mail.com");
        app.js().clickSubmitButton();

    }
}
