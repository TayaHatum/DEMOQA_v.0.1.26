package com.telran.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.brokenLinks().selectItemElements();
        app.brokenLinks().selectLinks();

    }

    @Test
    public void brokenLinksTest(){
        app.brokenLinks().checkAllUrl();
        app.brokenLinks().checkBrokenLinks();

    }

    @Test
    public void brokenImagesTest(){
        app.brokenLinks().selectBrokenLinksImages();
        app.brokenLinks().checkBrokenImages();
    }
}
