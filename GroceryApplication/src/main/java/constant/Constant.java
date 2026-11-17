package constant;

public class Constant {
	public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
	public static final String TESTDATA = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String VALIDCREDENTIALERROR = "User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR= "User is able to Login with Invalid Credentials";
	public static final String VALIDUSERNAMEANDINVALIDPASSWORDERROR= "User is able to Login with Valid username and Invalid password";
	public static final String INVALIDUSERNAMEANDVALIDPASSWORDERROR= "User is able to Login with Invalid username and valid password";
	public static final String LOGOUTERROR = "User is unable to Logout";
	public static final String ADDNEWADMINUSERERROR = "User could not created";
	public static final String SEARCHNEWADMINUSERERROR = "Searched user not found";
	public static final String ADDNEWDELIVERYBOYERROR = "Delivery Boy details could not created";
	public static final String ADDNEWCATEGORYERROR = "Category details could not be created";
	public static final String SEARCHNEWCATEGORYERROR = "Searched Category not found";

}

