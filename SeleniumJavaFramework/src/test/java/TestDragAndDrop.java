import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDragAndDrop {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement draggable = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement droppable = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		new Actions(driver).dragAndDrop(draggable,droppable).perform();
	}

}
