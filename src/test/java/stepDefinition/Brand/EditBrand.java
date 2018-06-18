package stepDefinition.Brand;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

public class EditBrand extends WebDriver_Setup{

	WebDriver driver = getDriver();
	String brand;
	
	@Before("@EBTC001")
	public void loginToAdmin() {
		Admin_LoginPage lp = new Admin_LoginPage(driver);
		
		//Login to Admin Portal
		lp.loginToAdmin();
		
	}
	
	@After("@EBTC002")
	public void closeBrowser() {
		driver.close();
	}
	
	@Given("^User created a new brand$")
	public void user_created_a_new_brand() throws Throwable {
		Admin_BrandsPage bp = new Admin_BrandsPage(driver);
		Admin_CreateBrandPage cb = new Admin_CreateBrandPage(driver);
		Admin_MainMenu menu = new Admin_MainMenu(driver);
		
		menu.selectBrandFromCatalog();
		bp.click_CreateBrand();
		cb.fillBrandDetails();
		cb.click_SaveBrand();
		brand = cb.get_BrandName();
		
		cb.click_OKMessage();
	    
		
	}

	@When("^User search the created brand from Brand page$")
	public void user_search_the_created_brand_from_Brand_page() throws Throwable {
		Admin_BrandsPage bp = new Admin_BrandsPage(driver);
		
	    bp.enter_SearchBrand(brand);
	    bp.click_SearchBrand();
	}

	@When("^Update the brand with valid new Brand Name$")
	public void update_the_brand_with_valid_new_Brand_Name() throws Throwable {
	    
	 
	}

	@Then("^Brand is updated successfully$")
	public void brand_is_updated_successfully() throws Throwable {
	    
	    
	}
	
}
