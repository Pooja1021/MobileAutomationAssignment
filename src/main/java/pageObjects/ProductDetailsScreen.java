package pageObjects;

import java.io.IOException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import android.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductDetailsScreen {
	
	private AndroidDriver<AndroidElement> driver;
	Utilities u=new Utilities(driver);
		
	public ProductDetailsScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}

	public String getProductName() throws IOException{
	
		String productdetailsXpath= u.getTextfromProperty("ProductDetailsXpath");
		String name = driver.findElementByXPath(productdetailsXpath).getText();
        return name;
    }
	
	public String getProductPrice() throws IOException{
		String priceXpath= u.getTextfromProperty("ProductPrice");
        String price = driver.findElementByXPath(priceXpath).getText();
        return price;
    }
	
	public void clickAddToCartButton(){
		Utilities newU =new Utilities(driver);
		newU.scrollToText("Add to Cart");
	    try {			
	    	driver.findElementByClassName("android.widget.Button").click();
			} 
		 catch (TimeoutException toe) {
			 Assert.fail("Cannot locate Add to Cart button");
			}    
    }
	
	public CheckoutScreen clickCartIcon() throws InterruptedException{
			try {
			driver.findElementByAccessibilityId("Cart").click();
			} catch (TimeoutException toe) {
				Assert.fail("Cannot locate the Cart Icon");
			}
        return new CheckoutScreen(driver);
    }
}
