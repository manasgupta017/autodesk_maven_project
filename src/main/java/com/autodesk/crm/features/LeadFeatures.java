package com.autodesk.crm.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.pageobjects.HomePage;
import com.autodesk.crm.pageobjects.LeadPage;
import com.autodesk.crm.pageobjects.LoginPage;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class LeadFeatures
{
	WebDriver driver;
	HomePage hp;
	WebDriverUtils wdu;
	FileLib fl;
	LoginPage lp;
	LeadPage lep;
	public LeadFeatures(WebDriver driver) 
	{
		this.driver = driver;
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		lep = new LeadPage(driver);
		fl = new FileLib();
		wdu = new WebDriverUtils();
	}
	public void clickOnLeads()
	{
		hp.getLeadsLink().click();
	}
	public void verifyLeadsPage() throws EncryptedDocumentException, IOException
	{
		String expected = fl.getExcelData("Sheet2",3, 1);
		String actual = lep.getLeadMainLink().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Leads Page Verified", true);
	}
	public void clickOnQuickCreate() throws EncryptedDocumentException, IOException
	{
		WebElement qcDrpDwn = lep.getQuickCreateDrpDwn();
		String value = fl.getExcelData("Sheet2", 3, 1);
		wdu.selectDropDownByValue(qcDrpDwn, value);
		WebElement form = lep.getCreateLeadForm();
		wdu.waitForElementVisibility(form, driver);
		
	}
	public void verifyVisiblilityOfForm()
	{
		boolean expected = true;
		boolean actual = lep.getCreateLeadForm().isDisplayed();
		Assert.assertEquals(actual, expected);
		Reporter.log("Create Lead Form is Visible ", true);
	}
	public void enterMandatoryData() throws EncryptedDocumentException, IOException
	{
		String company = fl.getExcelData("Sheet2", 3, 3);
		lep.getCompanyTxtBx().sendKeys(company);
		String lastName = fl.getExcelData("Sheet2", 3, 2);
		lep.getLastNameTxtBx().sendKeys(lastName);
		
	}
	public void clickCancel()
	{
		lep.getCancelBtn().click();	
	}
}
