package com.telran.applications;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class HelperSelect extends HelperBase{
    public HelperSelect(WebDriver wd) {
        super(wd);
    }

    public void selectItemWidgets() {
        click(By.xpath("//div//h5[text()='Widgets']"));
    }

    public void clickSelectMenu() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('footer').style.display='none';");
        click(By.xpath("//span[.='Select Menu']"));
    }

    public void clickMultiSelect() {
        Select cars = new Select(wd.findElement(By.id("cars")));
        if (cars.isMultiple()) {
            cars.selectByIndex(1);
            cars.selectByIndex(2);
            cars.selectByIndex(3);
        }
    }
public void selectMr(String text){
        WebElement el = wd.findElement(By.id("selectOne"));
        el.click();
        //*[text()='Mr.']
        WebElement op= wd.findElement(By.xpath(String.format("//*[text()='%s']",text)));
        op.click();




    }
}
