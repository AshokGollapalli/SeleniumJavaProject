import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTabsAndPopups {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		Set<String> windID= driver.getWindowHandles();

		Iterator<String> iterator= windID.iterator();
		
		String first_window=iterator.next();
		
		System.out.println(first_window);
		
	
		driver.findElement(By.xpath("//*[@id=\"custom-button\"]/button")).click();
		
		windID= driver.getWindowHandles();
		iterator= windID.iterator();
		
		String Second_window=iterator.next();

		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[3]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[6]/div/div/div/div/div/div[2]/div[1]/div[3]/div/div/div/div[1]/div[2]/ul/li[1]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div[12]/div[5]/div[3]/div/div/div/div/div[6]/div/div[2]/div[2]/div[2]/div[1]/div[1]/table[1]/tbody/tr/th/ul/li/a")).click();
				
		
		

	}
}
