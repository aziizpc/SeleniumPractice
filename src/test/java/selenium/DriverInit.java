package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {

	private static DriverInit instanceDriver = null;
	private WebDriver driver;

	private DriverInit() {	// This is NOT really required ???

	}

	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static DriverInit getInstance() {	// Lazy initialization
		if (instanceDriver == null)
			instanceDriver = new DriverInit();
		return instanceDriver;
	}
}
