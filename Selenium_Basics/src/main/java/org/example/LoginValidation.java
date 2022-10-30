package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id = 'SubmitLogin']")).click();
        String expTitle = "My account - My Store";
        String actTitle = driver.getTitle();


        if(expTitle.contentEquals(actTitle))
        {
            System.out.println("Test Case Passed");
        }
        else {
            System.out.println("Test Case Failed");
        }
        //  driver.close();
    }
}
