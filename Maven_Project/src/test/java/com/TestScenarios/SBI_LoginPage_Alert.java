package com.TestScenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.ObjectRepository.Locators;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVariables;

public class SBI_LoginPage_Alert extends StaticVariables {

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

		FileInputStream fi = new FileInputStream(testDataPath);

		Properties prop = new Properties();

		prop.load(fi);

		driver.get(prop.getProperty("SBI_URL"));
		cfn.implicitWait(20);

		// Develop the actual Scripts....
		cfn.clickKeysByAnyLocators(locator.sbi_Login);
		cfn.implicitWait(5);
		cfn.clickKeysByAnyLocators(locator.sbi_ContinueToLogin);
		cfn.implicitWait(5);
		cfn.clickKeysByAnyLocators(locator.sbi_LoginPage_LoginButton);
		cfn.implicitWait(5);

		// handle with Alert
		cfn.explicitWaitForAlert(5);
		cfn.alertHandleWithOkButton();

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
