package TestNgPkg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login_DataProvider {
    WebDriver driver;
    @BeforeMethod
    public void Initialize()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
        @DataProvider(name = "loginDataProvider")
        public static Object[][] credentials() {

            return new Object[][] { { "automatizeanything@gmail.com", "Techmasters@123", "Test" }, { "testuser_1", "Test@123","Test1" }};

        }
    @Test(dataProvider = "loginDataProvider")
    public void Login(String username,String password, String sample) {

        driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']")).click();
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id = 'passwd']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id = 'SubmitLogin']")).click();
        String expTitle = "My account - My Store";
        String actTitle = driver.getTitle();
       // Assert.assertEquals(expTitle, actTitle);
        System.out.println(sample);
        Assert.assertTrue(expTitle.contentEquals(actTitle));
      /*  if (expTitle.contentEquals(actTitle)) {
            System.out.println("Test Case Passed");
        } else {
            System.out.println("Test Case Failed");
        }*/

    }
    @AfterMethod
    public void Close(){
        driver.quit();

    }
}
