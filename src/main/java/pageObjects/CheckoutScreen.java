package pageObjects;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckoutScreen {

	private AndroidDriver<AndroidElement> driver;
	private By productName = By.xpath("//android.view.View[@text='NourishVitals Apple Cider Vinegar with Mother Vinegar - 250 ml']");
	private By productPrice = By.xpath("//android.view.View[@text='   179.00']");
	
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

}
