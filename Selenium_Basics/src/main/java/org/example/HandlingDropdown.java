package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Select sel=new Select(driver.findElement(By.xpath("//select[@name='dropdown-class-example']")));
        //sel.selectByVisibleText("Option1");
        sel.selectByValue("option1");


    }
}
