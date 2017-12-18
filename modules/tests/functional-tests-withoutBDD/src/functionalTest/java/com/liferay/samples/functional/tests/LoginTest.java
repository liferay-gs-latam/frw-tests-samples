package com.liferay.samples.functional.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.samples.functional.pages.LoginPage;
import com.liferay.samples.functional.pages.WelcomePage;
import com.liferay.samples.functional.utils.FunctionalTest;

public class LoginTest extends FunctionalTest {

	private static final String liferayPortalUser = "manoel.cyreno@liferay.com";
	private static final String liferayPortalPassword = "test";
	private static final String liferayPortalUsernameAcronym = "MC";

	LoginPage loginPage = new LoginPage();
	WelcomePage welcomePage = new WelcomePage();

	@BeforeClass
	public static void setup() {
	}

	@AfterClass
	public static void tearDown() {
	}

	@Before
	public void beforeTestMethod() throws Exception {
		SeleniumReadPropertyKeys.DRIVER.get(SeleniumReadPropertyKeys.getUrlToHome());
	}

	@After
	public void afterTestMethod() throws Exception {
		SeleniumReadPropertyKeys.DRIVER
				.get(SeleniumReadPropertyKeys.getUrlToHome() + SeleniumReadPropertyKeys.getLinkToLogOut());
	}

	@Test
	public void validateIfTheLoginCanBeMadeWithSuccess() {
		loginPage.clickOnSignIn();
		loginPage.signInOnPortal(liferayPortalUser, liferayPortalPassword);
		assertTrue(welcomePage.usernameIsDisplayed(liferayPortalUsernameAcronym));
	}

	@Test
	public void validateIfTheErrorMessageAppearWhenTheBlankUserIsUsed() {
		loginPage.clickOnSignIn();
		loginPage.signInOnPortal(" ", liferayPortalPassword);
		assertTrue(loginPage.loginHelperIsDisplayed());
	}

	@Test
	public void validateIfTheErrorMessageAppearWhenTheBlankPasswordIsUsed() {
		loginPage.clickOnSignIn();
		loginPage.signInOnPortal(liferayPortalUser, " ");
		assertTrue(loginPage.passwordHelperIsDisplayed());
	}

	@Test
	public void validateIfTheErrorMessageAppearWhenTheWrongUserAndPasswordIsUsed() {
		loginPage.clickOnSignIn();
		loginPage.signInOnPortal("invalidUser", "invalidPassword");
		assertTrue(loginPage.alertErrorIsDisplayed());
	}
}