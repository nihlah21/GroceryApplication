package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage1 {
	public WebDriver driver;
	WaitUtility wu = new WaitUtility();
	
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='username']")WebElement username;
	@FindBy(xpath = "//input[@name='password']")WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")WebElement signIn;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement loginPageText;
	
	
	
	public LoginPage1 enterUsernameOnUsernameField(String usernameValue) {
		username.sendKeys(usernameValue);
		return this;
	}
	public LoginPage1 enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}
	public HomePage clickSignInButton() {
		wu.waitUntilElementToBeClickable(driver, signIn);
		signIn.click();
		return new HomePage(driver);
	}
	public boolean verifyWhetherDashboardIsDisplayed() {
		return dashboard.isDisplayed();
	}
	public String verifyWhetherLoginTextIsDisplayed() {
		return loginPageText.getText();
	}

}
