package pageObjects;
import org.openqa.selenium.By;
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
			
			WebDriverWait wait= new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(userID));
			driver.findElement(userID).sendKeys(userIDtext);
		}
		
		public LoginPasswordScreen clickContinueButton() {
			driver.findElement(continueButton).click();
			return new LoginPasswordScreen(driver);
			
	}

}
