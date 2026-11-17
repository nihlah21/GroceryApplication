package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage hp ;
	@Test(priority = 1, description = "User is trying to login with valid credentials", groups = { "smoke" })
	public void verifyUserSignInWithValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");
		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();

		boolean dashboardValue = lp.verifyWhetherDashboardIsDisplayed();

		Assert.assertTrue(dashboardValue, Constant.VALIDCREDENTIALERROR);
		;
	}

	@Test(priority = 2, description = "User is trying to login with invalid credentials", retryAnalyzer = retry.Retry.class)
	public void verifyUserSignInWithInValidCredentials() throws IOException {
		String usernameValue = ExcelUtility.readStringData(1, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "GroceryLoginPage");
		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickSignInButton();

		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "User is trying to login with valid username and invalid paassword")
	public void verifyUserSignInWithValidUsernameAndInvalidPassword() throws IOException {
		String usernameValue = ExcelUtility.readStringData(2, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "GroceryLoginPage");
		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickSignInButton();

		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.VALIDUSERNAMEANDINVALIDPASSWORDERROR);
	}

	@Test(priority = 4, description = "User is trying to login with invalid username and valid password", groups = {"smoke"}, dataProvider = "Logindata")
	public void verifyUserSignInWithInvalidUsernameAndValidPassword(String usernameValue, String passwordValue) throws IOException {
		//String usernameValue = ExcelUtility.readStringData(3, 0, "GroceryLoginPage");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "GroceryLoginPage");
		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue).clickSignInButton();

		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEANDVALIDPASSWORDERROR);
	}

	@DataProvider(name = "Logindata")
	public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "admin", "admin123" }, new Object[] { "user", "user123" }, };

	}

}
