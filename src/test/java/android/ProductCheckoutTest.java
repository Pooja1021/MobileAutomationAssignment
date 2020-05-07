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
		
		home = new HomeScreen(driver);
		home.EnterSearchText(searchText);
		home.tapToSelectOption();
		
		SearchResultScreen searchScreen = new SearchResultScreen(driver);
		searchScreen.selectProduct();
		
		ProductDetailsScreen product = new ProductDetailsScreen(driver);
		String Name = product.getProductName().trim();
		String Price = product.getProductPrice().substring(6).trim();
		System.out.println(Name+" Product Name on Products Screen");
		System.out.println(Price+" Product Price on Products Screen");
		
		product.clickAddToCartButton();
		product.clickCartIcon();
		
		CheckoutScreen checkout = new CheckoutScreen(driver);
		String CheckoutProductName = checkout.getProductNameCheckout().trim();
		String CheckoutProductPrice = checkout.getProductPriceCheckout().trim();
		
		System.out.println(CheckoutProductName+" Product Name on Checkout Screen");
		System.out.println(CheckoutProductPrice+" Product Price on Checkout Screen");
		
		softAssert.assertTrue(CheckoutProductName.contains(Name), "Product name does not match");
		softAssert.assertTrue(CheckoutProductPrice.contains(Price), "Product price does not match");
		
		softAssert.assertAll();
		
		service.stop();
	}
	
}
