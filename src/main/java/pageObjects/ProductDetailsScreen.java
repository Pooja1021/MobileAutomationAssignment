package pageObjects;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import android.Utilities;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductDetailsScreen {
	
	private AndroidDriver<AndroidElement> driver;
	private By productName = By.xpath("//android.view.View[@text='Habit Brewed Vinegar, 500ml (Pack of 2)']");
	private By productPrice = By.xpath("//android.widget.EditText[@text='rupees 280']");
	private By cartIcon = By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_image");

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
	    driver.findElementByXPath("//android.view.Button[@text='Add to Cart']").click();
    }

//used "Tap" mobile gesture to select icon
	
	public CheckoutScreen clickCartIcon() throws InterruptedException{
		WebDriverWait wait= new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(cartIcon));
		WebElement tapoption= driver.findElement(cartIcon);
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(tapoption))).perform();
        return new CheckoutScreen(driver);
    }
}
