package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.HomePage;
import pageObjects.ItemDetailsPage;
import pageObjects.ItemsListPage;

import java.io.IOException;
import resources.base;

public class ItemDetailsPageTest extends base {

	float f_price_list;

	@BeforeTest
	public void initialaze() throws IOException {
		driver = initiaslazeDriver();
	}
	
	@Test(priority=0)
	public void LoginAndSearch(){
		HomePage hp = new HomePage(driver);
		hp.logIn(prop.getProperty("url"),prop.getProperty("name"),prop.getProperty("pass"));
		
		Footer f = new Footer(driver);
		f.ItemSearch();
		ItemsListPage il = new ItemsListPage(driver);
		il.VerifyItemList();
	}
	
	@Test(priority=1)
	public void OpenItem() {
		ItemDetailsPage idt = new ItemDetailsPage(driver);
		ItemsListPage il = new ItemsListPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(il.FirstItemOnThePage()));
		String nameFromList = il.NameOfFirstItemFromList().getText();
		String s_firstPricePart = il.ItemPriceFromListFirst().getText();
		String s_secondPricePart= il.ItemPriceFromListSecond().getText();
		String s_priceFromList = s_firstPricePart + "." + s_secondPricePart;
		//System.out.println(s_priceFromList);
		float f_price_list = Float.parseFloat(s_priceFromList);
		this.f_price_list=f_price_list;
		il.FirstItemOnThePage().click();
		//System.out.println(nameFromList);
		String nameFromDetailsPage = idt.GetItemNameFromDetailsPage();
		Assert.assertEquals(nameFromDetailsPage,nameFromList);	
	}
	
	@Test(priority=2)
	public void AddToCart() {
		ItemDetailsPage idt = new  ItemDetailsPage(driver);
		idt.AddToCart();
	}
	
	@Test(priority=3)
	public void CheckItemPeice() {
		ItemDetailsPage idt = new  ItemDetailsPage(driver);
		String s_price = idt.getPriceFromCart().getText();
		String s_price_trimmed = s_price.substring(1);
		//System.out.println(s_price_trimmed);
		float f_price_cart = Float.parseFloat(s_price_trimmed);
		Assert.assertEquals(f_price_cart,f_price_list);		
	}
	
	@AfterTest 
	public void terDown (){
		driver.manage().deleteAllCookies();
		driver.close();
		driver=null;
	}
}
