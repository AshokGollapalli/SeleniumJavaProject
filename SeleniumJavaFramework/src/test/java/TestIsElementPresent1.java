import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestIsElementPresent1 {
	public static WebDriver driver;
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.navigate().to("https://gmail.com");;
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println(isElementPresent(By.xpath("//*[@id=\"yDmH0d\"]")));

	
	}
}