package selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest {
	
	WebDriver myDriver;
	
	@BeforeMethod
	public void setUp() {
		DriverInit myInstanceDriver = DriverInit.getInstance();
		myDriver = myInstanceDriver.openBrowser();
	}
	
	@Test
	public void testMethod1() {
		myDriver.get("https://www.google.com/");
		System.out.println(myDriver.getTitle());
	}
	
	@AfterMethod
	public void tearDown() {
		myDriver.quit();
	}

}