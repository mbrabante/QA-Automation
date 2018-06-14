package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLogin extends WebDriver_Setup{
	
	WebDriver driver = getDriver();
	
	@Given("^User launched the Admin Portal$")
	public void user_launched_the_Admin_Portal() throws Throwable {
		//Launch Admin Portal
		driver.manage().window().maximize();
		driver.get("http://demo-admin.ascentisecommerce.com/");

	}

	@When("^User enter valid username and password$")
	public void user_enter_valid_username_and_password() throws Throwable {
	   //Enter username and password
		driver.findElement(By.id("ctl00_cphBody_txtUserName")).sendKeys("sysadmin@sysadmin.com");
		driver.findElement(By.id("ctl00_cphBody_txtPwd")).sendKeys("Test1234567");

		//Click login button
		driver.findElement(By.id("ctl00_cphBody_btnLogin")).click();

	}

	@Then("^Admin page is displayed$")
	public void admin_page_is_displayed() throws Throwable {
		//Hover to Catalog(Book) icon from the Main Menu
		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(".//*[@id='main-menu']/.//ul[@class='navigation']/.//i[@class='menu-icon fa fa-book']"));
		builder.moveToElement(element).perform();
		
		//Select 'Brands' from the Catalog list
		WebElement dropdown = driver.findElement(By.xpath(".//*[@class='mmc-dropdown-delay animated fadeInLeft mmc-dropdown-open-ul']"));
		
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals("Brands"))
		    {
		        option.click(); 
		        break;
		    }
		}
		
		//Click Create a New Brand button
		driver.findElement(By.id("Button1")).click();
		

	}

}
