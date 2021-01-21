package com.telran.applications;

import com.telran.models.StudentRegForm;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HelperStudentForm extends HelperBase{
    public HelperStudentForm(WebDriver wd) {
        super(wd);
    }

    public void selectItemForms() {
        clickByxPath("//div[@class='category-cards']/div[2]");
    }

    public void selectPracticeForm() {
        clickByxPath("//span[.='Practice Form']");
    }

    public void submit() {
        click(By.id("submit"));
    }

    public void fillRegStudetForm(StudentRegForm model) throws InterruptedException {
        type(By.id("firstName"), model.getfName());
        type(By.id("lastName"),model.getlName());
        type(By.id("userEmail"), model.getEmail());
        selectGender(model.getGender());
        pause(500);
        type(By.id("userNumber"), model.getPhone());
        typeBDay(model.getbDay());
    }

    private  void typeBDay(String bday){
        type(By.id("dateOfBirthInput"),bday);
        wd.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.ENTER);

    }
    private  void selectGender(String gender){
        if(gender.equals("Male")){
            clickByxPath("//label[@for='gender-radio-1']");
        }else if(gender.equals("Female")){
            clickByxPath("//label[@for='gender-radio-2']");
        }else{
            clickByxPath("//label[@for='gender-radio-3']");
        }

    }
}
