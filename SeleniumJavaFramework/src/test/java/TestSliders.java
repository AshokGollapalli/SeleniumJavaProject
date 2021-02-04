import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class TestSliders {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement Slider = driver.findElement(By.xpath("/html/body/div/span"));
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, mainSlider.getSize().width/2, 0).perform();
		

	}

} 
