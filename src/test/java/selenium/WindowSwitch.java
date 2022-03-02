package selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitch {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.oracle.com/index.html");
		driver.manage().window().maximize();		
		String parentWindowID = driver.getWindowHandle();	// Get Parent Window Handle
		driver.findElement(By.xpath("//*[@id='u10']/div/div[7]/ul[3]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='u10']/div/div[7]/ul[3]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id='u10']/div/div[7]/ul[3]/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id='u10']/div/div[7]/ul[3]/li[4]/a")).click();

		Set<String> allHandles = driver.getWindowHandles();
		List<String> allHandlesList = new ArrayList<String>(allHandles);

		// Switch to child
		if (switchToRightWindowUsingTitle("Facebook", allHandlesList)) {
			System.out.println(driver.getCurrentUrl() + " ------ " + driver.getTitle());
		}

		// Switch to parent
		switchToParentWindow(parentWindowID);
		System.out.println(driver.getCurrentUrl() + " ------ " + driver.getTitle());

		// Close
		closeAllWindows(parentWindowID, allHandlesList);
	}

	public static boolean switchToRightWindowUsingTitle(String windowTitle, List<String> allHandlesList) {

		for (String s : allHandlesList) {
			String title = driver.switchTo().window(s).getTitle(); // Switch one after the other
			if (title.contains(windowTitle)) {
				System.out.println("Window found :)");
				return true;
			}
		}
		return false;
	}

	public static void switchToParentWindow(String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}

	public static void closeAllWindows(String parentWindowID, List<String> allHandlesList) {
		for (String s : allHandlesList) {
			if (!s.equals(parentWindowID)) {
				driver.switchTo().window(s).close();
			}
		}
	}
}