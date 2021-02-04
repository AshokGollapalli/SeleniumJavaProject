import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementLocator {

public static void main(String[] args)  {
		
	String projectPath = System.getProperty("user.dir");
	System.out.println("project path : "+projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://google.com/");
		
		WebElement textBox = driver.findElement(By.name("q"));
		
		textBox.sendKeys("asssss"); 
		
		
	
		driver.close();
		


	}


}
