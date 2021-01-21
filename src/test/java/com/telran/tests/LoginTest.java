package com.telran.tests;

import com.telran.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

@Test
    public void logintest() throws InterruptedException {
    app.user().openBookStore();
    app.user().pause(500);
    app.user().clickLoginButton();
    app.user().fillLoginForm(new User().withUserName("hatum").withPassword("21$Hatum21$"));
    app.user().clickLoginButton();
    app.user().pause(2000);

    Assert.assertTrue(app.user().isUserLogined());

}

}
