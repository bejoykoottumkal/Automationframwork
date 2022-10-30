package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewLoginValidation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://uat1.norkaroots.org/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id = 'sign_in']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='User Name']")).sendKeys("Walter");
        driver.findElement(By.xpath("//input[@id = '_norkalogin_INSTANCE_VJcBYOaE4PoK_password']")).sendKeys("Walter");
        driver.findElement(By.xpath("//button[@type = 'submit'] ")).click();

        String expTitle = "Home - NORKA";
        String actTitle = driver.getTitle();

        if(expTitle.contentEquals(actTitle)){
            System.out.println("Test Case Passed");

        }
        else {
            System.out.println("Test case failed");
        }


    }
}
