package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class ItemsListPage {
	public WebDriver driver;
	
	By SearchResultTextElement = By.cssSelector("a[id='bcKwText']");
	By SearchResultListElements = By.xpath("//ul[@id='s-results-list-atf']/li");
	By FirstItemOnThePageElement = By.xpath("//ul[@id='s-results-list-atf']/li[1]");
	By NameOfFirstItemElement = By.xpath("//ul[@id='s-results-list-atf']/li[1]/div/div[4]/div/a/h2");
	By FirstPartOfPrice = By.xpath("//*[@id=\"result_0\"]/div/div[6]/div[1]/a/span[2]/span/span");
	By SecondPartOfPrice = By.xpath("//*[@id=\"result_0\"]/div/div[6]/div[1]/a/span[2]/span/sup[2]");

	//constructor
	public ItemsListPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement SearchResult () {
		return driver.findElement(SearchResultTextElement);
	}
	public List<WebElement> SearchResultList() {
		return driver.findElements(SearchResultListElements);
	}
	public WebElement FirstItemOnThePage () {
		return driver.findElement(FirstItemOnThePageElement);
	}
	public WebElement NameOfFirstItemFromList() {
		return driver.findElement(NameOfFirstItemElement);
	}
	public WebElement ItemPriceFromListFirst() {
		return driver.findElement(FirstPartOfPrice);
	}
	public WebElement ItemPriceFromListSecond() {
		return driver.findElement(SecondPartOfPrice);
	}
	public void VerifyItemList() {
	ItemsListPage il = new ItemsListPage(driver);
	Assert.assertEquals(il.SearchResult().getText(), "\"toaster\"");
	int itemsCount= il.SearchResultList().size();
	Assert.assertTrue(itemsCount>=1);
	}
	
}

