package com.autodesk.crm.organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.crm.generics.BrowserFactory;

public class ParameterTest {
	WebDriver driver;
	
	@Parameters({"browserName","baseurl"})
	@BeforeMethod
	public void preCond(String browser , String url)
	{
		driver = BrowserFactory.launchBrowser(browser);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
	}
	@Test
	public void testingCrossVrowser()
	{
		Reporter.log("Cross Browser ", true);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
