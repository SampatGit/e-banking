package com.test.testcases;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.configuration.JavaScriptConfiguration;
import com.test.resources.DriverSource;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 extends DriverSource {

    @BeforeMethod
    public void loadUrl(){
        driverInstance.get("https://demoqa.com/alerts");
    }

    @Test(enabled = false)
    public void checkAlert() throws InterruptedException {
        driverInstance.findElement(By.id("alertButton")).click();
        Thread.sleep(3000);
        System.out.println(driverInstance.switchTo().alert().getText());
    }

    @Test(enabled = false)
    public void acceptDismissAlert() throws InterruptedException {
        driverInstance.findElement(By.id("confirmButton")).click();
        driverInstance.switchTo().alert().accept();
        String message = driverInstance.findElement(By.id("confirmResult")).getText();
        Thread.sleep(2000);
        System.out.println(message);
        Assert.assertTrue(message.contains("Ok"));
    }

    @Test(enabled = false)
    public void enterText() throws InterruptedException {
        String message = "Test";
        driverInstance.findElement(By.id("promtButton")).click();
        Alert alert = driverInstance.switchTo().alert();
        alert.sendKeys(message);
        alert.accept();
        String message1 = driverInstance.findElement(By.id("promptResult")).getText();
        Thread.sleep(3000);
        System.out.println(message1);
        Assert.assertTrue(message1.contains(message));

    }

    @Test
    public void setAlertJse() throws InterruptedException {
        WebElement element = driverInstance.findElement(By.id("alertButton"));
//        Alert alert = driverInstance.switchTo().alert();
        JavascriptExecutor js = (JavascriptExecutor)driverInstance;
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(3000);


    }
}

