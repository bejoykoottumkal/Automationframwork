package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class DragNdrop {

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","D://chromedriver/chromedriver.exe");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://jqueryui.com/droppable/#default");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Actions Act = new Actions(driver);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        Act.dragAndDrop(driver.findElement(By.xpath("//div[@id = 'draggable']")),driver.findElement(By.xpath("//div[@id = 'droppable']"))).build().perform();











    }
}
