package pageObjects;

import org.openqa.selenium.TimeoutException;

import android.Utilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SearchResultScreen {

	private AndroidDriver<AndroidElement> driver;
	
	public SearchResultScreen(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
	}
	

//used scrolling gesture to scroll and select product	
	public ProductDetailsScreen selectProduct() {
		Utilities u=new Utilities(driver);
	    u.scrollToText("NourishVitals Apple Cider Vinegar with Mother Vinegar - 250 ml"); 
	    try {
	    	driver.findElementByXPath("//android.widget.TextView[@text='NourishVitals Apple Cider Vinegar with Mother Vinegar - 250 ml']").click();
			} 
		 catch (TimeoutException toe) {
			System.out.println("WebDriver couldn’t locate the element");
			}
	    
	    return new ProductDetailsScreen(driver);	
	}	

}
