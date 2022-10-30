package TestNgPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class dropdownVal {

    WebDriver driver;

    @BeforeMethod
    public void Initialise() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void dropDown() {

        Select sel = new Select(driver.findElement(By.xpath("//select[@name='dropdown-class-example']")));
        //sel.selectByVisibleText("Option1");
        sel.selectByValue("option1");

    }
        @AfterMethod
        public void close() {
            driver.quit();


    }
}