package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


	public class LoginWelcomeScreen {
		
		public AndroidDriver<AndroidElement> driver;
				
		private By userID = By.className("android.widget.EditText");
		private By continueButton = By.xpath("//android.widget.Button[@text='Continue']");
		
		public LoginWelcomeScreen(AndroidDriver<AndroidElement> driver) {
			this.driver = driver;
		}
					
	//Methods to input email/phone and navigate to password screen
		
		public void EnterUserID(String userIDtext) throws InterruptedException {
					
			try {
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, 5);
				wait.until(ExpectedConditions.presenceOfElementLocated(userID));
				try {
				driver.findElement(userID).sendKeys(userIDtext);
				} catch (WebDriverException e) {
				System.out.println("An Exception Case!");
				}
				} catch (TimeoutException toe) {
				System.out.println("WebDriver couldn’t locate the element");
				}
			}

		
		public LoginPasswordScreen clickContinueButton() {
			
			try {				
				driver.findElement(continueButton).click();
				} 
			 catch (TimeoutException toe) {
				System.out.println("WebDriver couldn’t locate the element");
				}
			
			return new LoginPasswordScreen(driver);
		}	


}
