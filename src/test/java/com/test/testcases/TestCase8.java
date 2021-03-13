package com.test.testcases;




import com.test.resources.DriverSource;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase8 extends DriverSource {

    @BeforeMethod
    public void getUrl(){
        driverInstance.get("https://demoqa.com/nestedframes");

    }

    @Test
    public void getTotalFrames() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor)driverInstance;
        Thread.sleep(5000);
        js.executeScript("history.go(0)");

    }

}
