package com.TestScenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Utilities.CommonFunctions;
import com.Utilities.StaticVariables;

public class shearcircle extends StaticVariables{
  CommonFunctions cfn = new CommonFunctions();
	
	@Test
  public void f() {
		
		cfn.chromeBrowserLaunch();
		driver.navigate().to("https://shearcircle.com/");
		
		//WebElement ele = driver.findElement(By.linkText("Sign Up"));
		
		//Javascriptexecutor for click operation
		
		//((JavascriptExecutor)driver).executeScript("arguments[0].click()", ele);
		
		cfn.clickUsingJavaScriptExecutor(By.linkText("Sign Up"));
  }
}
