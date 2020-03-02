package com.autodesk.crm.features;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.pageobjects.HomePage;
import com.autodesk.crm.pageobjects.LoginPage;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class LoginFeature {
	WebDriver driver;
	LoginPage lp;
	Properties properties;
	FileInputStream in;
	String userName;
	String password;
	WebDriverUtils wdu = new WebDriverUtils();
	FileLib fl = new FileLib();
	HomePage hp;

	public LoginFeature(WebDriver driver) {
		this.driver = driver;
		this.lp = new LoginPage(driver);
		this.hp = new HomePage(driver);
	}

	public void login() throws IOException {
		in = new FileInputStream("./testdata/commondata.properties");
		properties = new Properties();
		properties.load(in);
		userName = properties.getProperty("username");
		password = properties.getProperty("password");
		lp.getUserNameTxtBx().sendKeys(userName);
		lp.getPasswordTxtBx().sendKeys(password);
		lp.getLoginBtn().click();
	}

	public void verifyHomePage() {
		String expectedText = "Home";//read from .xlsx
		String actText = hp.getHomeLink().getText().trim();
		Assert.assertEquals(actText, expectedText);
		Reporter.log("Home Page is verified", true);
	}

	public void logout() {
		WebElement element = hp.getUserIcn();
		wdu.moveToElement(element, driver);
		hp.getSignOutLink().click();
	}

	public void verifyLogout() {
		boolean expected = true;
		boolean actual = lp.getLoginBtn().isDisplayed();
		Assert.assertEquals(actual, expected);
		Reporter.log("Login Page is verified", true);
	}

}
