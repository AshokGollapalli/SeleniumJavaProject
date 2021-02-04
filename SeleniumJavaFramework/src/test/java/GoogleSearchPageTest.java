import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	static WebDriver driver = null;
	public static void main(String[] args) {
		GoogleSearch();
	}
	public static void GoogleSearch() {
		//String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/ChromeDrivers/chromedriver.exe");
		// driver = new ChromeDriver();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		 
		 GoogleSearchPageObjects SearchPageObj = new GoogleSearchPageObjects(driver);
		 
		 driver.get("https://google.com/");
		 
		 SearchPageObj.setTextInSearchBox("A B C D E F G H");
		 
		 SearchPageObj.clickSearchButton();
		 System.out.println("This END line was excuited");
		 driver.close();
	}
}
