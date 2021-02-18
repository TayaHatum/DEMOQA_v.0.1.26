package com.telran.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        app.dropDrag().selectItemInteractions();
    }

    @Test
    public void droppableTest(){
        app.dropDrag().selectDroppable();
        app.dropDrag().actionDragMe();
       // app.dropDrag().dragAndDropBy();
//    app.dropDrag().dragAndDropBy100();

    }

}
