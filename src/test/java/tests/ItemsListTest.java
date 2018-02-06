package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.HomePage;
import pageObjects.ItemsListPage;

import java.io.IOException;
import resources.base;

public class ItemsListTest extends base {
	
	@BeforeTest
	public void initialaze() throws IOException {
		driver = initiaslazeDriver();
	}
	
	@Test(priority=0)
	public void SuccessfulItemSearch()  {
		HomePage hp = new HomePage(driver);
		hp.logIn(prop.getProperty("url"),prop.getProperty("name"),prop.getProperty("pass"));
		Footer f = new Footer(driver);
		f.ItemSearch();
		ItemsListPage il = new ItemsListPage(driver);
		il.VerifyItemList();
	}
	
	@AfterTest 
	public void terDown (){
		driver.manage().deleteAllCookies();
		driver.close();
		driver=null;
	}
}
