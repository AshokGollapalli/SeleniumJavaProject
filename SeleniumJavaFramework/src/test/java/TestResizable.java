import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class TestResizable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new FirefoxDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement frame = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/iframe"));
		driver.switchTo().frame(frame);
		//html/body/div[2]/div[2]/div/div[1]/iframe
		WebElement Resize = driver.findElement(By.xpath("/html/body/div/div[3]"));
		Actions action = new Actions(driver);
		;
		action.dragAndDropBy(Resize,350,250).perform();
	}

}
