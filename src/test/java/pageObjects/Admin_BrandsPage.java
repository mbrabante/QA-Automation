package pageObjects;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//import pageObjects.Admin_CreateBrandPage;

public class Admin_BrandsPage {
	
	WebDriver driver;
	
	public Admin_BrandsPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "Button1")
	private WebElement btn_CreateNewBrand;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='brandmanagement_brandmanagement_maintbl']")
	private WebElement list_BrandTable;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtName")
	private WebElement txtbx_SearchBrand;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_btnSearch")
	private WebElement btn_SearchBrand;
	
	public void click_CreateBrand() {
		btn_CreateNewBrand.click();
	}
	
	public String get_BrandTableContent() {
		return list_BrandTable.getText();
	}
	
	public void enter_SearchBrand(String BName) {
		txtbx_SearchBrand.sendKeys(BName);
	}
	
	public void click_SearchBrand() {
		btn_SearchBrand.click();
	}
	
	
}
