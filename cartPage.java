package practice1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice1.AbstractComponents.abstractComponent;

public class cartPage extends abstractComponent {
WebDriver driver;
@FindBy(css=".cartSection h3")
List<WebElement> productTittles;

@FindBy(xpath="//button[text()='Checkout']")
WebElement checkoutButton;

public cartPage(WebDriver driver)  {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public Boolean verifyProductDisplay(String productName) {
	
	Boolean match=	productTittles.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
	return match;
}
public void goTOcheckout() {
	checkoutButton.click();
	
}

}
