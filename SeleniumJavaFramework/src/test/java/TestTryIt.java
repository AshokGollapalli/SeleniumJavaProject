import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestTryIt {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_geolocation");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		List<WebElement> frames= driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for(WebElement frame:frames) {
			System.out.println(frame.getAttribute("id"));
		}
		driver.switchTo().frame("iframeResult");
		//driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"iframeResult\"]")));
		driver.findElement(By.xpath("/html/body/button")).click();
	}

}
