package com.autodesk.crm.features;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsEditCustomViewPage
{
	@FindBy(className="lvtHeaderText")
	private WebElement editViewHeading;
	@FindBy(className="detailedViewTextBox")
	private WebElement viewNameTxtBx;
	@FindBy(id="jscal_trigger_date_start")
	private WebElement startDateCalIcn;
	@FindBy(xpath="//div[@class='calendar']/table/tbody/tr[@class='daysrow']/td[@class='day' or @class='day weekend']")
	private List<WebElement> dateFields;
	@FindBy(xpath="//input[@value='Save'][@type='submit']")
	private WebElement saveBtn;
	@FindBy(id="jscal_field_date_start")
	private WebElement startDateField;
	public VendorsEditCustomViewPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getEditViewHeading() {
		return editViewHeading;
	}
	public WebElement getViewNameTxtBx() {
		return viewNameTxtBx;
	}
	public WebElement getStartDateCalIcn() {
		return startDateCalIcn;
	}
//	public WebElement getCalendar() {
//		return calendar;
//	}
	public List<WebElement> getDateFields() {
		return dateFields;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getStartDateField() {
		return startDateField;
	}
}
