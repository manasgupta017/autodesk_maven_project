package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	
	@FindBy(className="lvtHeaderText")
	private WebElement hdrText;
	@FindBy(name="accountname")
	private WebElement orgNameTxtBx;
	@FindBy(className="crmbutton small save")
	private WebElement saveBtn;
	public CreatingNewOrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getHdrText() {
		return hdrText;
	}
	public WebElement getOrgNameTxtBx() {
		return orgNameTxtBx;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
