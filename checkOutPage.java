package practice1.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import practice1.AbstractComponents.abstractComponent;

public class checkOutPage extends abstractComponent {
	WebDriver driver;
	
	public checkOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[placeholder='Select Country']")
	WebElement countrybox;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countryselect;
	
	By suggestedResult=By.cssSelector(".ta-item");
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
public void windowscroll() {
	JavascriptExecutor js =(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,650)");
}

public  void selectCountry() {
	Actions action = new Actions(driver);
	action.sendKeys(countrybox,"india")
	.build().perform();
}

public void countryResult() {
	waitElementstoAppear(suggestedResult);
	countryselect.click();
	//elementToDisappear(By.cssSelector(".ta-item"));
	placeOrder.click();
}
 
public  void waitToSelectcountry(WebElement ele) {
	 waitElementstoAppear(suggestedResult );
	 countryselect.click();
	 elementToDisappear(driver.findElement(By.cssSelector(".ta-item")));
}
public void clickPlaceorder() {
	placeOrder.click();
}


}
