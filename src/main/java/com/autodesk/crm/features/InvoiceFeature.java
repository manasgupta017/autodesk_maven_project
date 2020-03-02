package com.autodesk.crm.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.pageobjects.HomePage;
import com.autodesk.crm.pageobjects.InvoiceNewCustomViewPage;
import com.autodesk.crm.pageobjects.InvoicePage;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class InvoiceFeature {
	WebDriver driver;
	WebDriverUtils wdu;
	FileLib fl;
	HomePage hp;
	InvoicePage ip;
	InvoiceNewCustomViewPage incvp;

	public InvoiceFeature(WebDriver driver) {
		this.driver = driver;
		wdu = new WebDriverUtils();
		fl = new FileLib();
		hp = new HomePage(driver);
		ip = new InvoicePage(driver);
		incvp = new InvoiceNewCustomViewPage(driver);
	}

	public void moveToMore() {
		wdu.moveToElement(hp.getMoreLink(), driver);
	}

	public void clickOnInvoice() {
		hp.getInvoiceLink().click();
	}

	public void verifyInvoicePageDisplay() throws EncryptedDocumentException, IOException {
		String expected = fl.getExcelData("Sheet2", 5, 1);
		String actual = ip.getInvoiceHdrLink().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Invoice Page Verified", true);
	}

	public void clickOnAdvSearch() {
		ip.getAdvSearchLink().click();
	}

	public void clickOnCreateFilter() {
		ip.getCreateFilterLink().click();
	}

	public void verifyNewCustomView() throws EncryptedDocumentException, IOException {
		String expected = fl.getExcelData("Sheet2", 5, 2);
		String actual = incvp.getHeaderTxt().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("New Custome View Verified", true);
	}
	public void clickOnSaveBtn()
	{
		incvp.getSaveBtn().click();
	
	}
	public void verifyAlert()
	{
		boolean actual = driver.switchTo().alert().getText().contains("Missing required fields:");
		boolean expected = true;
		Assert.assertEquals(actual, expected);
		Reporter.log("Alert Message is Verified", true);
	}
	public void clickOnAlert()
	{
		wdu.acceptAlert(driver);
	}

}
