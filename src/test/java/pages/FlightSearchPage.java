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
	
	public void searchFlight(String Origin, String destination, String departDate, String returnDate) {
		originEle.sendKeys(Origin);
		departDateEle.sendKeys(departDate);
		returnDateEle.sendKeys(returnDate);
		destinationEle.sendKeys(destination);
		submitBtn.click();
		
	}
	
	
	
}
