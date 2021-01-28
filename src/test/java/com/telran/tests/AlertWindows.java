package com.telran.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertWindows extends TestBase{

    @Test
    public void testWindows(){
        app.alertWindows().selectItemAlert();
        app.alertWindows().selectBrowserWindows();
        app.alertWindows().clickOnTabButton();
        Assert.assertTrue(app.alertWindows().takeText().contains("page"));
    }

    @Test
    public void alertTest(){
        app.alertWindows().testAlert();
    }
}
