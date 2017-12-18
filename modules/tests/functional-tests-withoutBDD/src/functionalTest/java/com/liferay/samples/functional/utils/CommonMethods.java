package com.liferay.samples.functional.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.SeleniumWaitMethods;

public class CommonMethods {

	public void waitElementAppearOnScreen(By locator) {
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.presenceOfElementLocated(locator));
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitElementVisibilityAndBeClickable(By locator) {
		waitElementAppearOnScreen(locator);
		SeleniumWaitMethods.getWaitDriver().until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void input(By locator, String text) {
		waitElementVisibilityAndBeClickable(locator);
		SeleniumReadPropertyKeys.DRIVER.findElement(locator).clear();
		SeleniumReadPropertyKeys.DRIVER.findElement(locator).sendKeys(text);
	}
}
