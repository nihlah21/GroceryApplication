package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageDeliveryBoyPage {
public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=' New']")WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")WebElement name;
	@FindBy(xpath = "//input[@id='email']")WebElement email;
	@FindBy(xpath = "//input[@id='phone']")WebElement phoneNumber;
	@FindBy(xpath = "//textarea[@id='address']")WebElement address;
	@FindBy(xpath = "//input[@id='username']")WebElement username;
	@FindBy(xpath = "//input[@id='password']")WebElement password;
	@FindBy(xpath = "//button[@class='btn btn-danger']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	
	public ManageDeliveryBoyPage clickNewButton() {
		newButton.click();
		return this;
	}
	public ManageDeliveryBoyPage enterNameOnNameField(String nameValue) {
		name.sendKeys(nameValue);
		return this;
	}
	public ManageDeliveryBoyPage enterEmailOnEmailField(String emailValue) {
		email.sendKeys(emailValue);
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumberOnPhoneNumberField(String phoneNumberValue) {
		phoneNumber.sendKeys(phoneNumberValue);
		return this;
	}
	public ManageDeliveryBoyPage enterAddressOnAddressField(String addressValue) {
		address.sendKeys(addressValue);
		return this;
	}
	public ManageDeliveryBoyPage enterUsernameOnUsernameField(String UsernameValue) {
		username.sendKeys(UsernameValue);
		return this;
	}
	public ManageDeliveryBoyPage enterPasswordOnPasswordField(String passwordValue) {
		password.sendKeys(passwordValue);
		return this;
	}
	public ManageDeliveryBoyPage clickSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 150)", "");
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
	    
		saveButton.click();
		return this;
	}
	public String verifyAddDeliveryBoyAlertIsDisplayed() {
		return alert.getText();
	}
	

}
