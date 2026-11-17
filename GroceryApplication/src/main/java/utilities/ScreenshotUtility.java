package utilities;

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class ScreenshotUtility 
	{
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException 
	{
	TakesScreenshot scrShot = (TakesScreenshot) driver;//casting after =, for capturing screenshot
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//temprory file creation for storing
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//date and time fetching when taking screenshot
	File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory, for taking project path-system.getproperty, outputscreeshot needs to create in system file
	if (!f1.exists())    // checking file creation
	{
	f1.mkdirs();//make directories
	}
	String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png";//file locasl path+ project path
	File finalDestination = new File(destination);//to store in permanent final dest
	FileHandler.copy(screenShot, finalDestination);// to copy image to final dest
	}
	}


