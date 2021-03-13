package com.test.resources;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class DriverSource<driverInstance> {

    public static WebDriver driverInstance = null;
    @Parameters("browser")
    @BeforeTest()
    public void loadDriver(String browser){
        if(driverInstance == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver_87.exe");
                driverInstance = new ChromeDriver();
            }
            if(browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.chrome.driver", "/src/test/resources/geckodriver.exe");
                driverInstance = new FirefoxDriver();
            }

        }
        System.out.println("DRIVER INITIALIZED SUCCESSFULLY");
        driverInstance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverInstance.manage().window().maximize();

    }

    @AfterTest
    public void exitTest(){
        driverInstance.quit();
        driverInstance = null;
    }

}
