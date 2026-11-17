package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage1;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class CategoryTest extends Base{
	String categoryValue;
	HomePage hp;
	CategoryPage ct;
	
	@Test(description = "User is trying to add new category details")
	public void verifyWhetherUserIsAbleToAddNewCategory() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");

		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();
		

		ct = hp.clickCategoryMoreInfo();
		
		//String categoryValue = ExcelUtility.readStringData(0, 0, "Category");
		RandomDataUtility rdu = new RandomDataUtility();
		categoryValue = rdu.generateRandomCategory();
		
		ct.clickNewButton().enterCategoryOnCategoryField(categoryValue).selectGroupsFromGroupsField().chooseFileForImage().clickSaveButton();
		
		String actual = ct.verifyAddCategoryAlertIsDisplayed();
		Assert.assertTrue(actual.contains("Category Created Successfully"),Constant.ADDNEWCATEGORYERROR);
		
	}
	@Test(description = "User is trying to search the newly added category")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedCategory() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");

		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();
		
	
		ct = hp.clickCategoryMoreInfo();
		
	
		ct.clickBlueSearchButton().enterCategoryOncategoryField(categoryValue).clickRedSearchButton();
		
		String actual = ct.verifySearchUserisDisplayed();
		String expected = categoryValue;
		Assert.assertEquals(actual, expected, Constant.SEARCHNEWCATEGORYERROR);
	}

}
