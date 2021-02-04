import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPages;

public class Googlesearch {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		 GoogleSearch();
		 
	}
	public static void GoogleSearch() {
		
	
		/*String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/ChromeDrivers/chromedriver.exe");
		 driver = new ChromeDriver();*/
		
						
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		 
		 System.out.println("0 THE AUTOMATION COMPLEATED SUCCESFULLY");
		driver.get("https://google.co.in");
		//System.out.println("THE AUTOMATION COMPLEATED SUCCESFULLY");
		
		//driver.findElement(By.name("q")).sendKeys("Automation step by step");
		
		GoogleSearchPages.textBox_Search(driver).sendKeys("Automation ");
		System.out.println("1 THE AUTOMATION COMPLEATED SUCCESFULLY");
		
		System.out.println("2 THE AUTOMATION COMPLEATED SUCCESFULLY");
		
		WebElement temp = GoogleSearchPages.button_search(driver);
		System.out.println(temp);
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(temp));
		element1.click();
		//temp.sendKeys(Keys.ENTER);
		
		//System.out.println("5 THE AUTOMATION COMPLEATED SUCCESFULLY");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		
		System.out.println("THE AUTOMATION COMPLEATED SUCCESFULLY");
		
	}
	
	
	
	
	

}
