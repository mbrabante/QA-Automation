package stepDefinition;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Setup {

	protected static WebDriver driver;

	
	protected WebDriver getDriver() {
	
		if (driver == null){
			File file = new File("C:/Driver/chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
		return driver;
	}

	
}

