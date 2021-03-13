package com.test.testcases;

import com.test.resources.DriverSource;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;


public class TestCase7 extends DriverSource {

    @BeforeMethod
    public void getUrl(){
        driverInstance.get("https://demoqa.com/droppable");
    }

    @Test
    public void dragAndDrop(){
        Actions action = new Actions(driverInstance);
        WebElement source = driverInstance.findElement(By.id("draggable"));
        WebElement destination = driverInstance.findElement(By.id("droppable"));
        action.dragAndDrop(source, destination).build().perform();
        String backColor = driverInstance.findElement(By.xpath("//div[@class='drop-box ui-droppable ui-state-highlight']")).getCssValue("background-color");
        String color = Color.fromString(backColor).asHex();
        Assert.assertEquals("#4682b4", color);

    }
}
