package STI;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.base;

public class HomePageTest extends base {
	
	@BeforeTest
	public void initialaze() throws IOException {
		driver = initiaslazeDriver();
	}
	
	@Test(priority=0)
	public void logIn() {
		HomePage hp = new HomePage(driver);
		driver.get(prop.getProperty("url"));
		hp.MooveToSignIn();
		hp.signInButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.emailField().sendKeys(prop.getProperty("name"));
		lp.PasswordField().sendKeys(prop.getProperty("pass"));
		lp.SignInButton().click();
	}
	
	@Test(priority=1)

	public void UserNameVerificarion() {
		HomePage hp = new HomePage(driver);
		Assert.assertEquals (hp.accountName().getText(), "Hello, Auto_test");
	}
	
	@AfterTest 
	public void terDown (){
		driver.close();
		driver=null;
	}
}
