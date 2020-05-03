package pageObjects;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class PaymentMethodScreen {

	private AndroidDriver<AndroidElement> driver;
	private By name  = By.id("pp-fTWWK7-142");
	private By cardNumber = By.id("pp-fTWWK7-144");
	private By expiryMonth = By.id("pp-fTWWK7-148");
	private By expiryYear = By.id("pp-fTWWK7-149");
	private By addCardButton = By.name("Add your card");
	
	public PaymentMethodScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}

	//Used Scroll and Tap gestures
	public void selectCardOption(){
		WebElement tapoption = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())"
		        + "scrollIntoView(text(\"Add Debit/Credit/ATM Card\"));");
			TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(tapoption))).perform();
	}
	
	public void inputCardDetails(String nameText, String cardnumberText) {
		driver.findElement(name).clear();
		driver.findElement(name).sendKeys(nameText);
		driver.findElement(cardNumber).sendKeys(cardnumberText);
		
		
	}
	
	//public PlaceOrderAndPayScreen clickAddCardButton() {
		//return new PlaceOrderAndPayScreen(driver);
	}
	

	
