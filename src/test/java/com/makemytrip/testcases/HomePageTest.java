package com.makemytrip.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makemytrip.base.TestBase;
import com.makemytrip.pages.FlightSearchPage;
import com.makemytrip.pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;
	FlightSearchPage flightSearchPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		homePage = new HomePage();
		flightSearchPage = new FlightSearchPage();
	}

	@Test(priority = 1)
	public void verifyHomePageElements() {
		if (homePage.flightsLinkHighlighted.isDisplayed() == true) {
			homePage.verifyElements();
		}

	}

	@Test(priority = 2)
	public void searchFlights() {
		if (homePage.flightsLinkHighlighted.isDisplayed() == true) {
			flightSearchPage = homePage.searchFlights();
			isElementVisible(flightSearchPage.departureDate);
		}
	}

	@Test(priority = 3)
	public void verifyHomePageTitle() {
		String actual = driver.getTitle();
		String expected = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday...";
		Assert.assertEquals(actual, expected, "Title not matching:");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
