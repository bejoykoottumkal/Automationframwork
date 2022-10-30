package TestNgPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

    @Listeners (TestNgListner.class)
public class LoginValidation {
    WebDriver driver;
    @BeforeMethod
    public void Initialize()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void Login() {

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
    @AfterMethod
    public void Close(){
        driver.quit();

    }

}
