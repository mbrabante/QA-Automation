package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.Admin_CreateBrandPage;
import pageObjects.Admin_LoginPage;
import pageObjects.Admin_MainMenu;
import pageObjects.Admin_BrandsPage;

public class Admin_PageObjectManager {

	private WebDriver driver;
	private Admin_CreateBrandPage createBrandPage;
	private Admin_LoginPage loginPage;
	private Admin_MainMenu mainMenu;
	private Admin_BrandsPage brandsPage;
	
	public Admin_PageObjectManager(WebDriver driver) { 
		this.driver = driver;
	}
	
	public Admin_LoginPage getLoginPage(){ 
		return (loginPage == null) ? loginPage = new Admin_LoginPage(driver) : loginPage;
	}
	
	public Admin_MainMenu getMainMenu(){ 
		return (mainMenu == null) ? mainMenu = new Admin_MainMenu(driver) : mainMenu;
	}
	
	public Admin_BrandsPage getBrandsPage(){ 
		return (brandsPage == null) ? brandsPage = new Admin_BrandsPage(driver) : brandsPage;
	}
	
	public Admin_CreateBrandPage getCreateBrandPage(){ 
		return (createBrandPage == null) ? createBrandPage = new Admin_CreateBrandPage(driver) : createBrandPage;
	}
	
}
