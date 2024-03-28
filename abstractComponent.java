package practice1.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponent {
	
	WebDriver driver;
	
	public abstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="button[routerlink*='cart")
	WebElement cartbutton;
	
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement checkout;
	
	
	
	public void goToCart() {
		cartbutton.click();
	}
	
	public  void waitElementstoAppear(By FindBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}
	 public void elementToDisappear(WebElement ele) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	 public void elementToClickable() {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.elementToBeClickable(checkout));
	 }
	 
	
}