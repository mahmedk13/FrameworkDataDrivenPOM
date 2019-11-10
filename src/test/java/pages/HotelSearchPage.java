package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HotelSearchPage extends TestBase {
	
	@FindBy(xpath="//input[@id='hotel-destination-hp-hotel']")
	private WebElement going;
	
	@FindBy(xpath="//input[@id='hotel-checkin-hp-hotel']")
	private WebElement checkin;
	
	@FindBy(xpath="//input[@id='hotel-checkout-hp-hotel']")
	private WebElement checkout;
	
	@FindBy(xpath="(//button[@class='btn-primary btn-action  gcw-submit'])[1]")
	private WebElement searchBtn;
	
	
	public HotelSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HotealSearchResultsPage hotelSearch(String goingto, String checkindate, String checkoutdate) {
		//going.sendKeys(goingto);
		
		type(going, goingto, "Going To");
		//checkin.sendKeys(checkindate);
		type(checkin, checkindate, "Checkin Date");

		//checkout.sendKeys(checkoutdate);
		type(checkout, checkoutdate, "Checkout Date");

		//searchBtn.click();
		click(searchBtn, "Search Button");
		
		return new HotealSearchResultsPage();
	}
	

}
