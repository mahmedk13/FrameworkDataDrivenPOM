package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import extentlisteners.ExtentListeners;
import pages.HomePage;
import pages.HotealSearchResultsPage;
import pages.HotelSearchPage;
import utilities.DataUtil;

public class HotelSearchTest {
	
	HomePage hp;
	HotelSearchPage hsp;
	HotealSearchResultsPage hrp;
	
	@BeforeMethod
	public void launchBrowser() {
		TestBase.init();
		
	}
	
	
	@Test(dataProvider="getData", dataProviderClass = DataUtil.class)
	public void hotelSearch(String goingto, String checkindate, String checkoutdate, String title) {
		
		hp = new HomePage();
		hsp= hp.navigateToHotel();
		hrp = hsp.hotelSearch(goingto, checkindate, checkoutdate);
		String actualTitle = hrp.getTitle();		
		Assert.assertEquals(actualTitle, title);
		ExtentListeners.test.info("Actual title is "+actualTitle);
		ExtentListeners.test.info("Expected title is "+title);
		ExtentListeners.test.pass("User is able to search hotel");

	}
	
	@AfterMethod
	public void tearDown() {
		TestBase.closeBrowser();
	}
	

}
