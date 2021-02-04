package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_GoogleSearch {

	public static void main(String[] args) throws Exception {
		 GoogleSearch();
		
	}
	public static void GoogleSearch() {
		
	
		/*String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
				//goto google search*/
		
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		
		System.out.println("THE AUTOMATION COMPLEATED SUCCESFULLY");
	}
	
}
