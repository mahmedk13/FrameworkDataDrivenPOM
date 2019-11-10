package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FlightSearchPage extends TestBase {

	
	@FindBy(xpath="//input[@id='flight-origin-hp-flight']")
	private WebElement originEle;
	
	@FindBy(xpath="//input[@id='flight-departing-hp-flight']")
	private WebElement departDateEle;
	
	@FindBy(xpath="//input[@id='flight-returning-hp-flight']")
	private WebElement returnDateEle;
	
	@FindBy(xpath="//input[@id='flight-destination-hp-flight']")
	private WebElement destinationEle;
	
	@FindBy(xpath="(//button[@class='btn-primary btn-action gcw-submit'])[1]")
	private WebElement submitBtn;
	
	
	public FlightSearchPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public FlightSearchResultsPage searchFlight(String Origin, String destination, String departDate, String returnDate) {
		//originEle.sendKeys(Origin);
		type(originEle, Origin, "Going to");
		//departDateEle.sendKeys(departDate);
		type(departDateEle, departDate, "Departure Date");

		//returnDateEle.sendKeys(returnDate);
		type(returnDateEle, returnDate, "Return Date");

		//destinationEle.sendKeys(destination);
		type(destinationEle, destination, "Destination field");
		
		
		//submitBtn.click();
		click(submitBtn, "Search Button");
		
		return new FlightSearchResultsPage();
		
	}
	
	
	
}
