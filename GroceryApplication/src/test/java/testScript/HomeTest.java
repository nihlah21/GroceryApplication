package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	HomePage hp ;
	@Test(description = "User is trying to logout")
	public void verifyUserIsAbleToSuccessfullyLoggedOut() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");
		
		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();
		
		
		hp.clickAdmin();
		lp = hp.clickLogout();
		
		String actual = lp.verifyWhetherLoginTextIsDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.LOGOUTERROR);
		
	}
}
