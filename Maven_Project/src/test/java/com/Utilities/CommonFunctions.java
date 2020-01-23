package com.Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions extends StaticVariables{

	/****** Browser Launch ******/
	public void chromeBrowserLaunch() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/drivers/chromedriver");
		 driver = new ChromeDriver();
	}
	
	/******* sendKeys *********/
	
	public void sendKeysByAnyLocators(By locator,String inputdata)
	{
		
		WebElement element = driver.findElement(locator);
		
				if(element.isDisplayed()) {
			
			if(element.isEnabled()) {
				
				element.clear();
				element.sendKeys(inputdata);
			
			} 
			else {
				System.out.println("Element is not disable state");
			}
			
				}else {
				System.out.println("Element is not displayed");
			}
		
		}
	
		
/********  click  ********/		

public void clickKeysByAnyLocators(By locator)
{
	
	WebElement element = driver.findElement(locator);
	
			if(element.isDisplayed()) {
		
		if(element.isEnabled()) {
			
			element.click();
			
		} 
		else {
			System.out.println("Element is not disable state");
		}
		
			}else {
			System.out.println("Element is not displayed");
		}
}
/********** TimeStamp **********/
public String timeStamp() {
	
	Date d = new Date();
	System.out.println("System Data & Time is:" + d);
	//ddMMyyyyHHmmss
	DateFormat df = new SimpleDateFormat("ddMMyyyyHHmmss");
	String timeStamp = df.format(d);
	
	return timeStamp;
	
}
/*************  Take Screenshot 
 * @throws Exception ********/

public void takeScreenshot(String nameOfTheScreenshot) throws Exception {
	//path
	String screenshotPath = "/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/screenshots";
	//take screenshot and store it into RAM location
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//move it to local area
	
	FileHandler.copy(srcFile, new File(screenshotPath + nameOfTheScreenshot+timeStamp()+".PNG"));
	
}

/*************Cross Browser Launch ***************/

public void crossBrowserLaunch(String browser) {
	if(browser.equalsIgnoreCase("Chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/drivers/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
	}else if(browser.equalsIgnoreCase("Firefox")) {
		
		System.setProperty("webdriver.gecko.driver", "/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/drivers/geckodriver");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
	}
	
}

/**************** Implicit Wait ************/

public void implicitWait(long time) {  //3 sec
	
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
}

/********** explicit Wait Functions**********/

public void explicitWaitForAlert(long time) {
WebDriverWait ww = new WebDriverWait(driver, time);
ww.until(ExpectedConditions.alertIsPresent());

System.out.println("Alert has displayed ExplictWait");
}

/************ Alert handle ***********/

public void alertHandleWithOkButton() {
	//Get the text from Alert
	System.out.println("Alert Text is:"+driver.switchTo().alert().getText());
	//Click on Ok button
	driver.switchTo().alert().accept();
}

public void alertHandleWithCancelButton() {
	//Get the text from Alert
	System.out.println("Alert Text is:"+driver.switchTo().alert().getText());
	//Click on cancel button
	driver.switchTo().alert().dismiss();

}

}






		

	
	

