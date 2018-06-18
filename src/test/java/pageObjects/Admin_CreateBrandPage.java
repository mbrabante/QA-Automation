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
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_f_UploadImage")
	private WebElement btn_BrandImageUpload;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtPublishFrom")
	private WebElement txtbx_PublishFromDate;
	
	@FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_txtPublishTo")
	private WebElement txtbx_PublishToDate;
	
	public void enter_BrandName(String BName) {
		txtbx_BrandName.sendKeys(BName);
	}
	
	public void enter_BrandImage(String ImgPath) {
		btn_BrandImageUpload.sendKeys(ImgPath);
	}
	
	public void enter_PublishFromDate(String FromDate) {
		txtbx_PublishFromDate.sendKeys(FromDate);
	}
	
	public void enter_PublishToDate(String ToDate) {
		txtbx_PublishToDate.sendKeys(ToDate);
	}
	
	public void click_SaveBrand() {
		btn_SaveBrand.click();
	}
	
	public void click_Back() {
		btn_Back.click();
	}
	
	public void fillBrandDetails() {
		enter_BrandName("3QABRAND");
		enter_BrandImage("C:\\Users\\Staff - QA\\Pictures\\qabrandimg.jpg");
		enter_PublishFromDate("1/1/2018");
		enter_PublishToDate("12/31/2999");
	}
	
	public void click_OKMessage() {
		btn_OKMessage.click();
	}
	
	public void click_BrandImageUpload() {
		btn_BrandImageUpload.click();
	}
	
	public String get_BrandName() {
		return txtbx_BrandName.getText();
	}
	
	public String get_msgAfterClickSave() {
		return msgbx_AfterClickSave.getText();
	}
	
	public void createNewBrand() {
		fillBrandDetails();
		click_SaveBrand();
		click_OKMessage();
	}
}
