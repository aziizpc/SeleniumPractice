package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Freshworks {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://codeshare.io/gL4ed8");
		
		driver.manage().window().maximize();
		
		WebElement element =  driver.findElement(By.xpath("//*[@id='editor']/div/div/div[6]/div[1]/div/div/div/div[5]"));
		
		String s = element.getText();
		
		System.out.println(s);
		
		driver.findElement(By.xpath("//*[@id='editor']/div/div/div[6]/div[1]/div/div/div/div[5]/div[7]/pre")).sendKeys("Hello World");
		
				

	}

}
