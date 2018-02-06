package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Footer {
	public WebDriver driver;
	
	By MainSearchFieldElement = By.id("twotabsearchtextbox");
	By SearchButtonElement = By.cssSelector("input[value=Go]");
	
	//constructor
	public Footer(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement MainSearchField () {
		return driver.findElement(MainSearchFieldElement);
	}
	public WebElement SearchButton () {
		return driver.findElement(SearchButtonElement);
	}
	public void ItemSearch() {
	Footer f = new Footer(driver);
	f.MainSearchField().sendKeys("toaster");
	f.SearchButton().click();
	}
}
