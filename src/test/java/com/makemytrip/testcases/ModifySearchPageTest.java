package com.makemytrip.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Verify;
import com.makemytrip.base.TestBase;
import com.makemytrip.pages.FlightSearchPage;
import com.makemytrip.pages.HomePage;
import com.makemytrip.pages.ModifySearchPage;

public class ModifySearchPageTest extends TestBase {

	HomePage homePage;
	FlightSearchPage flightSearchPage;
	ModifySearchPage modifySearchPage;

	@BeforeMethod
	public void setUp() {
		initialisation();
		homePage = new HomePage();
		flightSearchPage = new FlightSearchPage();
		modifySearchPage = new ModifySearchPage();
	}

	@Test(priority = 1)
	public void verifyPageElements() {
		homePage.searchFlights();
		flightSearchPage.clickOnModify();
		isElementVisible(modifySearchPage.searchBtn);
		modifySearchPage.verifyElements();

	}

	@Test(priority = 2)
	public void modifyPassengers() {
		homePage.searchFlights();
		flightSearchPage.clickOnModify();
		isElementVisible(modifySearchPage.searchBtn);
		modifySearchPage.modifySearch();
	}

	@Test(priority = 3)
	public void changeAirlines() {
		homePage.searchFlights();
		scrollTo(flightSearchPage.airlinesCheckBox1);
		click(flightSearchPage.airlinesCheckBox1);
		System.out.println("Airline name is: " + flightSearchPage.airlinesCheckBox1Title.getText());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
