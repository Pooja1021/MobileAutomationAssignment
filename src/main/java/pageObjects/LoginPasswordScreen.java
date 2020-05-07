package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
				try {
				driver.findElement(password).sendKeys(passwordText);
				} catch (WebDriverException e) {
				System.out.println("An Exception Case!");
				}
				} catch (TimeoutException toe) {
				System.out.println("WebDriver couldn’t locate the element");
				}
			}
		
		public HomeScreen clickLoginButton() {
			try {
				driver.findElement(loginButton).click();
				} 
			 catch (TimeoutException toe) {
				System.out.println("WebDriver couldn’t locate the element");
				}			
			return new HomeScreen(driver);
	}

}
