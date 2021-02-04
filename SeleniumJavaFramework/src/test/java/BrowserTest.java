import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTest {

public static void main(String[] args) throws InterruptedException {
		
	String projectPath = System.getProperty("user.dir");
	System.out.println("project path : "+projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath +"\\Drivers\\geckodrivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		//System.setProperty("webdriver.ie.driver", projectPath+"\\Drivers\\internetexplorer\\IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
			
	
		driver.get("https://selenium.dev/");
		Thread.sleep(3000);
		driver.close();
		


	}

	
}
