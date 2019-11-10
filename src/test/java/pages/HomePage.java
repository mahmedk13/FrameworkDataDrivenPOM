package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(id="tab-flight-tab-hp")
	 WebElement FlightTab;
	
	@FindBy(id="tab-hotel-tab-hp")
	 WebElement hotelTab;
	
	public HomePage() {

		PageFactory.initElements(driver, this);

	}
	
	
	public FlightSearchPage navigateToFlight() {
		//FlightTab.click();
		click(FlightTab, "Flight Tab");
		return new FlightSearchPage();
	}
	
	public HotelSearchPage navigateToHotel() {
		//hotelTab.click();
		click(hotelTab, "Hotel Tab");

		return new HotelSearchPage();
	}
	
	

}
