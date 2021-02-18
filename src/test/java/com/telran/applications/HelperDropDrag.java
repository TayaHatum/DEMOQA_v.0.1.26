package com.telran.applications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperDropDrag extends HelperBase{
    public HelperDropDrag(WebDriver wd) {
        super(wd);
    }

    public void selectItemInteractions() {
        hideFooter();
        click(By.xpath("//h5[.='Interactions']"));
    }

    public void selectDroppable() {
        hideFooter();
        click(By.xpath("//span[.='Droppable']"));
    }
    public void selectDragabble(){
        hideFooter();
        clickByxPath("//span[.='Dragabble']");
    }

    public void actionDragMe() {
        WebElement dragMe= wd.findElement(By.id("draggable"));
        WebElement dropHere=wd.findElement(By.id("droppable"));

        Actions actions = new Actions(wd);
        pause(2000);
        actions.dragAndDrop(dragMe,dropHere).build().perform();

        String textTo = dropHere.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped to target as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped to target as expected");
        }
    }

    public void dragAndDropBy(){
        WebElement from= wd.findElement(By.id("draggable"));
        WebElement to=wd.findElement(By.id("droppable"));

        Actions actions = new Actions(wd);
        //Here, getting x and y offset to drop source object on target object location
        //First, get x and y offset for from object
        int xOffset1 = from.getLocation().getX();

        int yOffset1 =  from.getLocation().getY();

        System.out.println("xOffset1--->"+xOffset1+" yOffset1--->"+yOffset1);

        //Secondly, get x and y offset for to object
        int xOffset = to.getLocation().getX();

        int yOffset =  to.getLocation().getY();

        System.out.println("xOffset--->"+xOffset+" yOffset--->"+yOffset);

        //Find the xOffset and yOffset difference to find x and y offset
        // needed in which from object required to dragged and dropped
        xOffset =(xOffset-xOffset1)+10;
        yOffset=(yOffset-yOffset1)+20;

        pause(1000);
        //Perform dragAndDropBy
        actions.dragAndDropBy(from, xOffset,yOffset).build().perform();

        //verify text changed in to 'Drop here' box
        //Get text value of 'to' element
        String textTo = to.getText();

        if(textTo.equals("Dropped!")) {
            System.out.println("PASS: Source is dropped at location as expected");
        }else {
            System.out.println("FAIL: Source couldn't be dropped at location as expected");
        }

    }

    public void dragAndDropBy100(){
        WebElement from = wd.findElement(By.id("draggable"));
        Actions actions = new Actions(wd);
        pause(3000);
        actions.dragAndDropBy(from,100,100).perform();


       // actions.dragAndDropBy(from, 100,100).perform();

        System.out.println("Dropped");
    }
}



//dragAndDrop(WebElementsource, WebElement target)
//Click And Hold Action   -->  сначала выполняет щелчок и удерживание в месте расположения исходного элемента
//Move Mouse Action       -->  затем исходный элемент перемещается в местоположение целевого элемента
//Button Release Action   -->  отпускается мышь
//Build     -->build () метод используется для создания составного действия, содержащего все действия.
// Но если вы заметили, мы не вызывали его в нашей вышеупомянутой команде.
// Сборка выполняется в методе выполнения внутри
//Perform    -->  метод perform () выполняет указанные нами действия.
// Но перед этим он сначала вызывает метод build (). После сборки действие выполняется


//dragAndDropBy(WebElementsource, int xOffset, int yOffset)