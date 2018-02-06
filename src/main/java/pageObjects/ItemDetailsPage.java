package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class ItemDetailsPage {
	public WebDriver driver;
	
	By NameFromItemDetailsPageElement = By.id("productTitle");
	By AddToCartButtonElement = By.id("add-to-cart-button");
	By AddedToCartTextElement = By.xpath("//*[@id=\'huc-v2-order-row-confirm-text\']/h1");
	By GoToCartButtonElement = By.id("hlb-view-cart-announce");
	By PriceFromCart = By.xpath("//*[@id='gutterCartViewForm']/div[3]/div[2]/div/div[1]/p/span/span[2]");
	By DeleteItemLinkElement = By.linkText("Delete");
	
	//constructor
	public ItemDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement NameFromItemDetailsPage() {
		return driver.findElement(NameFromItemDetailsPageElement);
	}
	public String GetItemNameFromDetailsPage() {
		ItemDetailsPage id = new ItemDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(id.NameFromItemDetailsPage()));
		String nameFromDetailsPage = id.NameFromItemDetailsPage().getText();
		//System.out.println(nameFromDetailsPage);
		return nameFromDetailsPage;
	}
	public WebElement AddToCartButton() {
		return driver.findElement(AddToCartButtonElement);
	}
	public WebElement AddedToCartTextElement() {
		return driver.findElement(AddedToCartTextElement);
	}
	public String AddedToCartText() {
		String AddedToCartText = driver.findElement(AddedToCartTextElement).getText();
		return AddedToCartText;
	}
	public WebElement GoToCartButton () {
		return driver.findElement(GoToCartButtonElement);
	}
	public void AddToCart() {
		ItemDetailsPage idt = new  ItemDetailsPage(driver);
		idt.AddToCartButton().click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(idt.AddedToCartTextElement()));
		Assert.assertEquals(idt.AddedToCartText(),"Added to Cart");
		idt.GoToCartButton().click();
	}
	public WebElement getPriceFromCart() {
		return driver.findElement(PriceFromCart);	
	}	
	public WebElement DeleteItemFromCart() {
		return driver.findElement(DeleteItemLinkElement);
	}
}


