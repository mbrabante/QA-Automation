package pageObjects;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testDataTypes.Brand;

import java.util.List;
import org.openqa.selenium.By;


public class Admin_CreateBrandPage {
	
	WebDriver driver;
	
	public Admin_CreateBrandPage(WebDriver driver) {
		this.driver = driver;
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
	
	@FindBy(how = How.XPATH, using = ".//*[@class='monthselect']")
	private WebElement dropdown_FromMonth;

	@FindBy(how = How.XPATH, using = ".//*[@class='yearselect']")
	private WebElement dropdown_FromYear;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='monthselect']")
	private WebElement dropdown_ToMonth;

	@FindBy(how = How.XPATH, using = ".//*[@class='yearselect']")
	private WebElement dropdown_ToYear;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='table-condensed']")
	private WebElement table_FromDates;
	
	@FindBy(how = How.XPATH, using = ".//*[@class='table-condensed']")
	private WebElement table_ToDates;
	
	public void selectday(String day) {
		
	}
	
	public void enter_PublishFromDate(String month, String day, String year) {
		
		click_PublishFromDate();
		Select selectMonth = new Select(dropdown_FromMonth);
		selectMonth.selectByVisibleText(month);
		
		Select selectYear = new Select(dropdown_FromYear);
		selectYear.selectByVisibleText(year);
		
		List<WebElement> columns=table_FromDates.findElements(By.tagName("td"));

		for (WebElement cell: columns){ 
		   if (cell.getText().equals(day)){
		      cell.click();
		      break;
		 }
		}
		
	}
	
	public void enter_PublishToDate(String month, String day, String year) {
		
		click_PublishToDate();
		Select selectMonth = new Select(dropdown_ToMonth);
		selectMonth.selectByVisibleText(month);
		
		Select selectYear = new Select(dropdown_ToYear);
		selectYear.selectByVisibleText(year);
		
		List<WebElement> columns=table_ToDates.findElements(By.tagName("td"));

		for (WebElement cell: columns){ 
		   if (cell.getText().equals(day)){
		      cell.click();
		      break;
		 }
		}
	}
	
	public void enter_BrandName(String BName) {
		txtbx_BrandName.sendKeys(BName);
	}
	
	public void enter_BrandImage(String ImgPath) {
		btn_BrandImageUpload.sendKeys(ImgPath);
	}
	
	public void click_SaveBrand() {
		btn_SaveBrand.click();
	}
	
	public void click_PublishFromDate() {
		txtbx_PublishFromDate.click();
	}
	
	public void click_PublishToDate() {
		txtbx_PublishToDate.click();
	}
	
	public void click_Back() {
		btn_Back.click();
	}
	
	public void fillBrandDetails(Brand brand) {
		enter_BrandName(brand.brandName);
		enter_BrandImage(brand.brandImage);
		enter_PublishToDate(brand.publishToDate.toMonth, brand.publishToDate.toDay, brand.publishToDate.toYear);
		enter_PublishFromDate(brand.publishFromDate.fromMonth, brand.publishFromDate.fromDay, brand.publishFromDate.fromYear);

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
	
	/*
	public void createNewBrand() throws InterruptedException {
		fillBrandDetails(brand);
		click_SaveBrand();
		click_OKMessage();
	}
	*/
}
