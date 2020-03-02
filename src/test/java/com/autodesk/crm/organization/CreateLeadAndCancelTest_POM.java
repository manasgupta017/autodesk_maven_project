package com.autodesk.crm.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.crm.features.LeadFeatures;
import com.autodesk.crm.features.LoginFeature;
import com.vtiger.crm.generics.BaseLib;

public class CreateLeadAndCancelTest_POM extends BaseLib
{
	@Test
	public void createLeadandCancel() throws IOException
	{
		LeadFeatures leF = new LeadFeatures(driver);
		LoginFeature lf = new LoginFeature(driver);
		lf.login();
		lf.verifyHomePage();
		leF.clickOnLeads();
		leF.verifyLeadsPage();
		leF.clickOnQuickCreate();
		leF.verifyVisiblilityOfForm();
		leF.enterMandatoryData();
		leF.clickCancel();
		leF.verifyLeadsPage();
	}
}
