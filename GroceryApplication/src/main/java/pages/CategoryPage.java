package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {
	public WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")WebElement newButton ;
	@FindBy(xpath = "//input[@id='category']")WebElement category;
	//@FindBy(xpath = "//select[@id='grp_id']")WebElement groupsDropDown;
	@FindBy(xpath = "//li[@id='2-selectable']")WebElement groups;
	@FindBy(xpath = "//input[@id='main_img']")WebElement image;
	@FindBy(xpath = "//button[@type='submit']")WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")WebElement blueSearch;
	@FindBy(xpath = "//input[@class='form-control']")WebElement categorySearch;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")WebElement redSearch;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement table;

	
	public CategoryPage clickNewButton() {
		newButton.click();
		return this;
	}
	public CategoryPage enterCategoryOnCategoryField(String categoryValue) {
		category.sendKeys(categoryValue);
		return this;
	}
	public CategoryPage selectGroupsFromGroupsField() {
		//groupsDropDown.click();
		groups.click();
		return this;
	}
	public CategoryPage chooseFileForImage() {
		image.sendKeys("C:\\Users\\Nihlah\\OneDrive\\圖片\\Screenshots\\Screenshot 2026-11-08 132309.png");
		return this;
	}
	public CategoryPage clickSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, 200)", "");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		return this;
	}
	public String verifyAddCategoryAlertIsDisplayed() {
		return alert.getText();
	}
	public CategoryPage clickBlueSearchButton() {
		blueSearch.click();
		return this;
	}
	public CategoryPage enterCategoryOncategoryField(String categoryValue) {
		categorySearch.sendKeys(categoryValue);
		return this;
	}
	public CategoryPage clickRedSearchButton() {
		redSearch.click();
		return this;
	}
	public String verifySearchUserisDisplayed() {
		return table.getText();
	}

}
