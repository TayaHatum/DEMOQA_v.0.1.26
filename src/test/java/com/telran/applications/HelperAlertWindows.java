package com.telran.applications;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void clickAlertButton2() {
        click(By.id("timerAlertButton"));
        WebDriverWait wait = new WebDriverWait(wd,10);
        Alert myAlert= wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
    }

    public void selectAlert() {
        click(By.xpath("//span[.='Alerts']"));
        //span[.='Alerts']
    }

    public void clickWithWait() {
        click(By.id("timerAlertButton"));
        WebDriverWait wait =new WebDriverWait(wd,10);
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
