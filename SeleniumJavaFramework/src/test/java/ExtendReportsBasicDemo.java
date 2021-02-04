import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtendReportsBasicDemo {
	static WebDriver driver = null;
public static void main(String[] args) {
	

	
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
	
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	ExtentTest test1 = extent.createTest("Google search", "this isa test to validate google search functionality");
	
	/*String projectPath = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/ChromeDrivers/chromedriver.exe");
	 driver = new ChromeDriver();*/
	
					
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	 
	//WebDriverManager.firefoxdriver().setup();
	//WebDriver driver = new FirefoxDriver();
	
	test1.log(Status.INFO, "starting test case");
	driver.get("https://google.com/");
	
	test1.pass("entered test in search box");
	driver.findElement(By.name("q")).sendKeys("Automation step by step");
	
	test1.pass("pressed key bord entered key");
	WebDriverWait wait1 = new WebDriverWait(driver, 10);
	WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
	element1.click();
	driver.close();
	test1.pass("close the browser");
	test1.info("test completed");
	extent.flush();
}
}
