package com.autodesk.crm.organization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.autodesk.crm.features.InvoiceFeature;
import com.autodesk.crm.features.LoginFeature;
import com.vtiger.crm.generics.BaseLib;

public class Invoice_Test_POM extends BaseLib {
	@Test(groups={"integration"})
	public void invoiceFilterCreate() throws IOException
	{
		LoginFeature lf = new LoginFeature(driver);
		InvoiceFeature ift = new InvoiceFeature(driver);
		lf.login();
		lf.verifyHomePage();
		ift.moveToMore();
		ift.clickOnInvoice();
		ift.verifyInvoicePageDisplay();
		ift.clickOnAdvSearch();
		ift.clickOnCreateFilter();
		//ift.verifyNewCustomView();
		ift.clickOnSaveBtn();
		ift.verifyAlert();
		ift.clickOnAlert();
		
		
	}
}
