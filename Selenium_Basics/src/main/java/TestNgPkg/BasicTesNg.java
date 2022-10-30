package TestNgPkg;

import org.testng.annotations.*;

public class BasicTesNg {

    @Test
    public void sample(){
        System.out.println("Test Method");
    }
    @BeforeMethod
    public void bSample(){
        System.out.println("Before Method");
    }
    @Test
    public void cSample(){
        System.out.println("Test Method : 2");
    }
    @AfterMethod
    public void dSample(){
        System.out.println("After Method");
    }
    @AfterClass
    public void eSample(){
        System.out.println("After Class");
    }
    @BeforeClass
    public void fSample(){
        System.out.println("Before Class");
    }
    @AfterTest
    public void gSample(){
        System.out.println("After Test");
    }
    @BeforeTest
    public void hSample(){
        System.out.println("Before Test");
    }
}
