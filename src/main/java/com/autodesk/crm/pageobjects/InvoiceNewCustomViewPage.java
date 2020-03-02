package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceNewCustomViewPage
{
	@FindBy(className="lvtHeaderText")
	private WebElement headerTxt;
	@FindBy(xpath="//input[@value='Save'][@type='submit']")
	private WebElement saveBtn;
	public InvoiceNewCustomViewPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getHeaderTxt() {
		return headerTxt;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
