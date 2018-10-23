package com.makemytrip.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.base.TestBase;
import com.makemytrip.pages.FlightSearchPage;
import com.makemytrip.pages.HomePage;
public class FlightsSearchPageTest extends TestBase{
	
	HomePage homePage;
	FlightSearchPage flightSearchPage;
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		homePage=new HomePage();
		flightSearchPage=new FlightSearchPage();
		
	}
	
	@Test(priority=1)
	public void verifyPageElements(){
		homePage.searchFlights();
		flightSearchPage.verifyElements();
	}
	
	@Test(priority=2)
	public void verifyBookFlight(){
		homePage.searchFlights();
		flightSearchPage.clickOnBook();
		System.out.println("Flights Review Page launched");
	}
	
	@Test(priority=3)
	public void changeFlights(){
		homePage.searchFlights();
		click(flightSearchPage.departSecFlightRadio);
		click(flightSearchPage.returnSecFlightRadio);
		flightSearchPage.clickOnBook();
		System.out.println("Flights Review Page launched");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
