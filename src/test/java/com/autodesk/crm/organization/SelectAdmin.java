package com.autodesk.crm.organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.vtiger.crm.generics.BrowserFactory;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class SelectAdmin {
	WebDriver driver;
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
		userName = properties.getProperty("username");
		password = properties.getProperty("password");
		driver = BrowserFactory.launchBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		verifyHomePage();
		System.out.println("Home Page Verified");
	}

	@Test
	public void createContactWithAdministrator() throws EncryptedDocumentException, IOException {
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		verifyContactPage();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		verifyCreateNewContactPage();
		WebElement assignedToDrpDwn = driver.findElement(By.name("assigned_user_id"));
		String text = fl.getExcelData("Sheet2", 2, 1);
		wdu.selectDropDown(assignedToDrpDwn, text);
		verifyAssignToDropDown();

	}

	public void verifyContactPage() {
		String expected = "Contacts";
		String actual = driver.findElement(By.xpath("(//a[text()='Contacts'])[2]")).getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Contact Page Verified", true);

	}

	public void verifyCreateNewContactPage() {
		String expected = "Creating New Contact";
		String actual = driver.findElement(By.className("lvtHeaderText")).getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Creating New Contact Verified", true);
	}

	public void verifyHomePage() {
		String expectedText = "Home";
		String actText = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText().trim();
		Assert.assertEquals(actText, expectedText);
	}

	public void verifyAssignToDropDown() {
		boolean expected = true;
		boolean actual = driver.findElement(By.name("assigned_user_id")).isDisplayed();
		Assert.assertEquals(actual, expected);
		Reporter.log("Dropdown is displayed: Verified", true);
	}
	public void verifyLogout()
	{
		boolean expected = true;
		boolean actual = driver.findElement(By.xpath("//input[@value='Login'][@id='submitButton']")).isDisplayed();
		Assert.assertEquals(actual, expected);
		Reporter.log("Login Page is verified", true);
	}
	@AfterMethod
	public void tearDown() {

		WebElement element = driver.findElement(By
				.xpath("//span[text()=' Administrator']/parent::td/following-sibling::td/img[contains(@src,'user')]"));
		wdu.moveToElement(element, driver);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		verifyLogout();
		driver.quit();
	}
}
