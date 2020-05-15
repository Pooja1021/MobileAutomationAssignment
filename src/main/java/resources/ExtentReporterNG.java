package resources;

import java.io.File;
import org.testng.Reporter;
import org.testng.IReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG implements IReporter {
	private static ExtentReports extent;
	private static String reportFileName = "Automation_Report" +".html";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilePath =  System.getProperty("user.dir")+fileSeperator+"TestReport";
	private static String reportFileLocation = reportFilePath + fileSeperator + reportFileName;
	
	
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {
		String fileName = getReportPath(reportFilePath);

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(reportFileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	// Create the report path
	private static String getReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				Reporter.log("Directory: " + path + " is created!");
				return reportFileLocation;
			} else {
				Reporter.log("Failed to create directory: " + path);
				return System.getProperty("user.dir");
			}
		} else {
			Reporter.log("Directory already exists: " + path);
		}
		return reportFileLocation;
	}
	
}
