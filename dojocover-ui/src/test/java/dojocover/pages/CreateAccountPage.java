package dojocover.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAccountPage {
	
    private static final Logger log = LogManager.getLogger(CreateAccountPage.class);
	WebDriver driver;
	
	//Locators
	private By createAccountButton=By.cssSelector("#nav-register");
	private By fullNameField=By.cssSelector("#reg-full-name");
	private By userNameField=By.cssSelector("#reg-username");
	private By phoneNumberField=By.cssSelector("#reg-phone");
	private By fieldDOB=By.cssSelector("#reg-dob");
	private By passwordField=By.cssSelector("#reg-password");
	private By confirmCheckBox=By.cssSelector("#reg-terms");
	private By submitButton=By.cssSelector("#reg-submit");
	private By welcomeTitle=By.cssSelector("#done-title");
	private By newUserName=By.cssSelector("#new-username");
	
public CreateAccountPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	
	//Action Methods
	
	public void clickOnCreateAccount() {
		
		log.info("Clicking On Create Account");
		driver.findElement(createAccountButton).click();
		
	}
	
	public void fillAccountDeatils(String fullName, String userName, long phone, String DOB, String password) {
		
		log.info("Filling Form With Mandatory Details");
		driver.findElement(fullNameField).sendKeys(fullName);
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(phoneNumberField).sendKeys(String.valueOf(phone));
		driver.findElement(fieldDOB).sendKeys(DOB);
		driver.findElement(passwordField).sendKeys(password);
		
	}
	 
	public void confirmAndSubmit() {
		
		log.info("Submitting The Form");
		driver.findElement(confirmCheckBox).click();
		driver.findElement(submitButton).click();
		
}
	public void verifyAccountCreatedSuccessfully() {
		
		String welcomeMessage=driver.findElement(welcomeTitle).getText();
		Assert.assertTrue(welcomeMessage.contains("Welcome to DojoCover"));
		log.info("Account Created successfully");
		String newUser = driver.findElement(newUserName).getText();
		log.info("New UserName:" + newUser);
	}





	
}
