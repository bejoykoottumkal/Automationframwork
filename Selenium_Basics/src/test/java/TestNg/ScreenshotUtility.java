package TestNg;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {
    public static String getScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        String source = ts.getScreenshotAs(OutputType.BASE64);
//        String path = "./ScreenShots/Sample.jpeg";
//        File dest = new File(path);
//        FileUtils.copyFile(source,dest);

        return source;


    }
}
