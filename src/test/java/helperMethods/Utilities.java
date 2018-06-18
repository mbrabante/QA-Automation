package helperMethods;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Utilities {

	public static void captureScreenshot(WebDriver driver, String screenshotName)

	{
	try {
	TakesScreenshot ts = (TakesScreenshot)driver;

	File source = (File) ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("C:\\Users\\Staff - QA\\Git Project\\ECommerce\\Screenshots\\"+screenshotName+".png"));

	} catch (Exception e) {

	}
	}

}
