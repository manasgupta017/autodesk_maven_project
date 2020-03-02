package com.autodesk.crm.features;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.autodesk.crm.pageobjects.CreatingNewOrganizationPage;
import com.autodesk.crm.pageobjects.HomePage;
import com.autodesk.crm.pageobjects.OrganizationPage;
import com.vtiger.crm.generics.FileLib;
import com.vtiger.crm.generics.WebDriverUtils;

public class OrganizationFeature {
	WebDriver driver;
	HomePage hp;
	WebDriverUtils wdu;
	FileLib fl;
	OrganizationPage op;
	CreatingNewOrganizationPage cnop;
	public OrganizationFeature(WebDriver driver) {
		this.driver = driver;
		wdu = new WebDriverUtils();
		fl = new FileLib();
		hp = new HomePage(driver);
		op = new OrganizationPage(driver);
	}

	public void clickOnOrganization() {
		hp.getOrgLink().click();
	}

	public void verifyOrgPage() {
		String expected = "Organizations";
		String actText = op.getOrgLink().getText();
		Assert.assertEquals(actText, expected);
		Reporter.log("Organization Page verified", true);
	}
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		op.getCreateOrgImg().click();
		cnop.getOrgNameTxtBx().sendKeys(fl.getExcelData("Sheet2", 1, 1));
		cnop.getSaveBtn().click();
	}
	public void verifyCreateOrgPage()
	{
		String expected = "Creating New Organization";
		String actual = cnop.getHdrText().getText();
		Assert.assertEquals(actual, expected);
	}
	public void searchForCompanyAccToOrganizationName() throws EncryptedDocumentException, IOException {
		String companyName = fl.getExcelData("Sheet2", 1, 1);
		String drpDwnOption = fl.getExcelData("Sheet2", 1, 2);
		op.getSearchBx().sendKeys(companyName);
		WebElement inDrpDwn = op.getInDrpDwn();
		wdu.selectDropDown(inDrpDwn, drpDwnOption);
		op.getSearchBx().click();
	}

	public void deleteOrganization() {
		// String delXp = "//a[text()='del']";
		boolean editFlag = op.getEditLink().isEnabled();
		boolean delFlag = op.getDelLink().isEnabled();
		if (editFlag && delFlag) {
			op.getDelLink().click();
			wdu.acceptAlert(driver);
		}

	}

	public void verifyDelOrg() throws EncryptedDocumentException, IOException {
		op.getOrgLink().click();
		String expected = fl.getExcelData("Sheet2", 1, 1);
		List<WebElement> orgLinks = op.getOrgNameLinks();
		for (WebElement webElement : orgLinks) {
			String actual = webElement.getText();
			Assert.assertNotEquals(actual, expected);
		}
		Reporter.log("Organization Deleted", true);
	}
}
