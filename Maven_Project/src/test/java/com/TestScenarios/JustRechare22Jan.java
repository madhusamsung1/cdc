package com.TestScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ObjectRepository.Locators;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVariables;

import jxl.Sheet;
import jxl.Workbook;

public class JustRechare22Jan extends StaticVariables{
	
	Locators locator = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void login() throws Exception {

		File testDatapath = new File(
				"/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/testdata/testdata.properties");
		FileInputStream fi = new FileInputStream(testDatapath);
		Properties p = new Properties();
		p.load(fi);

		driver.get(p.getProperty("JustRecharge_URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		FileInputStream excelpath = new FileInputStream(
				"/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/testdata/JustRecharge.xls");

		Workbook wb = Workbook.getWorkbook(excelpath);

		Sheet s = wb.getSheet("Sheet1");
		Sheet s1 = wb.getSheet("Re-test");
		
		for (int i = 1; i < s1.getRows(); i++) {
			// develop the actual scripts
			driver.findElement(By.xpath(s.getCell(2, 2).getContents())).click();
			driver.findElement(By.id(s.getCell(2, 3).getContents())).sendKeys(s1.getCell(0, i).getContents());
			driver.findElement(By.id(s.getCell(2, 4).getContents())).sendKeys(s1.getCell(1, i).getContents());
			driver.findElement(By.id(s.getCell(2, 5).getContents())).click();
			;

			Thread.sleep(6000);
			System.out.println("Given credentials are valid");
			driver.navigate().to("https://www.delta.com/login/loginPage");
			driver.navigate().refresh();
			
			Thread.sleep(3000);

		}
	}

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browser) {
		cfn.chromeBrowserLaunch();

	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}
  
	
	
	
}
