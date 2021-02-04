import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.Status;

import pages.TestLogs;

public class OnlinePillowBuying {

	public static Properties PillowOR = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Properties PillowConfig = new Properties();
	public static Logger log = Logger.getLogger(OnlinePillowBuying.class);
			
		public static void click(String Key) {
			
			if(Key.endsWith("_xpath")) {
				driver.findElement(By.xpath(PillowOR.getProperty(Key))).click();
			}
			else if(Key.endsWith("_css")){
				driver.findElement(By.cssSelector(PillowOR.getProperty(Key))).click();
			}
			else if(Key.endsWith("_ID")) {
				driver.findElement(By.id(PillowOR.getProperty(Key))).click();
			}
			
			log.info("clicking on an Element : " + Key);
		}
			public static void type(String Key,String value) {
				
								
				if(Key.endsWith("_xpath")) {
					driver.findElement(By.xpath(PillowOR.getProperty(Key))).sendKeys(PillowConfig.getProperty(value));
				}
				else if(Key.endsWith("_css")){
					driver.findElement(By.cssSelector(PillowOR.getProperty(Key))).sendKeys(PillowConfig.getProperty(value));
				}
				else if(Key.endsWith("_ID")) {
					driver.findElement(By.id(PillowOR.getProperty(Key))).sendKeys(PillowConfig.getProperty(value));
				}
				
				log.info("Typing in an Element : " + Key + "Entered the Value as : "+value);
			}
			
			public static boolean isElementPresent(String Key) {
				try {
					if(Key.endsWith("_xpath")) {
						driver.findElement(By.xpath(PillowOR.getProperty(Key)));
					}
					else if(Key.endsWith("_css")){
						driver.findElement(By.cssSelector(PillowOR.getProperty(Key)));
					}
					else if(Key.endsWith("_ID")) {
						driver.findElement(By.id(PillowOR.getProperty(Key)));
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
		
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\log4j.properties");
			
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\PillowOR.properties");
		PillowOR.load(fis);
		log.info("PillowOR.Properties Launched");
		
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\PillowConfig.properties");
		PillowConfig.load(fis);
		log.info("PillowConfig.Properties Launched");
		
		if(PillowConfig.getProperty("browser").equals("chrome")) {
			System.setProperty(PillowConfig.getProperty("chromeDriverKey"),System.getProperty("user.dir")+PillowConfig.getProperty("chromDriverPath"));
			driver= new ChromeDriver();
			log.info("Chrome browser Launched");
			
		}else if(PillowConfig.getProperty("browser").equals("firefox")) {
			System.setProperty(PillowConfig.getProperty("firefoxDriverKey"),System.getProperty("user.dir")+PillowConfig.getProperty("firefoxDriverPath"));
			driver= new FirefoxDriver();
			log.info("Firefox browser Launched");
			
		}else if(PillowConfig.getProperty("browser").equals("IE")) {
			System.setProperty(PillowConfig.getProperty("IEDriverKey"),System.getProperty("user.dir")+PillowConfig.getProperty("IEDriverPath"));
			driver= new InternetExplorerDriver();
			log.info("IE browser Launched");
		}
		
		driver.get(PillowConfig.getProperty("testsiteUrl"));

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		click("clickBuy_xpath");
		Thread.sleep(2000);
		click("chekout_xpath");
		
		WebElement testframe = driver.findElement(By.xpath("//*[@id=\"snap-midtrans\"]"));
		driver.switchTo().frame(testframe);
		
		
		click("contin_xpath");
		click("credit_xpath");
		
		int y=123,OTP=112233;
		int Date=1224;
		
		long x=4811111111111114l;
		
	
		
				
		if((x==Long.valueOf(PillowConfig.getProperty("AccntNo"))) && (y==Integer.parseInt(PillowConfig.getProperty("CVV"))) && (Date==Integer.parseInt(PillowConfig.getProperty("ExpiryDate"))) && (OTP==Integer.parseInt(PillowConfig.getProperty("OTP"))))
		{
			System.out.println("your credentials are validated Sucessfully");
		} 
		else 
		{
			System.out.println("wrong credentials provided ");
			System.exit(0);
		}
					
		type("cardNo_xpath","AccntNo");
		type("CVV_xpath","CVV");
		type("ExpiryDate_xpath","ExpiryDate");
		click("PayNow_xpath");
		
		WebElement testframe2 = driver.findElement(By.xpath("//*[@id=\"application\"]/div[3]/div/div/div/iframe"));
		driver.switchTo().frame(testframe2);
		
		Thread.sleep(3000);
		click("ok_xpath");
	}

}
