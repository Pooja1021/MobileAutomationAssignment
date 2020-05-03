package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DeliveryAddressScreen {

	private AndroidDriver<AndroidElement> driver;
	private By addressButton = By.xpath("//(android.widget.Button)[1]");
	
	public DeliveryAddressScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public DeliveryOptionsScreen clickDeliverToThisAddress() {
		driver.findElement(addressButton).click();
		return new DeliveryOptionsScreen(driver);
	}


}
