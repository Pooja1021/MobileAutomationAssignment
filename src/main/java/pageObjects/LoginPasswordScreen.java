package pageObjects;

import org.openqa.selenium.By;
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
			driver.findElement(password).sendKeys(passwordText);
		}
		
		public HomeScreen clickLoginButton() {
			driver.findElement(loginButton).click();
			return new HomeScreen(driver);
	}

}
