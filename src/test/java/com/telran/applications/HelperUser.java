package com.telran.applications;

import com.telran.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openBookStore() {
        clickByxPath("//div[@class='category-cards']/div[6]");
    }

    public void clickLoginButton() {
        clickByxPath("//*[@id='login']");
    }

    public void fillLoginForm(User user) {
        type(By.id("userName"),user.getUserName());
        type(By.id("password"), user.getPassword());
    }

    public boolean isUserLogined() {
        return isElementPresent(By.id("submit"));
    }
}
