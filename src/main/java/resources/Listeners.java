package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Listeners implements ITestListener{
	
	AndroidDriver<AndroidElement>  driver = null;

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
		//ITestListener.super.onTestStart(result);	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		//ITestListener.super.onTestSuccess(result);	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String targetLocation = null;
		String testClassName = result.getInstanceName().trim();
		String testMethodName = result.getName().toString().trim();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String strDate = format.format(date);
		String screenshotName = testMethodName + "_"+ strDate;
		String fileSeperator = System.getProperty("file.separator");
		String reportsPath = System.getProperty("user.dir") + fileSeperator + "TestReport" + fileSeperator + "screenshots";
		try {
			File file = new File(reportsPath + fileSeperator + testClassName);
					if(!file.exists()) {
						Files.createDirectory(file.toPath());
						if(file.exists()){							
							ExtentTestManager.getTest().log(Status.INFO,"Directory: " + file.getAbsolutePath() + " is created!");
						}else {
							ExtentTestManager.getTest().log(Status.INFO,"Failed to create directory: " + file.getAbsolutePath());
						}
				}
			File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
			targetLocation = reportsPath + fileSeperator + testClassName + fileSeperator + screenshotName;
			FileUtils.copyFile(scrfile,new File(targetLocation+".png"));
			
		}
		catch(FileNotFoundException e) {
			ExtentTestManager.getTest().log(Status.INFO,"File Not Found Exception occurred while taking screenshot to target location :: " + e.getMessage());
				}
		catch(Exception e) {
			ExtentTestManager.getTest().log(Status.INFO,"Exception Occurred in onTestFailure() of Listener " + e.getCause());
				}
		// attach screenshots to report
		try {
			ExtentTestManager.getTest().fail("Screenshot",
			MediaEntityBuilder.createScreenCaptureFromPath(targetLocation).build());
				} 
		catch (IOException e) {
			ExtentTestManager.getTest().log(Status.INFO,"An exception occured while taking screenshot " + e.getCause());
				}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		//ITestListener.super.onTestFailure(result);
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
		//ITestListener.super.onTestSkipped(result);		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentTestManager.getTest().log(Status.INFO, "TestFailedButWithinSuccessPercentage :: " + ITestResult.SUCCESS_PERCENTAGE_FAILURE);		
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentTestManager.getTest().log(Status.INFO, "This is onFinish method Passed Tests ::" + context.getPassedTests());
		ExtentTestManager.getTest().log(Status.INFO, "This is onFinish method Failed Tests ::" + context.getFailedTests());
		ExtentTestManager.endTest();
		
		ExtentReporterNG.getInstance().flush();
		//ITestListener.super.onFinish(context);		
	}
	
	

}
