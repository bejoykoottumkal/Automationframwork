package TestNg;

import TestNgPkg.TestNgListner;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners (TestNgListner.class)
public class LoginValidation_ExtentReport {
    WebDriver driver;
    ExtentSparkReporter spark;
    ExtentReports report;
    ExtentTest test;

    @BeforeMethod
    public void Initialize() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        Thread.sleep(3000);


        spark = new ExtentSparkReporter("./reports/ExtentReport.html");
        spark.config().setDocumentTitle("ExtentReportSample");
        spark.config().setReportName("ReportSample");
    }

    @Test
    public void Login() {

        report = new ExtentReports();
        report.setSystemInfo("OS", "Windows");
        report.setSystemInfo("Environment", "QA");
        report.attachReporter(spark);
        test = report.createTest("LoginValidation");

        test.log(Status.INFO, "SignIn to customer account");
        driver.findElement(By.xpath("//a[@title = 'Log in to your customer account']")).click();
        test.log(Status.INFO, "Entering username ******");
        driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("automatizeanything@gmail.com");
        test.log(Status.INFO, "Entering password ******");
        driver.findElement(By.xpath("//input[@id = 'passwd']")).sendKeys("Techmasters@123");
        test.log(Status.INFO, "SignIn buttton clicked");
        driver.findElement(By.xpath("//button[@id = 'SubmitLogin']")).click();
        String expTitle = "test";
        String actTitle = driver.getTitle();

        test.log(Status.INFO, "Verifying Title");
        Assert.assertEquals(expTitle, actTitle);
    }

    @AfterClass
    public void Close() {
        report.flush();
        driver.quit();

    }

    @AfterMethod
    public void GenerateReport(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case Passed", ExtentColor.GREEN));

        } else if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
            test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtility.getScreenShot(driver)).build());

        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case Skipped", ExtentColor.YELLOW));
        }

    }
}