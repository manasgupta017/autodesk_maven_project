package com.autodesk.crm.features;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.pageobjects.ContactPage;
import com.autodesk.crm.pageobjects.HomePage;
import com.autodesk.crm.pageobjects.LoginPage;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class ContactFeature {
	WebDriver driver;
	HomePage hp;
	WebDriverUtils wdu;
	FileLib fl;
	ContactPage cp;
	LoginPage lp;
	public ContactFeature(WebDriver driver) 
	{
		this.driver = driver;
		hp= new HomePage(driver);
		wdu = new WebDriverUtils();
		fl = new FileLib();
		cp = new ContactPage(driver);
		this.lp = new LoginPage(driver);
	}
	
	public void clickOnContact()
	{
		hp.getContactLink().click();
	}
	public void verifyContactPage() throws EncryptedDocumentException, IOException
	{
		String expected = fl.getExcelData("Sheet2", 2, 2);
		String actual = cp.getContactLink().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Contact Page Verified", true);
	}
	public void clickOnCreateNewContact()
	{
		cp.getCreateContactIcn().click();
	}
	
	public void verifyCreateNewContactPage() throws EncryptedDocumentException, IOException {
		String expected = fl.getExcelData("Sheet2", 2, 3);
		String actual = cp.getNewContactHeaderTxt().getText();
		Assert.assertEquals(actual, expected);
		Reporter.log("Creating New Contact Verified", true);
	}
	public void selectAdminFrmDrpDwn() throws EncryptedDocumentException, IOException
	{
		WebElement assignedToDrpDwn = cp.getAssignedToDrpDwn();
		String text = fl.getExcelData("Sheet2", 2, 1);
		wdu.selectDropDown(assignedToDrpDwn, text);
	}

	public void verifyAssignToDropDown() {
		boolean expected = true;
		boolean actual = cp.getAssignedToDrpDwn().isDisplayed();
		Assert.assertEquals(actual, expected);
		Reporter.log("Dropdown is displayed: Verified", true);
	}
	/*public void logout()
	{
		WebElement element = cp.getUserIcn();
		wdu.moveToElement(element, driver);
		cp.getSignOutLink().click();
	}
	public void verifyLogOut()
	{
		boolean expected = true;
		boolean actual =lp.getLoginBtn().isDisplayed();
		Assert.assertEquals(actual, expected);
		Reporter.log("Logout is verified", true);
	}*/
}
