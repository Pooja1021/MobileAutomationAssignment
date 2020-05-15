package android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.CheckoutScreen;
import pageObjects.HomeScreen;
import pageObjects.ProductDetailsScreen;
import pageObjects.SearchResultScreen;

public class ProductCheckoutTest extends LoginTest {
	
//This test is for comparing product information on Product Details page with Checkout page
	@Test
	public void testCheckoutPage() throws IOException, InterruptedException {
		
		SoftAssert softAssert = new SoftAssert();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\android\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String searchText= (String) prop.get("SearchText");
		String productText= (String) prop.get("ProductName");
		
		home = new HomeScreen(driver);
		home.EnterSearchText(searchText);
		home.tapToSelectOption();
		
		SearchResultScreen searchScreen = new SearchResultScreen(driver);
		searchScreen.selectProduct(productText);
		
		ProductDetailsScreen product = new ProductDetailsScreen(driver);
		String Name = product.getProductName().trim();
		String Price = product.getProductPrice().substring(6).trim();
		
		product.clickAddToCartButton();
		product.clickCartIcon();
		
		CheckoutScreen checkout = new CheckoutScreen(driver);
		String CheckoutProductName = checkout.getProductNameCheckout().trim();
		String CheckoutProductPrice = checkout.getProductPriceCheckout().trim();
		
		softAssert.assertTrue(CheckoutProductName.contains(Name), "Product name does not match");
		softAssert.assertTrue(CheckoutProductPrice.contains(Price), "Product price does not match");
		
		softAssert.assertAll();
						
		service.stop();
	}
	
}
