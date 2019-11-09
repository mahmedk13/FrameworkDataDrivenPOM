package testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import base.TestBase;
import pages.FlightSearchPage;
import pages.HomePage;
import utilities.DataUtil;

public class FlightSearchTest{
	
	
	FlightSearchPage fsp;
	HomePage hp;
	
	
	
	
	@BeforeMethod
	public void launchBrowser() {
		TestBase.init();
		hp = new HomePage();
		fsp =hp.navigateToFlight();
		
		
	}
	
	
	@Test(dataProvider="getData", dataProviderClass = DataUtil.class)
	public void flightSearch(String Origin, String destination, String departDate, String returnDate, String title) {
		
		fsp.searchFlight(Origin, destination, departDate, returnDate);
		System.out.println(title);
		
	}
	
	@AfterMethod
	public void tearDown() {
		TestBase.closeBrowser();
	}
	

	
	
	
}
	
	
	



	
	
	
	
	
	
	


