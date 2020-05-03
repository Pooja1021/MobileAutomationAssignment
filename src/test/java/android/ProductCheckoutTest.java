package android;

import static org.testng.Assert.assertEquals;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.CheckoutScreen;
import pageObjects.HomeScreen;
import pageObjects.ProductDetailsScreen;
import pageObjects.SearchResultScreen;

public class ProductCheckoutTest extends Base {
	
//This test is for comparing product information on Product Details page with Checkout page
	@Test
	public void testCheckoutPage() throws IOException, InterruptedException {
		service = startServer();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\android\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String searchText= (String) prop.get("SearchText");
		
		HomeScreen home = new HomeScreen(driver);
		home.EnterSearchText(searchText);
		home.tapToSelectOption();
		
		SearchResultScreen searchScreen = new SearchResultScreen(driver);
		searchScreen.selectProduct();
		
		ProductDetailsScreen product = new ProductDetailsScreen(driver);
		product.getProductName();
		product.getProductPrice();
		product.clickAddToCartButton();
		product.clickCartIcon();
		
		CheckoutScreen checkout = new CheckoutScreen(driver);
		checkout.getProductNameCheckout();
		checkout.getProductPriceCheckout();
		assertEquals(checkout.getProductNameCheckout().contains(product.getProductName()), product.getProductName());
		assertEquals(checkout.getProductPriceCheckout().contains(product.getProductPrice()), product.getProductPrice());
		Thread.sleep(2000);
		checkout.clickProceedToBuy();	
	}
	
}
