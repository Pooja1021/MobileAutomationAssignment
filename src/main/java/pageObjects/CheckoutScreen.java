package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckoutScreen {

	private AndroidDriver<AndroidElement> driver;
	private By productName = By.xpath("//android.view.View[@text='Habit Brewed Vinegar, 500ml (Pack of 2) ']");
	private By productPrice = By.xpath("//android.view.View[@text='   280.00']");
	private By buyButton = By.xpath("//android.widget.Button[@text='Proceed to Buy']");
	
	public CheckoutScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public String getProductNameCheckout(){
        String name = driver.findElement(productName).getText();
        return name;
    }
	
	public String getProductPriceCheckout(){
        String price = driver.findElement(productPrice).getText();
        return price;
    }

	public DeliveryAddressScreen clickProceedToBuy() {
		driver.findElement(buyButton).click();
		return new DeliveryAddressScreen(driver);
	}

}
