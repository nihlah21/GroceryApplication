package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	 String adminUsername;
	 HomePage hp;
	 AdminUserPage au;
	 
	@Test(description = "User is trying to add new admin user")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");

		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();
		
		au = hp.clickAdminUserMoreInfo();
		
		//Faker method
		RandomDataUtility rdu = new RandomDataUtility();
		adminUsername = rdu.generateRandomUserName();
		String adminPassword = rdu.generateRandomPassword();
		
		au.clickNewButton().enterAdminUsernameOnUsernameField(adminUsername).enterAdminPasswordOnPasswordField(adminPassword).selectUserType().clickSaveButton();
		
		String actual = au.verifyAddUserAlertIsDisplayed();
		String expected = "×\nAlert!\nUser Created Successfully";
		Assert.assertEquals(actual, expected, Constant.SEARCHNEWADMINUSERERROR);
		
	}
	@Test(description = "User is trying to search the newly added admin user")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedAdminUser() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");

		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();
		
		au = hp.clickAdminUserMoreInfo();
		
		au.clickBlueSearch().enterUsernameOnSearchUsernameField(adminUsername).searchUserTypeOnUsertypeField().clickRedSearch();
		
		String actual = au.verifySearchUserIsDisplayed();
		String expected = adminUsername;
		Assert.assertEquals(actual, expected, Constant.SEARCHNEWADMINUSERERROR);
	}

}
