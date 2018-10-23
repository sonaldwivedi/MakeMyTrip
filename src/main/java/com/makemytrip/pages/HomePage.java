package com.makemytrip.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//img[@class='mmt_header_logo' and contains(@src,'png')]")
	public WebElement mmtIcon;
	
	@FindBy(xpath="//a[text()='flights' and @href='https://www.makemytrip.com/flights/']")
	public WebElement flightsLink;
	
	@FindBy(xpath="//a[@class='hdr_item_link active' and text()='flights']")
	public WebElement flightsLinkHighlighted;
	
	@FindBy(xpath="//a[text()='hotels' and @href='https://www.makemytrip.com/hotels/']")
	public WebElement hotelsLink;
	
	@FindBy(xpath="//input[@id='hp-widget__sfrom']")
	public WebElement from;
	
	@FindBy(id="hp-widget__return")
	public WebElement to;
	
	@FindBy(xpath="//button[@id='searchBtn']")
	public WebElement searchBtn;
	
	
	//From options
	
	@FindBy(xpath="//ul[contains(@class,'__sfrom')]//span[text()='BLR']")
	public WebElement fromBLR;
	
	@FindBy(xpath="//ul[contains(@class,'__sfrom')]//span[text()='GOI']")
	public WebElement fromGOA;
	
	@FindBy(xpath="//ul[contains(@class,'__sfrom')]//span[text()='BOM']")
	public WebElement fromMumbai;
	
	//To options
	
	@FindBy(xpath="//ul[contains(@class, 'hp-widget__sTo')]//span[text()='BOM']")
	public WebElement toMumbai;
	
	@FindBy(xpath="//ul[contains(@class, 'hp-widget__sTo')]//span[text()='BLR']")
	public WebElement toBLR;
	
	@FindBy(xpath="//ul[contains(@class, 'hp-widget__sTo')]//span[text()='DEL']")
	public WebElement toDEL;
	
	@FindBy(id="hp-widget__depart")
	public WebElement departDate;
	
	@FindBy(id="hp-widget__return")
	public WebElement returnDate;
	
	@FindBy(xpath="//div[contains(@class,'group-first')]//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']")
	public List<WebElement> departDates;
	
	@FindBy(xpath="//div[contains(@class, 'corner-right')]//following-sibling::table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']")
	public List<WebElement> returnDates;
	
	@FindBy(xpath="(//table//a[text()='22'])[2]")
	public WebElement return22;
	
	public HomePage(){
		System.out.println("driver value in home page is: " +driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElements(){
		isElementVisible(mmtIcon);
		System.out.println("mmtIcon visible");
		
		isElementVisible(flightsLink);
		System.out.println("flightsLink visible");
		
		isElementVisible(hotelsLink);
		System.out.println("hotelsLink visible");
		
		isElementVisible(from);
		System.out.println("from visible");
		
		isElementVisible(to);
		System.out.println("to visible");
		
		isElementVisible(searchBtn);
		System.out.println("Search visible");
	}
	
	
	public FlightSearchPage searchFlights(){
		click(from);
		click(fromBLR);
		click(toMumbai);
		click(departDate);

		String today;
		today = getCurrentDate();

		for (WebElement ele : departDates) {
			String date = ele.getText();
			if (date.equals(today)) {
				click(ele);
				break;
			}
		}
		click(returnDate);
		click(return22);
		
		click(searchBtn);
		return new FlightSearchPage();
	}
}
