package com.liferay.integration.test;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumWaitMethods.waitMediumTime;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.liferay.gs.testFramework.SeleniumReadPropertyKeys;
import com.liferay.integration.api.CreatePageByRestAPI;
import com.liferay.integration.api.DeletePageByRestAPI;
import com.liferay.integration.api.IPageParametersByRestAPI;
import com.liferay.integration.utils.CommonMethods;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class runTest {

	CreatePageByRestAPI createPage = new CreatePageByRestAPI();
	DeletePageByRestAPI deletePage = new DeletePageByRestAPI();
	CommonMethods commonMethods = new CommonMethods();

	IPageParametersByRestAPI pageParameters = mock(IPageParametersByRestAPI.class);

	@BeforeClass
	public static void setUpClass() {
		DRIVER.get(SeleniumReadPropertyKeys.getUrlToHome());
		DRIVER.manage().window().maximize();
		DRIVER.manage().timeouts().implicitlyWait(SeleniumReadPropertyKeys.getTimeOut(), TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownClass() {
		DRIVER.close();
		waitMediumTime();
		waitMediumTime();
		waitMediumTime();
		DRIVER.quit();
	}

	@Test
	public void testCreatePageAndDeletePage() throws Exception {
		when(pageParameters.getGroupID()).thenReturn("20143");
		when(pageParameters.getIsPrivatePage()).thenReturn("false");
		when(pageParameters.getPageName()).thenReturn("test page");

		String createResult = createPage.createPage(pageParameters);
		Assert.assertThat(createResult, not(containsString("exception")));

		JSONObject findParameter = new JSONObject(createResult);
		when(pageParameters.getLayoutId()).thenReturn(findParameter.getString("layoutId"));
		String deleteResult = deletePage.deletePage(pageParameters);
		Assert.assertThat(deleteResult, not(containsString("exception")));
	}

	@Test
	public void testCreatePageDuplicatedWillFail() throws Exception {
		when(pageParameters.getGroupID()).thenReturn("20143");
		when(pageParameters.getIsPrivatePage()).thenReturn("false");
		when(pageParameters.getPageName()).thenReturn("test page");

		String result1 = createPage.createPage(pageParameters);
		Assert.assertThat(result1, not(containsString("exception")));

		String result2 = createPage.createPage(pageParameters);
		Assert.assertThat(result2, containsString("exception"));

		// Remove the page previously created
		JSONObject findParameter = new JSONObject(result1);
		when(pageParameters.getLayoutId()).thenReturn(findParameter.getString("layoutId"));
		String deleteResult = deletePage.deletePage(pageParameters);
		Assert.assertThat(deleteResult, not(containsString("exception")));

	}
}
