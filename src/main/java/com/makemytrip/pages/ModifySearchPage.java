package com.makemytrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.TestBase;

public class ModifySearchPage extends TestBase{
	
	@FindBy(xpath="//a[normalize-space(text())='ONE WAY']")
	public WebElement oneWayTab;
	
	@FindBy(xpath="//a[normalize-space(text())='ROUND TRIP']")
	public WebElement roundTripTab;
	
	@FindBy(xpath="(//div[@class='airports hidden-xs hidden-stb']//input[@data-journey='DEP'])[1]")
	public WebElement fromCity;
	
	@FindBy(xpath="(//div[@class='airports hidden-xs hidden-stb']//input[@data-journey='RET'])[1]")
	public WebElement toCity;
	
	@FindBy(xpath="//div[@data-value='search.noOfAdlts']//a[@ng-click='next()']")
	public WebElement plusAdults;
	
	@FindBy(xpath="//div[@data-value='search.noOfChd']//a[@ng-click='next()']")
	public WebElement plusChild;
	
	@FindBy(xpath="//div[@data-value='search.noOfInfnt']//a[@ng-click='next()']")
	public WebElement plusInfant;
	
	@FindBy(xpath="//a[text()='Search']")
	public WebElement searchBtn;
	
	public ModifySearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyElements(){
		isElementVisible(oneWayTab);
		isElementVisible(roundTripTab);
		isElementVisible(fromCity);
		isElementVisible(toCity);
		isElementVisible(searchBtn);
	}
	
	public FlightSearchPage modifySearch(){
		click(plusAdults);
		click(plusChild);
		click(plusInfant);
		click(searchBtn);
		return new FlightSearchPage();
	}
	
}
