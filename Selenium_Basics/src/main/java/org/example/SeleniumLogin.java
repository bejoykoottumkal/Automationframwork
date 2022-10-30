package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLogin {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String expURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
        String actURL = driver.getCurrentUrl();


        if(expURL.contentEquals(actURL))
        {
            System.out.println("Test Case Passed");
        }
        else {
            System.out.println("Test Case Failed");
        }
      //  driver.close();

    }
}
