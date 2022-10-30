package TestNgPkg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListner implements ITestListener
{
    public void onTestStart(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Task Started");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Task Success");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("=======================================================");
        System.out.println("Task Failed");
    }

    public void onFinish(ITestContext context) {
        System.out.println("=======================================================");
        System.out.println("Task Completed");
    }
}
