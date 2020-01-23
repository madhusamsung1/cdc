package com.TestScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVariables;

public class Fb_Login extends StaticVariables {

	// WebDriver driver;
	Locators locator = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@AfterMethod
	public void takeScreensho() throws Exception {

		cfn.takeScreenshot("Testing");
	}

	@Test
	public void login() throws Exception {

		File testDataPath = new File(
				"/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/testdata/testdata.properties");

		// Read the input file
		FileInputStream fi = new FileInputStream(testDataPath);

		// to read and write properties file java people has implemented one class:
		// properties
		Properties prop = new Properties();

		// to load the properties file values to a prop variables
		prop.load(fi);

		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		cfn.sendKeysByAnyLocators(locator.userName, prop.getProperty("UserName"));

		cfn.takeScreenshot("Fblogin_UN");

		// driver.findElement(obj.userName).sendKeys("Testing@bvnbvm.com");

		cfn.sendKeysByAnyLocators(locator.password, prop.getProperty("Password"));

		// driver.findElement(obj.password).sendKeys("scscc");

		cfn.clickKeysByAnyLocators(locator.login);

		// click on login button

		// driver.findElement(By.id("loginbutton")).click();

		Thread.sleep(5000);
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browser) throws Exception {

		cfn.chromeBrowserLaunch();

		Thread.sleep(3000);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}