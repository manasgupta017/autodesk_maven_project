package com.autodesk.crm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "user_name")
	private WebElement userNameTxtBx;

	@FindBy(name = "user_password")
	private WebElement passwordTxtBx;

	@FindBy(xpath="//input[@value='Login'][@id='submitButton']")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameTxtBx() {
		return userNameTxtBx;
	}

	public WebElement getPasswordTxtBx() {
		return passwordTxtBx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
