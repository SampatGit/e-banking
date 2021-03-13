package com.test.testcases;


import com.test.resources.DriverSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCase5 extends DriverSource {
    @BeforeMethod
    public void getUrl(){
        driverInstance.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
    }
    @Test
    public void dragSlider() throws InterruptedException {
        WebElement element = driverInstance.findElement(By.xpath("//div[@id='slider1']/div/input"));

        Thread.sleep(2000);
        move(true, 5, driverInstance, element);
        Thread.sleep(5000);
    }

    public void move(boolean isLeft, int moveBy, WebDriver driver, WebElement element){
        Actions actions;
        if(isLeft){
            actions = new Actions(driver);
            for(int i=0; i<= moveBy; i++){
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        }
        else
        {
            actions = new Actions(driver);
            for(int i=0; i<= moveBy; i++){
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }

    }



}
