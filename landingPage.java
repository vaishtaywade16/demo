package practice1.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice1.AbstractComponents.abstractComponent;

public class landingPage extends abstractComponent{
	WebDriver driver;
	
	public landingPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	

@FindBy(id="userEmail")
WebElement  userid;

@FindBy(id="userPassword")
WebElement  userpass;
	
@FindBy(id="login")
WebElement  loginbttn;

public void applicationlogin(String email, String pass) {
	userid.sendKeys(email);
	userpass.sendKeys(pass);
	loginbttn.click();
}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}	
}
