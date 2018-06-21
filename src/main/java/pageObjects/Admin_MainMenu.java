package pageObjects;

//import java.util.List;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Admin_MainMenu {
	
	WebDriver driver;
	
	public Admin_MainMenu(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = ".//*[@id='main-menu']/.//ul[@class='navigation']/.//i[@class='menu-icon fa fa-book']")
	private WebElement mainmenu_Catalog;
	
	@FindBy(how = How.LINK_TEXT, using = "Brands")
	private WebElement selectBrands;
	
	public void goTo_Catalog() {
		mainmenu_Catalog.click();
	}
	
	public void selectBrand() {
		selectBrands.click();
	}
	
	public void selectBrandFromCatalog() {
		//Select Catalog(Book) icon from the Main Menu
		goTo_Catalog();
		
		//Select Brands module
		selectBrand();
	}
}
