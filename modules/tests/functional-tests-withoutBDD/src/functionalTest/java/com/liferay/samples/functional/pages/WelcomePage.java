package com.liferay.samples.functional.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.gs.testFramework.SeleniumWaitMethods;
import com.liferay.samples.functional.utils.CommonMethods;

public class WelcomePage {

	CommonMethods commonMethods = new CommonMethods();

	public boolean usernameIsDisplayed(String usernameAcronym) {
		By usernameAcronymLocator = By.xpath(
				".//*[contains(@id, 'p_p_id_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_')]//*[contains(text(), '"
						+ usernameAcronym + "')]");

		SeleniumWaitMethods.getWaitDriver()
				.until(ExpectedConditions.visibilityOfElementLocated(usernameAcronymLocator));

		return SeleniumReadPropertyKeys.DRIVER.findElement(usernameAcronymLocator).isDisplayed();
	}
}
