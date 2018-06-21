package stepDefinition;

//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



import org.junit.Assert;
import pageObjects.Admin_CreateBrandPage;
import pageObjects.Admin_LoginPage;
import pageObjects.Admin_MainMenu;
import pageObjects.Admin_BrandsPage;
import helperMethods.Utilities;
import managers.Admin_PageObjectManager;
import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;



public class CreateBrandSteps {
	
	WebDriver driver;
	Admin_LoginPage loginPage;
	Admin_MainMenu mainMenu;
	Admin_BrandsPage brandsPage;
	Admin_CreateBrandPage createBrandPage;
	Admin_PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	@Given("^Navigate to Brand page$")
	public void navigate_to_Brand_page() throws Throwable {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		pageObjectManager = new Admin_PageObjectManager(driver);
	    mainMenu = pageObjectManager.getMainMenu();
	    loginPage = pageObjectManager.getLoginPage();
	    
	    //Login to Admin Portal
	  	loginPage.loginToAdmin();
	  	
	    //Select Brands module from the Catalog
		mainMenu.selectBrandFromCatalog();
	}

	@When("^Click on Create New Brand button$")
	public void click_on_Create_New_Brand_button() throws Throwable {
		brandsPage = pageObjectManager.getBrandsPage();
		
		//Click Create a New Brand button
		brandsPage.click_CreateBrand();  
	}

	@When("^Enter valid Brand details$")
	public void enter_valid_Brand_details() throws Throwable {
		createBrandPage = pageObjectManager.getCreateBrandPage();

		//Enter valid Brand details
		createBrandPage.fillBrandDetails();
		
		
	}
	
	@When("^Click on Save button$")
	public void click_on_Save_button() throws Throwable {
		
		//Click Save button
		createBrandPage.click_SaveBrand();
	}

	@Then("^Successful message is displayed$")
	public void successful_message_is_displayed() throws Throwable {
	
	    Thread.sleep(1000);
		
		//Verify confirmation message
		String response = createBrandPage.get_msgAfterClickSave();
		Assert.assertTrue(response.contains("The Brand added successfully."));
		
		//Click OK button
		createBrandPage.click_OKMessage();
		
	}

	@Then("^Added to the Brands list$")
	public void added_to_the_Brands_list() throws Throwable {
		
		String table = brandsPage.get_BrandTableContent();
		Assert.assertTrue(table.contains("1QABRAND"));
		
		Utilities.captureScreenshot(driver, "CBTC001_Created New Brand");
		
		webDriverManager.closeDriver();
		
	}


}
