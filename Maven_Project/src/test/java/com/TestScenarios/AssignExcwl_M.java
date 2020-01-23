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

public class AssignExcwl_M extends StaticVariables {
	
	Locators locator = new Locators();
	CommonFunctions cfn = new CommonFunctions();

	@Test
	public void login() throws Exception{
		
		File testDatapath = new File("/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/testdata/testdata.properties");
		FileInputStream fi = new FileInputStream(testDatapath);
		Properties p = new Properties();
		p.load(fi);
		
		driver.get(p.getProperty("URL_2"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		FileInputStream excelpath = new FileInputStream("/Users/madhubharti/Desktop/Selenium/Workspace/Maven_Project/testdata/superdry.xls");
				
		Workbook wb = Workbook.getWorkbook(excelpath);
		
		Sheet s = wb.getSheet("Sheet1");
		
		//develop the actual scripts
		driver.findElement(By.id(s.getCell(2, 2).getContents())).sendKeys(s.getCell(3, 2).getContents());
		driver.findElement(By.id(s.getCell(2, 3).getContents())).sendKeys(s.getCell(3, 3).getContents());
		driver.findElement(By.name("Submit")).click();
		
	}
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browser) {
		cfn.chromeBrowserLaunch();
		
	}
	@AfterClass
	public void afterClass() {
		
		
	}
 
}
