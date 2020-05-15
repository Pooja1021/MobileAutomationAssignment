package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomeScreen {
	private AndroidDriver<AndroidElement> driver;
	private By searchBox = By.xpath("//android.widget.EditText[@text='Search']");
	private By suggestedTextOption = By.xpath("//android.widget.TextView[@text='vinegar apple cider with mother']");
	private By verifyHome = By.id("com.amazon.mShop.android.shopping:id/web_home_shop_by_department_label");
	    
	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	public void EnterSearchText(String searchText) throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
			try {
				WebElement tapoption1= driver.findElement(searchBox); 
				TouchAction touch = new TouchAction(driver);
				touch.tap(tapOptions().withElement(element(tapoption1))).perform();
				driver.findElement(searchBox).sendKeys(searchText);
				} 
			catch (TimeoutException toe) {
				Assert.fail("Cannot locate the Search Textbox");
			}
	}
		
	public String getHomePageText() {
		String HomeText= driver.findElement(verifyHome).getText();
		return HomeText;
	}
//Used "Tap" mobile gesture to select from suggested text
	
	public SearchResultScreen tapToSelectOption() {
			try {
				WebElement tapoption2= driver.findElement(suggestedTextOption);
				TouchAction touch = new TouchAction(driver);
				touch.tap(tapOptions().withElement(element(tapoption2))).perform();
				} 
			 catch (TimeoutException toe) {
				 Assert.fail("Cannot find the suggested text option");
			 	}
		
		return new SearchResultScreen(driver);
	}
	
}
