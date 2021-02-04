import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestKeyBoardEvents {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://gmail.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.id("identifierId")).sendKeys("Ashokgollapally");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
		
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		driver.findElement(By.id("identifierId")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();

	}

}
