package pageObjects;

import java.io.IOException;
import android.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchResultScreen  {

	private AndroidDriver<AndroidElement> driver;

	public SearchResultScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	
	public ProductDetailsScreen selectProduct(String productName) throws IOException {
				
		Utilities u=new Utilities(driver);
		String productXpath= u.getTextfromProperty("ProductSearchXpath");
				
		//used scrolling gesture to scroll and select product	
	    u.scrollToText(productName); 
	    driver.findElementByXPath(productXpath).click();
	    
	    return new ProductDetailsScreen(driver);	
	}	

}
