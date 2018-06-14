package pageObjects;

//import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Admin_LoginPage {

	WebDriver driver;

	public Admin_LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}						
	
	@FindBy(how = How.ID, using = "ctl00_cphBody_txtUserName")
	private WebElement txtbx_UserName;
	
	@FindBy(how = How.ID, using = "ctl00_cphBody_txtPwd")
	private WebElement txtbx_Password;
	
	@FindBy(how = How.ID, using = "ctl00_cphBody_btnLogin")
	private WebElement btn_Login;
	
	public void navigateTo_LoginPage() {
		driver.manage().window().maximize();
		driver.get("http://demo-admin.ascentisecommerce.com/");
	}
	
	public void enter_UserName(String UName) {
		txtbx_UserName.sendKeys(UName);
	}
	
	public void enter_Password(String Pass) {
		txtbx_Password.sendKeys(Pass);
	}
	
	public void click_Login() {
		btn_Login.click();
	}
	
	public void fillLoginDetails() {
		enter_UserName("mbrabante");
		enter_Password("Dont4get");
	}
	
	public void loginToAdmin() {
		navigateTo_LoginPage();
		fillLoginDetails();
		click_Login();
	}
}
