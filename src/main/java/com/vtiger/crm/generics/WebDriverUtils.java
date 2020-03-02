package com.vtiger.crm.generics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Darth_Yoda
 *
 */
public class WebDriverUtils {
	/**
	 * Will wait till elements becomes active in order to be clicked
	 * 
	 * @param element
	 * @param driver
	 */
	private Actions action;

	public void waitForElementStatus(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * waiting for the element to be visible
	 * @param element
	 * @param driver
	 * @return
	 */
	public WebElement waitForElementVisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element1 =wait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}

	/**
	 * wait for page title based on availability
	 * 
	 * @param element
	 * @param driver
	 */
	public void waitForPageTitleContains(String title, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * waits for all the elements of a page to get loaded
	 * 
	 * @param driver
	 */
	public void waitForElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * handles the drop down
	 * 
	 * @param drpDwn
	 * @param text
	 */
	public void selectDropDown(WebElement drpDwn, String text) {
		Select sel = new Select(drpDwn);
		sel.selectByVisibleText(text);
	}
	
	public void selectDropDownByValue(WebElement drpDwn, String text) {
		Select sel = new Select(drpDwn);
		sel.selectByValue(text);
	}

	/**
	 * moves mouse control to the respective element.
	 * 
	 * @param element
	 * @param driver
	 */

	public void moveToElement(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	/**
	 * double click on the element
	 * 
	 * @param element
	 * @param driver
	 */
	public void doubleClick(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
		;
	}

	/**
	 * right click on the target WebElement
	 * 
	 * @param element
	 * @param driver
	 */
	public void rightClick(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * drags the slider element if available on a page
	 * 
	 * @param element
	 * @param driver
	 * @param xOffset
	 * @param yOffset
	 */
	public void rangeSlider(WebElement element, WebDriver driver, int xOffset, int yOffset) {
		action = new Actions(driver);
		action.clickAndHold(element).perform();
		action.moveByOffset(xOffset, yOffset).perform();
		action.release(element).perform();

	}

	/**
	 * drag the sourceElement to targetElement
	 * 
	 * @param sourceElement
	 * @param targetElement
	 * @param driver
	 */
	public void dragAndDrop(WebElement sourceElement, WebElement targetElement, WebDriver driver) {
		action = new Actions(driver);
		action.clickAndHold(sourceElement).perform();
		action.dragAndDrop(sourceElement, targetElement).perform();
		action.release(sourceElement).perform();
	}

	/**
	 * switch the driver control to the desired window whose title is passed as
	 * argument.
	 * 
	 * @param driver
	 * @param pageTitle
	 */
	public void switchToTab(WebDriver driver, String pageTitle) {
		Set<String> tabs = driver.getWindowHandles();// Uses LinkedHashSet
		Iterator<String> itr = tabs.iterator();
		while (itr.hasNext()) {
			driver.switchTo().window(itr.next());
			String actTitle = driver.getTitle();
			if (pageTitle.equalsIgnoreCase(actTitle)) {
				break;
			}
		}
	}

	/**
	 * clicks on the accept button of alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * clicks on the dismiss button of alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

}
