package com.test.testcases;

import com.test.resources.DriverSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase9 extends DriverSource {

    @BeforeMethod
    public void getUrl(){
        driverInstance.get("https://demoqa.com/date-picker");
    }
    @Test
     public void pickDate() throws InterruptedException {
        String dateVal = "03/03/2021";
        WebElement ele = driverInstance.findElement(By.id("datePickerMonthYearInput"));
        JavascriptExecutor jse = (JavascriptExecutor) driverInstance;
        jse.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", ele);
        Thread.sleep(5000);
    }

}
