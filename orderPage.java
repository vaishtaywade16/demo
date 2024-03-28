package practice1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice1.AbstractComponents.abstractComponent;

public class orderPage extends abstractComponent {
WebDriver driver;

@FindBy(css=".hero-primary")
WebElement  orderMessage;

public orderPage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	public String verifyOrderMessage() {
		 String ordermsg =orderMessage.getText();
		return ordermsg;
	}
	
}
