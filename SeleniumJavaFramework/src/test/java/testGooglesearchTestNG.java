import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testGooglesearchTestNG {
	WebDriver driver = null;
	@ BeforeTest
	public void  setUpTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
 
		/*String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/ChromeDrivers/chromedriver.exe");
		driver = new ChromeDriver();*/
	}
	@Test
	public void GoogleSearch() {
		
		driver.get("https://google.com/");
		//System.out.println("THE AUTOMATION COMPLEATED SUCCESFULLY");
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		element1.click();
		
		
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	@AfterTest
	public void tearDownTest() {
		
		
		driver.close();
		
		System.out.println("THE AUTOMATION COMPLEATED SUCCESFULLY");
		
		driver.quit();
	}
}
	
	


