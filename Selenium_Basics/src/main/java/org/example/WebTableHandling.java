package org.example;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

public class WebTableHandling {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-handle-calendar-in-selenium.html");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("datepicker")).click();


        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));

        for (WebElement ele:allDates)
        {
            String date = ele.getText();
            if (date.equalsIgnoreCase("22")){
                ele.click();
                break;
            }
        }
        ScreenshotUtility Screen = new ScreenshotUtility();
        Screen.getScreenShot(driver);











    }
}
