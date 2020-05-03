package pageObjects;

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
	    u.scrollToText("Habit Brewed Vinegar, 500ml (Pack of 2)"); 
	    driver.findElementByXPath("//android.widget.TextView[@text='Habit Brewed Vinegar, 500ml (Pack of 2)']").click();
	    return new ProductDetailsScreen(driver);
	
	}	
			
	//assertNotNull();

}
