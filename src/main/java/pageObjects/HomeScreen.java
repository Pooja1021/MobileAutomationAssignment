package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 7);
			wait.until(ExpectedConditions.presenceOfElementLocated(searchBox));
			try {
				WebElement tapoption1= driver.findElement(searchBox); TouchAction touch = new TouchAction(driver);
				touch.tap(tapOptions().withElement(element(tapoption1))).perform();
				driver.findElement(searchBox).sendKeys(searchText);
				} 
			catch (WebDriverException e) {
			System.out.println("An Exception Case!");
			}
			} catch (TimeoutException toe) {
			System.out.println("WebDriver couldn’t locate the element");
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
			System.out.println("WebDriver couldn’t locate the element");
			 	}
		
		return new SearchResultScreen(driver);
	}
	
}
