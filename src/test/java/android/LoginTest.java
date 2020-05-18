package android;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import android.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomeScreen;
import pageObjects.LandingScreen;
import pageObjects.LoginPasswordScreen;
import pageObjects.LoginWelcomeScreen;

public class LoginTest extends Base {
	//This test is for successful Login functionality	
	
	protected HomeScreen home;
	
	@BeforeMethod
	public void testLogin() throws IOException, InterruptedException
	{
		service=startServer();
		AndroidDriver<AndroidElement> driver= capabilities("AmazonShoppping");
		
		SoftAssert softAssert = new SoftAssert();
		Utilities u =new Utilities(driver);
		String userIDtext = u.getTextfromProperty("UserID");
		String passwordText = u.getTextfromProperty("Password");
		String homePageText = u.getTextfromProperty("HomePageText");
				
		LandingScreen landing = new LandingScreen(driver);
		landing.clickExistingCustomerSignInOption();
		
		LoginWelcomeScreen loginuser = new LoginWelcomeScreen(driver);
		loginuser.EnterUserID(userIDtext);
		loginuser.clickContinueButton();
		
		LoginPasswordScreen loginpassword = new LoginPasswordScreen(driver);
		
		loginpassword.EnterPassword(passwordText);
		loginpassword.clickLoginButton();
		
		home = new HomeScreen(driver);
		
		softAssert.assertTrue(home.getHomePageText().contains(homePageText),"User was not able to login successfully");	
	}

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{	
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}
	
}
