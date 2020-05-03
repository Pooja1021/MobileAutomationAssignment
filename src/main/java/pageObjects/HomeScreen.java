package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen {
	private AndroidDriver<AndroidElement> driver;
	private By searchBox = By.name("Search");
	private By suggestedTextOption = By.xpath("//android.widget.TextView[@text='vinegar for cooking purpose']");
	private By verifyHome = By.id("com.amazon.mShop.android.shopping:id/web_home_shop_by_department_label");
	    
	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void EnterSearchText(String searchText) {
		driver.findElement(searchBox).sendKeys(searchText);
	}
		
	public String getHomePageText() {
		String HomeText= driver.findElement(verifyHome).getText();
		return HomeText;
	}
//Used "Tap" mobile gesture to select from suggested text
	
	public SearchResultScreen tapToSelectOption() {
		WebElement tapoption= driver.findElement(suggestedTextOption);
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(tapoption))).perform();
		return new SearchResultScreen(driver);
	}
	
	

	
}
