package android;


import static org.testng.Assert.assertTrue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import android.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomeScreen;
import pageObjects.LandingScreen;
import pageObjects.LoginPasswordScreen;
import pageObjects.LoginWelcomeScreen;

public class LoginTest extends Base {
	//This test is for successful Login functionality	
	
	@Test	@BeforeClass
	public void testLogin() throws IOException, InterruptedException 
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver= capabilities("AmazonShoppping");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\android\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//Reading values from Global.properties file
		String userIDtext= (String) prop.get("UserID");
		String passwordText = (String) prop.get("Password");
		String homePageText = (String) prop.get("HomePageText");
		
		LandingScreen landing = new LandingScreen(driver);
						
		landing.clickExistingCustomerSignInOption();
		
		LoginWelcomeScreen loginuser = new LoginWelcomeScreen(driver);
		loginuser.EnterUserID(userIDtext);
		loginuser.clickContinueButton();
		
		LoginPasswordScreen loginpassword = new LoginPasswordScreen(driver);
		
		loginpassword.EnterPassword(passwordText);
		loginpassword.clickLoginButton();
		
		HomeScreen home = new HomeScreen(driver);
		
		assertTrue(home.getHomePageText()
                .contains(homePageText),"User was not able to login successfully");	
	}

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
		
	}
	
}
