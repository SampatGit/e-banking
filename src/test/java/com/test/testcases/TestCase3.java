package com.test.testcases;

import com.test.resources.DriverSource;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase3 extends DriverSource {

    @BeforeMethod
    public void loadUrl(){
        driverInstance.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    }

    public void selectDropdown() throws InterruptedException {
        WebElement element  = driverInstance.findElement(By.xpath("//select[@class = 'form-control']"));
        Select select = new Select(element);
        select.selectByValue("Tuesday");
        String value = driverInstance.findElement(By.xpath("//p[@class='selected-value']")).getText();
        Assert.assertTrue(value.contains("Tuesday"));
        Thread.sleep(2000);
    }

    @Test
    public void multiSelect() throws InterruptedException {
        WebElement element = driverInstance.findElement(By.xpath("//select[@id='multi-select']"));
        Select select = new Select(element);
        Actions actions = new Actions(driverInstance);
        WebElement select1 = driverInstance.findElement(By.xpath("//option[@value='Florida']"));
        WebElement select2 = driverInstance.findElement(By.xpath("//option[@value='New York']"));
        if(select.isMultiple()){
            actions.keyDown(Keys.CONTROL).click(select1).click(select2).click(driverInstance.findElement(By.xpath("//p[@class='getall-selected']"))).build().perform();
        }
        Thread.sleep(5000);
        driverInstance.findElement(By.xpath("//button[@id='printAll']")).click();
        Thread.sleep(3000);
        String value = driverInstance.findElement(By.xpath("//p[@class='getall-selected']")).getText();
        System.out.println(value);
        Assert.assertTrue(value.contains("Florida,New York"));

    }

}