package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage1;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageDeliveryBoyTest extends Base{
	HomePage hp;
	ManageDeliveryBoyPage mdb;
	
	@Test(description = "User is trying to add new delivery boy")
	public void verifyWhetherUserIsAbleToAddNewDeliverBoy() throws IOException {
		String usernameValue = ExcelUtility.readStringData(0, 0, "GroceryLoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "GroceryLoginPage");

		LoginPage1 lp = new LoginPage1(driver);
		lp.enterUsernameOnUsernameField(usernameValue).enterPasswordOnPasswordField(passwordValue);
		hp = lp.clickSignInButton();
		
		
		mdb = hp.clickManageDeliveryBoyMoreInfo();
		
		RandomDataUtility rdu = new RandomDataUtility();
		String deliveryBoyName = rdu.generateRandomFullName();
		String deliveryBoyEmail = rdu.generateRandomEmailId();
		String deliveryBoyPhoneNumber = rdu.generateRandomPhoneNumber();
		String deliveryBoyAddress = rdu.generateRandomAddress();
		String deliveryBoyUsername = rdu.generateRandomUserName();
		String deliveryBoyPassword = rdu.generateRandomPassword();
		
	
		mdb.clickNewButton().enterNameOnNameField(deliveryBoyName).enterEmailOnEmailField(deliveryBoyEmail).enterPhoneNumberOnPhoneNumberField(deliveryBoyPhoneNumber).enterAddressOnAddressField(deliveryBoyAddress).enterUsernameOnUsernameField(deliveryBoyUsername).enterPasswordOnPasswordField(deliveryBoyPassword).clickSaveButton();
		
		String actual = mdb.verifyAddDeliveryBoyAlertIsDisplayed();
		String expected = "×\nAlert!\nDelivery Boy Details Created Successfully";
		Assert.assertEquals(actual, expected, Constant.ADDNEWDELIVERYBOYERROR);
		}

}
