package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {
	public WebDriver driver;
	
	By signInPopUpElement = By.xpath("//a[@id='nav-link-accountList']");
	By signInButtonElement = By.xpath("//div[@id='nav-flyout-ya-signin']/a/span");
	By accountNameElement = By.xpath("//*[@id='nav-link-accountList']/span[1]");
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement signInPopUp() {
		return driver.findElement(signInPopUpElement);	
	}
	public WebElement signInButton() {
		return driver.findElement(signInButtonElement);
	}	
	public void MooveToSignIn() {		
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(signInPopUpElement)).build().perform();
	}
	public WebElement accountName() {
		return driver.findElement(accountNameElement);
	}
	public void logIn(String url,String name,String pass) {
		HomePage hp = new HomePage(driver);
		driver.get(url);
		hp.MooveToSignIn();
		hp.signInButton().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.emailField().sendKeys(name);
		
		int isPassPresent = driver.findElements(lp.PasswordElement).size();
		
		if(isPassPresent > 0) {			 
			lp.PasswordField().sendKeys(pass);
			lp.SignInButton().click();
			}
		else {
			lp.ContinueButton().click();
			lp.PasswordField().sendKeys(pass);
			lp.SignInButton().click();
		}
	}	
}
