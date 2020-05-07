package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import android.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductDetailsScreen {
	
	private AndroidDriver<AndroidElement> driver;
	private By productName = By.xpath("//android.view.View[@text='NourishVitals Apple Cider Vinegar with Mother Vinegar - 250 ml']");
	private By productPrice = By.xpath("//android.widget.EditText[@text='rupees 179']");
	
	public ProductDetailsScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}

	public String getProductName(){
        String name = driver.findElement(productName).getText();
        return name;
    }
	
	public String getProductPrice(){
        String price = driver.findElement(productPrice).getText();
        return price;
    }
	
	public void clickAddToCartButton(){
		Utilities u=new Utilities(driver);
	    u.scrollToText("Add to Cart");
	    try {			
	    	driver.findElementByClassName("android.widget.Button").click();
			} 
		 catch (TimeoutException toe) {
			System.out.println("WebDriver couldn�t locate the element");
			}    
    }
	
	public CheckoutScreen clickCartIcon() throws InterruptedException{
			Thread.sleep(3000);
			try {
			driver.findElementByAccessibilityId("Cart").click();
			} catch (TimeoutException toe) {
			System.out.println("WebDriver couldn�t locate the element");
			}
        return new CheckoutScreen(driver);
    }
}
