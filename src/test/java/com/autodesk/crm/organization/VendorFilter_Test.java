package com.autodesk.crm.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.crm.features.LoginFeature;
import com.autodesk.crm.features.VendorFeature;
import com.vtiger.crm.generics.BaseLib;

public class VendorFilter_Test extends BaseLib{
	@Test
	public void testVendorFilter() throws IOException
	{
		VendorFeature vf = new VendorFeature(driver);
		LoginFeature lf = new LoginFeature(driver);
		lf.login();
		lf.verifyHomePage();
		vf.mouseOverToMore();
		vf.clickOnVendors();
		vf.verifyVendorPage();
		vf.clickOnFilterDropDown();
		vf.clickOnFilterEdit();
		vf.verifyFilterEditView();
		vf.clickOnStartDate();
		vf.selectDateAndSave();
		vf.verifyVendorPage();
		vf.clickOnFilterEdit();
		vf.verifyFilterEditView();
		vf.verifyDate();
		
	}
}
