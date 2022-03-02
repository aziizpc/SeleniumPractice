package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/web-table-element.php");

		// *[@id="leftcontainer"]/table/tbody/tr[1]/td[1]/a
		// *[@id="leftcontainer"]/table/tbody/tr[7]/td[1]/a
		// *[@id="leftcontainer"]/table/tbody/tr[6]/td[1]/a
		// *[@id="leftcontainer"]/table/tbody/tr[17]/td[1]/a

		String beforePath = "//*[@id='leftcontainer']/table/tbody/tr[";
		String afterPath = "]/td[1]/a";

		for (int i = 1; i <= 25; i++) {
			String xpath = beforePath + i + afterPath;
			WebElement element = driver.findElement(By.xpath(xpath));
			System.out.println(element.getText());

			if (element.getText().equals("HDIL")) {
				System.out.println("Company Name: " + element.getText() + " is found!");
				break;
			}

		}

		double pcChange = 5.5;
		List<WebElement> allRows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		System.out.println("Number of rows: " + allRows.size());

		// *[@id="leftcontainer"]/table/tbody/tr[1]/td[5]/font
		// *[@id="leftcontainer"]/table/tbody/tr[26]/td[5]/font

		String pcChangeBefore = "//*[@id='leftcontainer']/table/tbody/tr[";
		String pcChangeAfter = "]/td[5]/font";
		
		String beforeGroup = "//*[@id='leftcontainer']/table/tbody/tr[";
		String afterGroup = "]/td[5]/font/parent::td/preceding-sibling::td[3]";
		
		String beforePrevClose = "//*[@id='leftcontainer']/table/tbody/tr[";
		String afterPrevClose = "]/td[5]/font/parent::td/preceding-sibling::td[2]";
		
		String beforeCurrentPrice = "//*[@id='leftcontainer']/table/tbody/tr[";
		String afterCurrentPrice = "]/td[5]/font/parent::td/preceding-sibling::td[1]";		

		System.out.println("Group\tPrev Close\tCurrentPrice");
		for (int i = 1; i < allRows.size(); i++) {
			String pcChangeXpath = pcChangeBefore + i + pcChangeAfter;			
			String getPcAsString = driver.findElement(By.xpath(pcChangeXpath)).getText().replaceAll("[^0-9.]", "");
			double getPcAsInt = Double.parseDouble(getPcAsString);
			if (getPcAsInt >= pcChange) {
				//System.out.println(getPcAsInt);
				String currentPriceXpath = beforeCurrentPrice + i + afterCurrentPrice;
				String currentPrice = driver.findElement(By.xpath(currentPriceXpath)).getText();
				//System.out.println(currentPrice);
				String prevCloseXpath = beforePrevClose + i + afterPrevClose;
				String prevClose = driver.findElement(By.xpath(prevCloseXpath)).getText();
				String groupXpath = beforeGroup + i + afterGroup;
				String group = driver.findElement(By.xpath(groupXpath)).getText();				 
				System.out.println(group + "\t" + prevClose + "\t\t" + currentPrice);
			}			 
			
		}

	}

}