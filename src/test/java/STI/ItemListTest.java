package STI;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Footer;
import pageObjects.HomePage;

import java.io.IOException;
import resources.base;

public class ItemListTest extends base {

	@BeforeTest
	public void initialaze() throws IOException {
		driver = initiaslazeDriver();
	}
	
	@Test
	public void OnePageResultVerefication()  {
		HomePage hp = new HomePage(driver);
		hp.logIn(prop.getProperty("url"),prop.getProperty("name"),prop.getProperty("pass"));
		Footer f = new Footer(driver);
		f.MainSearchField().sendKeys("toster");
		f.SearchButton().click();
		
		
		
	}
	
	@AfterTest 
	public void terDown (){
		driver.close();
		driver=null;
	}
}
