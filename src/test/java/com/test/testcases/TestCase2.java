package com.test.testcases;

import com.test.resources.DriverSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class TestCase2 extends DriverSource {

    WebDriver driver = driverInstance;

    @BeforeMethod
    public void openUrl(){
        driverInstance.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    }

    @Test
    public void checkSingleCheckBox() throws InterruptedException {

        WebElement element = driverInstance.findElement(By.xpath("//input[@id='isAgeSelected']"));
        if(!element.isSelected()){
            element.click();
        }
        Thread.sleep(2000);
        String message = driverInstance.findElement(By.xpath("//div[@id='txtAge']")).getText();
        Assert.assertEquals(message, "Success - Check box is checked");
    }


    /**To select check box 1, 3, 4 and verify uncheck all button is displayed**/
    @Test
    public void multipleCheckbox() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driverInstance;
        List<WebElement> wel = driverInstance.findElements(By.xpath("//input[@class='cb1-element']/.."));
        Thread.sleep(3000);
        for(WebElement ele: wel){
            if(ele.getText().contains("1")||ele.getText().contains("3")||ele.getText().contains("4")){
                   if(!ele.isSelected()){
                       ele.click();
                   }
            }
        }
        Thread.sleep(2000);
        Assert.assertEquals(driverInstance.findElements(By.xpath("//input[@value='Uncheck All']")).size(), 0);


    }

}
