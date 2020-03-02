package com.autodesk.crm.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.autodesk.crm.features.ContactFeature;
import com.autodesk.crm.features.LoginFeature;
import com.vtiger.crm.generics.BaseLib;

public class SelectAdmin_POM extends BaseLib{
	
	@Test
	public void createContactWithAdministrator() throws EncryptedDocumentException, IOException {
		LoginFeature lf = new LoginFeature(driver);
		ContactFeature cf = new ContactFeature(driver);
		lf.login();
		lf.verifyHomePage();
		cf.clickOnContact();
		cf.verifyContactPage();
		cf.clickOnCreateNewContact();
		cf.verifyCreateNewContactPage();
		cf.selectAdminFrmDrpDwn();
		cf.verifyAssignToDropDown();
//		cf.logout();
//		cf.verifyLogOut();
	}
}
