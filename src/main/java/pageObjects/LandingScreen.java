package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LandingScreen {
	
	private AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Already a customer? Sign in']")
	private WebElement existingCustomerSignInButton;
	
	public LandingScreen(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
//Already a customer Sign-in Button selection method
	
	public LoginWelcomeScreen clickExistingCustomerSignInOption() {
	
			existingCustomerSignInButton.click();
		
			return new LoginWelcomeScreen(driver);
		
	}

}
