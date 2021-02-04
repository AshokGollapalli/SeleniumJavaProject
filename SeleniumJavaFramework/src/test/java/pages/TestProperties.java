package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestProperties {

	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Logger log = Logger.getLogger(TestLogs.class);
			
		public static void click(String Key) {
			
			if(Key.endsWith("_xpath")) {
				driver.findElement(By.xpath(OR.getProperty(Key))).click();
			}
			else if(Key.endsWith("_css")){
				driver.findElement(By.cssSelector(OR.getProperty(Key))).click();
			}
			else if(Key.endsWith("_ID")) {
				driver.findElement(By.id(OR.getProperty(Key))).click();
			}
			
			log.info("clicking on an Element : " + Key);
		}
			public static void type(String Key,String value) {
				
								
				if(Key.endsWith("_xpath")) {
					driver.findElement(By.xpath(OR.getProperty(Key))).sendKeys(Config.getProperty(value));
				}
				else if(Key.endsWith("_css")){
					driver.findElement(By.cssSelector(OR.getProperty(Key))).sendKeys(Config.getProperty(value));
				}
				else if(Key.endsWith("_ID")) {
					driver.findElement(By.id(OR.getProperty(Key))).sendKeys(Config.getProperty(value));
				}
				
				log.info("Typing in an Element : " + Key + "Entered the Value as : "+value);
			}
			
			public static boolean isElementPresent(String Key) {
				try {
					if(Key.endsWith("_xpath")) {
						driver.findElement(By.xpath(OR.getProperty(Key)));
					}
					else if(Key.endsWith("_css")){
						driver.findElement(By.cssSelector(OR.getProperty(Key)));
					}
					else if(Key.endsWith("_ID")) {
						driver.findElement(By.id(OR.getProperty(Key)));
					}
					
					log.info("Finding the Element : " + Key);
				
					return true;
					
				}catch(Throwable t) {
					t.printStackTrace();
					log.info(t.getMessage());
					log.error(t.getMessage());
					return false;
				}
			}
		
	public static void main(String[] args) throws IOException {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\log4j.properties");
			
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\OR.properties");
		OR.load(fis);
		log.info("OR.Properties Launched");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\Config.properties");
		Config.load(fis);
		log.info("Config.Properties Launched");
		
//		//driver.get(Config.getProperty("testsiteUrl"));
//		System.out.println(Config.getProperty("testsiteUrl"));
//			
//		
//		//driver.findElement(By.id(OR.getProperty("email_ID"))).sendKeys("trainer at way@work");
//		System.out.println(OR.getProperty("email_ID"));
		
	
		driver.get(Config.getProperty("testsiteUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		type("email_xpath","idName");
		
		type("password_xpath","password");	
		
		click("nextBtn_xpath");
		
		
		
	}
	

}
