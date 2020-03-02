package com.autodesk.crm.features;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.autodesk.crm.pageobjects.HomePage;
import com.autodesk.crm.pageobjects.VendorsPage;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class VendorFeature {
	WebDriver driver;
	WebDriverUtils wdu;
	FileLib fl;
	HomePage hp;
	VendorsPage vp;
	VendorsEditCustomViewPage vecvp;

	public VendorFeature(WebDriver driver) {
		this.driver = driver;
		wdu = new WebDriverUtils();
		fl = new FileLib();
		hp = new HomePage(driver);
		vp = new VendorsPage(driver);
		vecvp = new VendorsEditCustomViewPage(driver);
	}

	public void mouseOverToMore() {
		wdu.moveToElement(hp.getMoreLink(), driver);

	}

	public void clickOnVendors() {
		hp.getVendorLink().click();
	}

	public void verifyVendorPage() throws EncryptedDocumentException, IOException {
		String expected = fl.getExcelData("Sheet2", 4, 1);
		String actual = vp.getVendorMainLink().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Vendor Page is verified ", true);
	}

	public void clickOnFilterDropDown() throws EncryptedDocumentException, IOException {
		WebElement filtersDrpDwn = vp.getFiltersDrpDwn();
		String selectedFilter = fl.getExcelData("Sheet2", 4, 2);
		wdu.selectDropDown(filtersDrpDwn, selectedFilter);
		
	}
	public void clickOnFilterEdit()
	{
		WebElement filterEdit = vp.getFilterEditLink();
		wdu.waitForElementStatus(filterEdit, driver);
		filterEdit.click();
	}
	public void verifyFilterEditView() throws EncryptedDocumentException, IOException {
		String expected = fl.getExcelData("Sheet2", 4, 3);
		String actual = vecvp.getEditViewHeading().getText().trim();
		Assert.assertEquals(actual, expected);
		Reporter.log("Edit Custom View page displayed", true);
		String expectedFilterName = fl.getExcelData("Sheet2", 4, 2);
		String actualFilterName = vecvp.getViewNameTxtBx().getAttribute("value");

		Assert.assertEquals(actualFilterName, expectedFilterName);
		Reporter.log("selected  filter name in Filters  dropdown menu", true);
	}
	public void clickOnStartDate()
	{
		vecvp.getStartDateCalIcn().click();
		
	}
	public void selectDateAndSave() throws EncryptedDocumentException, IOException
	{
		String dateInNum = fl.getExcelData("Sheet2", 4, 4);
		List<WebElement> dateFileds = vecvp.getDateFields();
		for (WebElement date : dateFileds) {
			if(date.getText().equals(dateInNum))
			{
				date.click();
			}
		}
		vecvp.getSaveBtn().click();
	}
	public void verifyDate() throws EncryptedDocumentException, IOException
	{
		String actual = vecvp.getStartDateField().getAttribute("value");
		String expected = fl.getExcelData("Sheet2", 4, 5);
		Assert.assertEquals(actual, expected);
//		SoftAssert sa = new SoftAssert();
//		sa.assertEquals(actual, expected);
//		sa.assertAll();//stop the exe
		Reporter.log("Filter start date verified", true);
	}
	
}
