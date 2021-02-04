import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class OnlineBuying {

	public static Properties Elements = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Properties Data = new Properties();
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}
	}
	
	public static void click(String Key) {
		
		if(Key.endsWith("_xpath")) {
			//System.out.println("hi");
			driver.findElement(By.xpath(Elements.getProperty(Key))).click();
		}
		else if(Key.endsWith("_css")){
			driver.findElement(By.cssSelector(Elements.getProperty(Key))).click();
		}
		else if(Key.endsWith("_ID")) {
			driver.findElement(By.id(Elements.getProperty(Key))).click();
		}
	}
	
		public static void type(String Key,String value) {
			
			if(Key.endsWith("_xpath")) {
				System.out.println("hi");
				driver.findElement(By.xpath(Elements.getProperty(Key))).sendKeys(Data.getProperty(value));
			}
			else if(Key.endsWith("_css")){
				driver.findElement(By.cssSelector(Elements.getProperty(Key))).sendKeys(Data.getProperty(value));
			}
			else if(Key.endsWith("_ID")) {
				driver.findElement(By.id(Elements.getProperty(Key))).sendKeys(Data.getProperty(value));
			}
		}
		
		
	public static void main(String[] args) throws IOException {
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Elements.properties");
		Elements.load(fis);
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Data.properties");
		Data.load(fis);
		
		if(Data.getProperty("browser").equals("chrome")) {
			System.setProperty(Data.getProperty("chromeDriverKey"),System.getProperty("user.dir")+Data.getProperty("chromDriverPath"));
			driver= new ChromeDriver();
			
		}else if(Data.getProperty("browser").equals("firefox")) {
			System.setProperty(Data.getProperty("firefoxDriverKey"),System.getProperty("user.dir")+Data.getProperty("firefoxDriverPath"));
			driver= new FirefoxDriver();
			
		}else if(Data.getProperty("browser").equals("IE")) {
			System.setProperty(Data.getProperty("IEDriverKey"),System.getProperty("user.dir")+Data.getProperty("IEDriverPath"));
			driver= new InternetExplorerDriver();
		}
		driver.get(Data.getProperty("testsiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Data.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		type("Search_xpath","SearchContenet");
		click("ClickSearch_xpath");
		click("ClickOnM51_xpath");
		//click("fshion_xpath");
		//type("QueryBtn_xpath","SearchQuery");
		click("VisitSamStore_xpath");
		//click("answered_xpath");
	}

}
