package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


	public class LoginPasswordScreen {
		private AndroidDriver<AndroidElement> driver;
		private By password = By.xpath("//android.widget.EditText[@text='Amazon password']");
		private By loginButton = By.xpath("//android.widget.Button[@text='Login']");
		
		public LoginPasswordScreen(AndroidDriver<AndroidElement> driver) {
			this.driver = driver;
		}
		
		public void EnterPassword(String passwordText) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.presenceOfElementLocated(password));
				driver.findElement(password).sendKeys(passwordText);
				} 
			catch (TimeoutException toe) {
				Assert.fail("Cannot locate the Password Textbox");
				}
			}
		
		public HomeScreen clickLoginButton() {
			try {
				driver.findElement(loginButton).click();
				} 
			 catch (TimeoutException toe) {
				 Assert.fail("Cannot locate the Login button");
				}			
			return new HomeScreen(driver);
	}

}
