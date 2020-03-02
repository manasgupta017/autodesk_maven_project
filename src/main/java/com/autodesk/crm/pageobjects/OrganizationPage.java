package com.autodesk.crm.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
	@FindBy(xpath="(//a[text()='Organizations'])[2]")
	private WebElement orgLink;
	@FindBy(name="search_text")
	private WebElement searchBx;
	@FindBy(id="bas_searchfield")
	private WebElement inDrpDwn;
	@FindBy(xpath="(//input[@value=' Search Now '])[1]")
	private WebElement searchNowBtn;
	@FindBy(xpath="//a[text()='del']")
	private WebElement delLink;
	@FindBy(xpath="//a[text()='edit']")
	private WebElement editLink;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[3]/a")
	private List<WebElement> orgNameLinks;
	@FindBy
	private WebElement createOrgImg;
	public OrganizationPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getSearchBx() {
		return searchBx;
	}
	public WebElement getInDrpDwn() {
		return inDrpDwn;
	}
	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	public WebElement getDelLink() {
		return delLink;
	}
	public WebElement getEditLink() {
		return editLink;
	}
	public List<WebElement> getOrgNameLinks() {
		return orgNameLinks;
	}
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
}
