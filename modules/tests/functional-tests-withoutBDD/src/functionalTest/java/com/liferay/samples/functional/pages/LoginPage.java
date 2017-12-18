package com.liferay.samples.functional.pages;

import org.openqa.selenium.By;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.utils.CommonMethods;

public class LoginPage {

	CommonMethods commonMethods = new CommonMethods();

	private final By signInLocator = By.xpath(
			".//*[@id='p_p_id_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_']");
	private final By emailAddressLocator = By.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_login']");
	private final By passwordLocator = By.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_password']");
	private final By signInButtonOnModalLocator = By
			.xpath(".//*[contains(@id, '_com_liferay_login_web_portlet_LoginPortlet') and contains(@type, 'submit')]");

	private final By alertErrorLocator = By.xpath(
			".//*[contains(@class, 'alert-danger') and contains(@class, 'alert-danger-content') and contains(@class, 'liferayalert')]");
	private final By loginHelperLocator = By
			.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_loginHelper']");
	private final By passwordHelperLocator = By
			.xpath(".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_passwordHelper']");

	public void fillEmailAddressField(String userLogin) {
		commonMethods.input(emailAddressLocator, userLogin);
	}

	public void fillPasswordField(String userPassword) {
		commonMethods.input(passwordLocator, userPassword);
	}

	public void clickOnSignIn() {
		commonMethods.waitElementVisibilityAndBeClickable(signInLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(signInLocator).click();
	}

	public void clickOnSignInOfTheModal() {
		commonMethods.waitElementVisibilityAndBeClickable(signInButtonOnModalLocator);
		SeleniumReadPropertyKeys.DRIVER.findElement(signInButtonOnModalLocator).click();
	}

	public boolean alertErrorIsDisplayed() {
		commonMethods.waitElementAppearOnScreen(alertErrorLocator);
		return SeleniumReadPropertyKeys.DRIVER.findElement(alertErrorLocator).isDisplayed();
	}

	public boolean loginHelperIsDisplayed() {
		commonMethods.waitElementAppearOnScreen(loginHelperLocator);
		return SeleniumReadPropertyKeys.DRIVER.findElement(loginHelperLocator).isDisplayed();
	}

	public boolean passwordHelperIsDisplayed() {
		commonMethods.waitElementAppearOnScreen(passwordHelperLocator);
		return SeleniumReadPropertyKeys.DRIVER.findElement(passwordHelperLocator).isDisplayed();
	}
	
	public void signInOnPortal(String emailAddress, String password) {
		fillEmailAddressField(emailAddress);
		fillPasswordField(password);
		clickOnSignInOfTheModal();
	}


}