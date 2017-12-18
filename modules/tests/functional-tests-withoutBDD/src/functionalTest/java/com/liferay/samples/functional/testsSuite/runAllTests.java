package com.liferay.samples.functional.testsSuite;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumWaitMethods.waitMediumTime;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.ClasspathSuite.ClassnameFilters;
import org.junit.runner.RunWith;

@ClassnameFilters({"tests.*", ".*Test"})
@RunWith(ClasspathSuite.class)
public class runAllTests {

	public static Boolean runnedFromAllTestsSuite = false;

	@AfterClass
	public static void afterClass() throws Exception {
		runnedFromAllTestsSuite = false;
		closeDriver();
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		runnedFromAllTestsSuite = true;
	}

	public static void closeDriver() {
		if (runnedFromAllTestsSuite == false) {
			DRIVER.close();
			waitMediumTime();
			waitMediumTime();
			waitMediumTime();
			DRIVER.quit();
		}
	}

}