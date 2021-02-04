package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPageObjects {

	WebDriver driver=null;
	By textbox_search = By.name("q");
	
	By Button_Search = By.name("q");	
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
public void setTextInSearchBox(String text) {
	driver.findElement(textbox_search).sendKeys(text);
}
	
	public void clickSearchButton() {
		System.out.println("This upper line was excuited");
		
		WebElement temp = driver.findElement(Button_Search);
		
		System.out.println("This lower line was excuited");
		temp.sendKeys(Keys.RETURN);
		
}
}


