package pageObjects;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Admin_CreateBrandPage {
	
	public Admin_CreateBrandPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtName")
	private WebElement txtbx_BrandName;
	
	@FindBy(how = How.ID, using = "btnSave")
	private WebElement btn_SaveBrand;
	
	@FindBy(how = How.LINK_TEXT, using = "Back")
	private WebElement btn_Back;
	
	@FindBy(how = How.ID, using = "okbtn")
	private WebElement btn_OKMessage;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='modal-dialog modal-sm']/.//div[@class='modal-content']/.//div[@class='modal-body']")
	private WebElement msgbx_AfterClickSave;
	
	public void enter_BrandName(String BName) {
		txtbx_BrandName.sendKeys(BName);
	}
	
	public void click_SaveBrand() {
		btn_SaveBrand.click();
	}
	
	public void click_Back() {
		btn_Back.click();
	}
	
	public void fillBrandDetails() {
		enter_BrandName("5QABRAND");
		get_BrandName();
	}
	
	public void click_OKMessage() {
		btn_OKMessage.click();
	}
	
	public String get_BrandName() {
		return txtbx_BrandName.getText();
	}
	
	public String get_msgAfterClickSave() {
		return msgbx_AfterClickSave.getText();
	}
	
	public void createNewBrand() {
		fillBrandDetails();
		get_BrandName();
		click_SaveBrand();
		click_OKMessage();
	}
}
