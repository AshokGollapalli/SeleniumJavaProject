import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		WebElement ele = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
		
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"dm2m1i1tdT\"]"))).build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"dm2m2i1tdT\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"dm2m3i1tdT\"]"));
	

	}

}
