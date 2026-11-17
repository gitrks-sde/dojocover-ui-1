package dojocover.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import dojocover.base.Base;



public class TestListener implements ITestListener{

	
	private static final Logger Log = LogManager.getLogger(TestListener.class);
	Base base = new Base();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		Log.info("Passed: {}" +result);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		this.takeScreenshot();

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
public void takeScreenshot() {
	
	    String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
    	File srcFile = ((TakesScreenshot)base.getDriver()).getScreenshotAs(OutputType.FILE);
    	String destinationPath = System.getProperty("user.dir") + "/screenshots/" + timeStamp + "screenshot.png";
    	try {
    		
    		Files.copy(srcFile.toPath(), Paths.get(destinationPath));
    		Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
    		System.out.println("Saved Success");
    		
    		
    	}
    	
    	catch(IOException e) {
    		
    		System.out.println("Failed to save screenshot");
    	}
    	
    	
    }
	
	
	
	
	
	
}
