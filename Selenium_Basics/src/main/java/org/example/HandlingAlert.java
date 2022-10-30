package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingAlert {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

       driver.findElement(By.xpath("//input[@id = 'alertbtn']")).click();

        Alert al = driver.switchTo().alert();


        String AlrtMsg = al.getText();

        al.accept();

        System.out.println(AlrtMsg);




    }
}
