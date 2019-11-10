package testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import extentlisteners.ExtentListeners;
import pages.FlightSearchPage;
import pages.FlightSearchResultsPage;
import pages.HomePage;
import utilities.DataUtil;

public class FlightSearchTest{
	
	
	FlightSearchPage fsp;
	HomePage hp;
	FlightSearchResultsPage frp;
	
	
	
	
	@BeforeMethod
	public void launchBrowser() {
		TestBase.init();
		
		
		
	}
	
	
	@Test(dataProvider="getData", dataProviderClass = DataUtil.class)
	public void flightSearch(String Origin, String destination, String departDate, String returnDate, String title) {
		hp = new HomePage();
		fsp =hp.navigateToFlight();
		frp = fsp.searchFlight(Origin, destination, departDate, returnDate);
		Assert.assertEquals(frp.getResultText(), title);
		ExtentListeners.test.info("Actual text is "+frp.getResultText());
		ExtentListeners.test.info("Expected text is "+title);
		ExtentListeners.test.pass("User is able to search flight");
		
	}
	
	@AfterMethod
	public void tearDown() {
		TestBase.closeBrowser();
	}
	

	
	
	
}
	
	
	



	
	
	
	
	
	
	


