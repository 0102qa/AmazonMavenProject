package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import pageObjects.HomePage;
import resources.base;

public class HomePageTest extends base {
	
	@BeforeTest
	public void initialaze() throws IOException {
		driver = initiaslazeDriver();
	}
	
	@Test(priority=0)
	public void SuccessfulLogIn() {
		HomePage hp = new HomePage(driver);
		hp.logIn(prop.getProperty("url"),prop.getProperty("name"),prop.getProperty("pass"));
	}
			
	@Test(priority=1)
		public void UserNameVerificarion() {
		HomePage hp = new HomePage(driver);
		Assert.assertEquals (hp.accountName().getText(), "Hello, Auto_test");
	}
	
	
	@AfterTest 
	public void terDown (){
		driver.manage().deleteAllCookies();
		driver.close();
		driver=null;
	}
}
