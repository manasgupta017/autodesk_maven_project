package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	@FindBy(xpath="//table[@class='small']//td[@class='moduleName']/a[text()='Leads']")
	private WebElement leadMainLink;
	@FindBy(id="qccombo")
	private WebElement quickCreateDrpDwn;
	@FindBy(name="QcEditView")
	private WebElement createLeadForm;
	@FindBy(name="company")
	private WebElement companyTxtBx;
	@FindBy(name="lastname")
	private WebElement lastNameTxtBx;
	@FindBy(xpath="//input[@name='button'][@type='submit']")
	private WebElement saveBtn;
	@FindBy(xpath="//table[@class='qcTransport']//input[@value='  Cancel  ']")
	private WebElement cancelBtn;
	public LeadPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLeadMainLink() {
		return leadMainLink;
	}
	public WebElement getQuickCreateDrpDwn() {
		return quickCreateDrpDwn;
	}
	public WebElement getCreateLeadForm() {
		return createLeadForm;
	}
	public WebElement getCompanyTxtBx() {
		return companyTxtBx;
	}
	public WebElement getLastNameTxtBx() {
		return lastNameTxtBx;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCancelBtn() {
		return cancelBtn;
	}
}
