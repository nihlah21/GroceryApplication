package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']")WebElement adminUser;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy'and @class='small-box-footer']")WebElement manageDeliveryBoy;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement category;
	
	public HomePage clickAdmin() {
		admin.click();
		return this;
	}
	public LoginPage1 clickLogout() {
		logout.click();
		return new LoginPage1(driver);
	}
	public AdminUserPage clickAdminUserMoreInfo() {
		adminUser.click();
		return new AdminUserPage(driver);
	}
	public ManageDeliveryBoyPage clickManageDeliveryBoyMoreInfo() {
		manageDeliveryBoy.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public CategoryPage clickCategoryMoreInfo() {
		category.click();
		return new CategoryPage(driver);
	}

}
