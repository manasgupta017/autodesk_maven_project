package com.autodesk.crm.organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.vtiger.crm.generics.BrowserFactory;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class DeleteOrganization {
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
	public void selectParticularNameDelete() throws EncryptedDocumentException, IOException {
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		verifyOrganizationPage();
		/*
		 * String chkBxXp
		 * ="//table[@class='lvt small']/tbody/tr[3]/td[1]/input";
		 * driver.findElement(By.xpath(chkBxXp));
		 */

		String companyName = fl.getExcelData("Sheet2", 1, 1);
		String drpDwnOption = fl.getExcelData("Sheet2", 1, 2);
		driver.findElement(By.name("search_text")).sendKeys(companyName);
		WebElement inDrpDwn = driver.findElement(By.id("bas_searchfield"));
		wdu.selectDropDown(inDrpDwn, drpDwnOption);
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[1]")).click();
		String delXp = "//a[text()='del']";
		boolean editFlag = driver.findElement(By.xpath("//a[text()='edit']")).isEnabled();
		boolean delFlag = driver.findElement(By.xpath(delXp)).isEnabled();
		if(editFlag && delFlag)
		{
			driver.findElement(By.xpath(delXp)).click();
			wdu.acceptAlert(driver);
		}
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		verifyDelOrg();
	}

	public void verifyHomePage() {
		String expectedText = "Home";
		String actText = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText().trim();
		Assert.assertEquals(actText, expectedText);
	}
	public void verifyDelOrg() throws EncryptedDocumentException, IOException
	{
		String expected = fl.getExcelData("Sheet2", 1, 1);
		List<WebElement> orgLinks = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for (WebElement webElement : orgLinks) {
			String actual = webElement.getText();
			Assert.assertNotEquals(actual, expected);
		}
	}
	public void verifyOrganizationPage() {
		String expected = "Organizations";
		String actText = driver.findElement(By.xpath("(//a[text()='Organizations'])[2]")).getText();
		Assert.assertEquals(actText, expected);
		System.out.println("Organizations Page Verified");
	}

	@AfterMethod
	public void tearDown() {

		WebElement element = driver.findElement(By
				.xpath("//span[text()=' Administrator']/parent::td/following-sibling::td/img[contains(@src,'user')]"));
		wdu.moveToElement(element, driver);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}

}
