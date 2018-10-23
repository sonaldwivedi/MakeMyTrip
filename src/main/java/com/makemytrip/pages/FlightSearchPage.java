package com.makemytrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.base.TestBase;

public class FlightSearchPage extends TestBase{
	
	@FindBy(xpath="//p[@class='modify_city_name modify_txt ng-binding']")
	public WebElement cityToCity;
	
	@FindBy(xpath="//a[contains(@class,'modify_search_toggle')]")
	public WebElement modifySearch;
	
	@FindBy(xpath="//p[text()='DEPARTURE']//following-sibling::p[@class='check-dates modify_txt']")
	public WebElement departureDate;
	
	@FindBy(xpath="//p[text()='Return']//following-sibling::p[@class='check-dates modify_txt']")
	public WebElement returnDate;
	
	@FindBy(xpath="(//div[contains(@class,'left_pannel')]//span[@class='radio_icon'])[2]")
	public WebElement departSecFlightRadio;
	
	@FindBy(xpath="(//div[contains(@class,'right_pannel')]//span[@class='radio_icon'])[2]")
	public WebElement returnSecFlightRadio;
	
	@FindBy(xpath="(//strong[text()='Airlines']//parent::p[@class='append_bottom10 clearfix']//following-sibling::div//span[@class='checkbox_state pull-right'])[1]")
	public WebElement airlinesCheckBox1;
	
	@FindBy(xpath="//a[text()='Book']")
	public WebElement bookBtn;
	
	public FlightSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public FlightsReviewPage clickOnBook(){
		click(bookBtn);
		return new FlightsReviewPage();
	}
	
	public ModifySearchPage clickOnModify(){
		click(modifySearch);
		return new ModifySearchPage();
	}
	
	public void verifyElements(){
		isElementVisible(cityToCity);
		isElementVisible(modifySearch);
		isElementVisible(departureDate);
		isElementVisible(returnDate);
		isElementVisible(bookBtn);
	}

}
