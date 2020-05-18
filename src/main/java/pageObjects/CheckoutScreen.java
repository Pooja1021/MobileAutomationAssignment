package pageObjects;

import java.io.IOException;
import android.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CheckoutScreen {

	private AndroidDriver<AndroidElement> driver;
	Utilities u=new Utilities(driver);
	
	public CheckoutScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public String getProductNameCheckout() throws IOException{
		String productXpath= u.getTextfromProperty("ProductDetailsXpath");
		String name = driver.findElementByXPath(productXpath).getText();
		return name;
	} 
	
	public String getProductPriceCheckout() throws IOException{
		String productPrice= u.getTextfromProperty("CheckoutPrice");
		String price = driver.findElementByXPath(productPrice).getText();
        return price;
    }

}
