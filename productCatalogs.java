package practice1.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice1.AbstractComponents.*;
import practice1.pageobjects.*;

import practice1.AbstractComponents.abstractComponent;

public class productCatalogs extends abstractComponent {
WebDriver driver;
	
	public productCatalogs(WebDriver driver){
		super(driver);
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
// extract list of products
@FindBy(css=".mb-3")
List<WebElement> products;

@FindBy(css=".ng-animating")
WebElement spinner;

By addToCartBttn=By.cssSelector(".card-body button:last-of-type");

//By AllProductsName= By.cssSelector("b");
By addproduct = By.cssSelector("button[routerlink*='cart']");
By product= By.cssSelector(".mb-3");
By toastMessage= By.cssSelector("#toast-container");

public List<WebElement> productslist() {
	waitElementstoAppear(product);
	return products;
}

public WebElement getproductbyname(String productName) {
	WebElement prod=productslist().stream().filter(s->s.findElement(By.cssSelector("b"))
			.getText().equals(productName)).findFirst().orElse(null);
			
			prod.findElement(addToCartBttn).click();
return prod;
	
}
 public void addProductToCart(String productName) {
	WebElement prod= getproductbyname(productName);
	 //prod.findElement(addproduct).click();
	 waitElementstoAppear(toastMessage);
	 elementToDisappear(spinner);
 }
}
