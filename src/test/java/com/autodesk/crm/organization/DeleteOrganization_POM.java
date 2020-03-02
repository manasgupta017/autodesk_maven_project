package com.autodesk.crm.organization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.autodesk.crm.features.LoginFeature;
import com.autodesk.crm.features.OrganizationFeature;
import com.vtiger.crm.generics.BaseLib;

public class DeleteOrganization_POM extends BaseLib 
{
	@Test
	public void selectParticularNameDelete() throws EncryptedDocumentException, IOException 
	{
		LoginFeature lf = new LoginFeature(driver);
		lf.login();
		lf.verifyHomePage();
		OrganizationFeature of = new OrganizationFeature(driver);
		of.clickOnOrganization();
		of.verifyOrgPage();
		of.searchForCompanyAccToOrganizationName();
		of.deleteOrganization();
		of.verifyDelOrg();
		
	}
}
