package extentlisteners;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.TestBase;
import utilities.Utilities;

public class ExtentListeners implements ITestListener {
	
	
	
	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"//reports//"+fileName);
	//public static ExtentTest testreport = new ExtentTest();
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	
		


		String methodName = result.getMethod().getMethodName();
		String logtext = "<b>"+"Test Case: "+methodName.toUpperCase()+" PASSED"+"</b";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		test.pass(m);
			
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		try {
			Utilities.captureScreenshot();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			test.fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(Utilities.screenshotName)
							.build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String failureLogg="<b>"+"TEST CASE "+result.getMethod().getMethodName().toUpperCase()+" FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		test.fail(m);
		
		

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {

			extent.flush();
		}

		
	}

}
