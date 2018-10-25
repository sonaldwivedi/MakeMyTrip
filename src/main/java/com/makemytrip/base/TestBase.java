package com.makemytrip.base;

import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.util.EventHandler;

public class TestBase {

	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static EventHandler eventListener;
	public static JavascriptExecutor js;

	public void initialisation() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver/chromedriver");
		driver = new ChromeDriver();

		// Initializing EventFiringWebDriver using Firefox/Chrome WebDriver
		// instance
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new EventHandler();

		// register event listener for EventFiringWebDriver instance.
		e_driver.register(eventListener);
		driver = e_driver;

		System.out.println("Maxmising window");
		driver.manage().window().maximize();
		System.out.println("Deleting all cookies");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Launching MakeMyTrip website");
		driver.get("https://www.makemytrip.com/");
	}

	public static boolean isElementVisible(WebElement element) {
		/*
		 * to check if the element is present on the DOM of a page and visible.
		 * Visibility means that the element is not just displayed but also
		 * should also has a height and width that is greater than 0.
		 */

		System.out.println("\n********************Verifying isElementVisible********************");
		try {
			System.out.println("Waiting for the element: " + element + " to be visible for 10 secs ");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static String getCurrentDate() {
		// Gets a calendar using specified timezone
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());

		// Gives today's date in int
		int todayInt = cal.get(Calendar.DAY_OF_MONTH);

		// Converts int to String
		String todayStr = Integer.toString(todayInt);
		return todayStr;

	}

	public static void click(WebElement element) {
		System.out.println(
				"\n********************Explicitly Waiting for the element to be clickable********************");
		System.out.println("Waiting for the element: " + element + " to be clickable for 10 secs ");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Solution for stale element exception is try .refreshed
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element))).click();
	}
	
	public static void scrollTo(WebElement element){
		System.out.println("Scrolling till element: " +element);
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
