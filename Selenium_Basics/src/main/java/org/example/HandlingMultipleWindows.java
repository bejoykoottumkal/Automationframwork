package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class HandlingMultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String ParentWindowId = driver.getWindowHandle();


        driver.findElement(By.xpath("//button[text() = 'Open Window']")).click();
        Set<String> Windows = driver.getWindowHandles();
        for(String Handle: Windows){
            if (!Handle.equalsIgnoreCase(ParentWindowId)){
                driver.switchTo().window(Handle);
                break;
            }

        }
     /*   driver.switchTo().newWindow(WindowType.WINDOW);*/

        driver.get("https://www.flipkart.com/");
        driver.quit();



    }
}
