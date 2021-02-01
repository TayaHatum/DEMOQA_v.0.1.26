package com.telran.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HelperAlertWindows extends HelperBase{
    public HelperAlertWindows(WebDriver wd) {
        super(wd);
    }

    public void selectItemAlert() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.xpath("//div//h5[.='Alerts, Frame & Windows']"))).click().perform();
        //clickByxPath("//div//h5[.='Alerts, Frame & Windows']");
    }

    public void selectBrowserWindows() {
        clickByxPath("//span[.='Browser Windows']");
    }

    public void clickOnTabButton() {
        System.out.println(wd.getWindowHandle());
        click(By.id("tabButton"));

        List<String> tabs =new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));
    }

    public String takeText() {
        return wd.findElement(By.id("sampleHeading")).getText();
    }

    public void testAlert() {
        //Ok
        //wd.switchTo().alert().accept();
        //Cancel
       // wd.switchTo().alert().dismiss();
        //send mess
        //wd.switchTo().alert().sendKeys("text");
    }
}
