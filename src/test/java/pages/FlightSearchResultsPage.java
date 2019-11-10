package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class FlightSearchResultsPage extends TestBase {
	
	@FindBy(className="title-city-text")
	private WebElement resultsHeading;
	
	
	public FlightSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getResultText() {
		return resultsHeading.getText();
	}
	

}
