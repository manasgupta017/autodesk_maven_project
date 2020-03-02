package com.vtiger.crm.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.autodesk.crm.features.LoginFeature;

public class BaseLib {
	public static WebDriver driver;
	FileInputStream in;
	String userName;
	String password;
	WebDriverUtils wdu = new WebDriverUtils();
	FileLib fl = new FileLib();

	@BeforeMethod
	public void preCondition() throws IOException {
		in = new FileInputStream("./testdata/commondata.properties");
		Properties properties = new Properties();
		properties.load(in);
		String browserName = properties.getProperty("browser");
		String url = properties.getProperty("url");
		driver = BrowserFactory.launchBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		LoginFeature lf = new LoginFeature(driver);
		lf.logout();
		lf.verifyLogout();
		Reporter.log("logout verified", true);
		driver.quit();
	}

}
