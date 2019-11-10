package extentlisteners;

import java.io.File;

import org.openqa.selenium.OutputType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	public static ExtentReports createInstance(String filename) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(filename);
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setReportName(filename);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Team", "XYZ");
		extent.setSystemInfo("Organization", "abc");
		
		return extent;
		
	}
	
	
	
	 
}
