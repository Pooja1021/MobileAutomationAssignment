package android;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	
	public static AppiumDriverLocalService startServer()
	{
	boolean flag = checkIfServerIsRunnning(4723);
	if(!flag)
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;	
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException 
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\android\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
				
		File appDirectory = new File("src");
		File app = new File(appDirectory, (String) prop.get(appName));
		String device=(String) prop.get("device");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
	    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;	
	}
	
}
