package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath = "(//a[text()='Contacts'])[2]")
	private WebElement contactLink;
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactIcn;
	@FindBy(className = "lvtHeaderText")
	private WebElement newContactHeaderTxt;
	@FindBy(name = "assigned_user_id")
	private WebElement assignedToDrpDwn;
	@FindBy(xpath="//span[text()=' Administrator']/parent::td/following-sibling::td/img[contains(@src,'user')]")
	private WebElement userIcn;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCreateContactIcn() {
		return createContactIcn;
	}

	public WebElement getNewContactHeaderTxt() {
		return newContactHeaderTxt;
	}

	public WebElement getAssignedToDrpDwn() {
		return assignedToDrpDwn;
	}
	public WebElement getUserIcn() {
		return userIcn;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
}
