package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
	@FindBy(className="hdrLink")
	private WebElement invoiceHdrLink;
	@FindBy(xpath="//a[text()='Go to Advanced Search']")
	private WebElement advSearchLink;
	@FindBy(xpath="//a[text()='Create Filter']")
	private WebElement createFilterLink;
	public InvoicePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getInvoiceHdrLink() {
		return invoiceHdrLink;
	}
	public WebElement getAdvSearchLink() {
		return advSearchLink;
	}
	public WebElement getCreateFilterLink() {
		return createFilterLink;
	}
}
