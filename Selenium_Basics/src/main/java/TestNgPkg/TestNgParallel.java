package TestNgPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgParallel {


    @Test
    public void LoginChrome() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
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


        if (expTitle.contentEquals(actTitle)) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }
    }
    @Test
    public void LoginFireFox() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("automatizeanything@gmail.com");
        driver.findElement(By.xpath("//input[@id = 'passwd']")).sendKeys("Techmasters@123");
        driver.findElement(By.xpath("//button[@id = 'SubmitLogin']")).click();
        String expTitle = "My account - My Store";
        String actTitle = driver.getTitle();


        if (expTitle.contentEquals(actTitle)) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }
    }

}
