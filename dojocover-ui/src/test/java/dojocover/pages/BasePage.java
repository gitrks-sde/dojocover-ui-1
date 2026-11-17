package dojocover.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	private final WebDriver driver; 
	
	public BasePage(WebDriver driver) {
		
		this.driver=driver;
		
	}
   public String getCurrentPageURL() {
	   
	   String currentURL = driver.getCurrentUrl();
	   return currentURL;
	   
   }
}
