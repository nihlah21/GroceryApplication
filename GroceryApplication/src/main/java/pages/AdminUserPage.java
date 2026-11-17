package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUserPage {
public WebDriver driver;
PageUtility pu = new PageUtility();
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton;
	@FindBy(xpath = "//input[@id='username']")WebElement username;
	@FindBy(xpath = "//input[@id='password']")WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")WebElement save;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement blueSearch;
	@FindBy(xpath = "//input[@id='un']")WebElement searchUsername;
	@FindBy(xpath = "//select[@id='ut']")WebElement searchUserType;
	@FindBy(xpath = "//button[@name='Search']")WebElement redSearch;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement table;

	
	
	
	public AdminUserPage clickNewButton() {
		newButton.click();
		return this;
	}
	public AdminUserPage enterAdminUsernameOnUsernameField(String adminUsername) {
		username.sendKeys(adminUsername);
		return this;
	}
	public AdminUserPage enterAdminPasswordOnPasswordField(String adminPassword) {
		password.sendKeys(adminPassword);
		return this;
	}
	public AdminUserPage selectUserType() {
		pu.selectDropDownWithIndex(userType, 2);
		return this;
		//Select select = new Select(userType);
		//select.selectByIndex(2);
		
	}
	public AdminUserPage clickSaveButton() {
		save.click();
		return this;
	}
	public AdminUserPage clickBlueSearch() {
		blueSearch.click();
		return this;
	}
	public AdminUserPage enterUsernameOnSearchUsernameField(String adminUsername) {
		searchUsername.sendKeys(adminUsername);
		return this;
	}
	public AdminUserPage searchUserTypeOnUsertypeField() {
		pu.selectDropDownWithIndex(searchUserType, 2);
		return this;
	}
	public AdminUserPage clickRedSearch() {
		redSearch.click();
		return this;
	}
	public String verifyAddUserAlertIsDisplayed() {
		return alert.getText();
	}
	public String verifySearchUserIsDisplayed() {
		return table.getText();
	}

}
