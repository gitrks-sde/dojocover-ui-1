package dojocover.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	
	private String url="https://testdojo.dev/cover/QA-T63CW/";
	private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();
	
	
	
	
	public WebDriver getDriver() {
		
		return DRIVER.get();
		
	}
	
	@BeforeClass
	public void initializeConnection() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DRIVER.set(driver);
		driver.get(url);
		
	}
	@AfterClass
	public void closeConnection() throws InterruptedException
	{
		
		if(getDriver() !=null)
		{
			Thread.sleep(5000);
			getDriver().quit();
		}
	}
	

}
