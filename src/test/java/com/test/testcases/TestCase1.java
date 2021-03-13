package com.test.testcases;

import com.test.resources.DriverSource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*** Test Case 1: Simple form in selenium easy portal***/

public class TestCase1 extends DriverSource {

    @Test
    public void displayMessage(){
        String sendText = "HELLO SELENIUM";
        driverInstance.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driverInstance.findElement(By.id("user-message")).sendKeys(sendText);
        driverInstance.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();
        String displayedText = driverInstance.findElement(By.id("display")).getText();
        Assert.assertEquals(displayedText, sendText);


    }

    @Test(dependsOnMethods = "displayMessage")
    public void verifyAddResult() throws InterruptedException {
        int a = 3;
        int b = 4;
        driverInstance.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driverInstance.findElement(By.id("sum1")).sendKeys(""+a+"");
        driverInstance.findElement(By.id("sum2")).sendKeys(""+b+"");
        driverInstance.findElement(By.xpath("//button[contains(text(), 'Get Total')]")).click();
        SoftAssert sa = new SoftAssert();
        WebDriverWait wait = new WebDriverWait(driverInstance, 3000);
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("displayvalue"))).getAttribute("innerText");
        sa.assertEquals( Integer.parseInt(value), a+b);
        sa.assertAll();
    }


}
