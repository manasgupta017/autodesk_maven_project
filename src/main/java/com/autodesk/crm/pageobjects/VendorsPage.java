package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage
{
	@FindBy(xpath="//a[@class='hdrLink']")
	private WebElement vendorMainLink;
	@FindBy(id="viewname")
	private WebElement filtersDrpDwn;
	@FindBy(xpath="//a[text()='Edit']")
	private WebElement filterEditLink;
	public VendorsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getVendorMainLink() {
		return vendorMainLink;
	}
	public WebElement getFiltersDrpDwn() {
		return filtersDrpDwn;
	}
	public WebElement getFilterEditLink() {
		return filterEditLink;
	}
}
