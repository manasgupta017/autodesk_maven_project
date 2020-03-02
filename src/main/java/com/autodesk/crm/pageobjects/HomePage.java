package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	private WebElement homeLink;

	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement orgLink;

	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactLink;

	@FindBy(xpath = "//span[text()=' Administrator']/parent::td/following-sibling::td/img[contains(@src,'user')]")
	private WebElement userIcn;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLink;

	@FindBy(xpath = "//div[@id='miniCal']/following-sibling::table//td[@class='small']//a[text()='Leads']")
	private WebElement leadsLink;

	@FindBy(xpath = "//div[@id='miniCal']/following-sibling::table//td[@class='tabSelected']/following-sibling::td/table//a[contains(text(),'More')]")
	private WebElement moreLink;

	@FindBy(xpath = "//a[text()='Vendors']")
	private WebElement vendorLink;

	@FindBy(name="Invoice")
	private WebElement invoiceLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getUserIcn() {
		return userIcn;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getVendorLink() {
		return vendorLink;
	}
	public WebElement getInvoiceLink() {
		return invoiceLink;
	}
}
