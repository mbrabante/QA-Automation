package stepDefinition.Brand;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import stepDefinition.WebDriver_Setup;
import pageObjects.Admin_CreateBrandPage;
import pageObjects.Admin_LoginPage;
import pageObjects.Admin_MainMenu;
import pageObjects.Admin_BrandsPage;
import helperMethods.Utilities;

public class CreateBrand extends WebDriver_Setup {
	
	WebDriver driver = getDriver();
	
	@Before("@CBTC001")
	public void loginToAdmin() {
		Admin_LoginPage lp = new Admin_LoginPage(driver);
		
		//Login to Admin Portal
		lp.loginToAdmin();
		
	}
	
	@After("@CBTC003")
	public void closeBrowser() {
		driver.close();
	}


	@Given("^User is in Brand module main page$")
	public void user_is_in_Brand_module_main_page() throws Throwable {
		Admin_MainMenu mainMenu = new Admin_MainMenu(driver);
		
		Thread.sleep(1000);
		
		//Select Brands module from the Catalog dropdown
		mainMenu.selectBrandFromCatalog();
	}

	@When("^User clicks on the Create a New Brand button$")
	public void user_clicks_on_the_Create_a_New_Brand_button() throws Throwable {
		Admin_BrandsPage brandsPage = new Admin_BrandsPage(driver);
		
		//Click Create a New Brand button
		brandsPage.click_CreateBrand();
	}

	@When("^Populate all the required fields with valid data$")
	public void populate_all_the_required_fields_with_valid_data() throws Throwable {
		Admin_CreateBrandPage createBrand = new Admin_CreateBrandPage(driver);
		
		//Enter new Brand Name
		createBrand.fillBrandDetails();
		
		//Click Save button
		createBrand.click_SaveBrand();
	}

	@Then("^New brand is successfully created$")
	public void new_brand_is_successfully_created() throws Throwable {
		Admin_CreateBrandPage createBrand = new Admin_CreateBrandPage(driver);
		
		Thread.sleep(1000);
		
		//Verify confirmation message
		String response = createBrand.get_msgAfterClickSave();
		Assert.assertTrue(response.contains("The Brand added successfully."));
		
		//Click OK button
		createBrand.click_OKMessage();

	}

	@Then("^Added to the Brand list$")
	public void added_to_the_Brand_list() throws Throwable {
		Admin_BrandsPage brandsPage = new Admin_BrandsPage(driver);
		Admin_CreateBrandPage createBrand = new Admin_CreateBrandPage(driver);
		
		String table = brandsPage.get_BrandTableContent();
		String bname = createBrand.get_BrandName();
		System.out.print(bname);
		System.out.print("test");
		Assert.assertTrue(table.contains(bname));
		
		Utilities.captureScreenshot(driver, "CBTC001_Created New Brand");
		
	}
	
	@When("^Populate all the required fields using an existing brand$")
	public void populate_all_the_required_fields_using_an_existing_brand() throws Throwable {
	    Admin_CreateBrandPage createBrand = new Admin_CreateBrandPage(driver);
	    
		//Enter existing Brand Name
		createBrand.fillBrandDetails();
	    
		//Click Save button
		createBrand.click_SaveBrand();
	}

	@Then("^Error message is displayed$")
	public void error_message_is_displayed() throws Throwable {
		Admin_CreateBrandPage createBrand = new Admin_CreateBrandPage(driver);
		
		//Verify error message
		String response = createBrand.get_msgAfterClickSave();
		Assert.assertTrue(response.contains("The brand already exists"));
		
		//Click OK button
		createBrand.click_OKMessage();
		
	}

	@When("^User leaves the required fields blank$")
	public void user_leaves_the_required_fields_blank() throws Throwable {
		Admin_BrandsPage brandsPage = new Admin_BrandsPage(driver);
		Admin_CreateBrandPage createBrand = new Admin_CreateBrandPage(driver);
		
		Thread.sleep(2000);
		
		//Click Back button
		createBrand.click_Back();
		
		//Click Create a New Brand button
		brandsPage.click_CreateBrand();
	    
		//Click Save button
		createBrand.click_SaveBrand();
	}

	@Then("^Error message under the required fields are displayed$")
	public void error_message_under_the_required_fields_are_displayed() throws Throwable {
	    
		//Verify Brand Name error message
		String errBName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rfvName")).getText();
		Assert.assertTrue(errBName.equals("Please enter brand name."));
		
		//Verify Brand Name error message
		//String errBDName = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rfvName")).getText();
		//Assert.assertTrue(errBDName.equals("Please enter brand display name."));
		
		//Verify Brand Name error message
		//String errBCode = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rfvName")).getText();
		//Assert.assertTrue(errBCode.equals("Please enter brand code."));
	}

}
