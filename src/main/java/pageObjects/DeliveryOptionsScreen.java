package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DeliveryOptionsScreen {

	private AndroidDriver<AndroidElement> driver;
	private By continueButton = By.name("Continue");
	
	public DeliveryOptionsScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public PaymentMethodScreen clickContinueButton() {
		driver.findElement(continueButton).click();
		return new PaymentMethodScreen(driver);
	}

}
