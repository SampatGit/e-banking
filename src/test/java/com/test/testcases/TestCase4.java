package com.test.testcases;

import com.test.resources.DriverSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestCase4 extends DriverSource {
    @BeforeMethod
    public void loadUrl(){

        driverInstance.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");

    }

    @Test
    public void iterateTable() throws InterruptedException {
        String rowXpath = "//table[@id='example']/tbody/tr";
        int tableSize = driverInstance.findElements(By.xpath("//a[@class='paginate_button ']")).size() + 1;
        int size = 1;
        HashMap<String, Integer> map = new HashMap<>();
      while(size<= tableSize){
          List<WebElement> elements = driverInstance.findElements(By.xpath(rowXpath));

          for(int i=1; i<= elements.size(); i++ ){
             String name = driverInstance.findElement(By.xpath(rowXpath+"["+i+"]/td[1]")).getText();
             int age = Integer.parseInt(driverInstance.findElement(By.xpath(rowXpath+"["+i+"]/td[4]")).getText());
             map.put(name, age);
          }

          driverInstance.findElement(By.id("example_next")).click();
          Thread.sleep(3000);
          size++;

      }
      List<String> list = map.keySet().stream().filter(key -> map.get(key)> 60).collect(Collectors.toList());
      for(String name: list){
          System.out.println(name);
      }


    }
}
