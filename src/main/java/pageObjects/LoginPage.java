package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
	public WebDriver driver;
	
	By emailElement = By.id("ap_email");
	By PasswordElement = By.id("ap_password");
	By signInButtonElement = By.id("signInSubmit");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
		
	public WebElement emailField() {
	return driver.findElement(emailElement);		
	}
	public WebElement PasswordField() {
		return driver.findElement(PasswordElement);
	}
	public WebElement SignInButton() {		
		return driver.findElement(signInButtonElement);
	}
}
