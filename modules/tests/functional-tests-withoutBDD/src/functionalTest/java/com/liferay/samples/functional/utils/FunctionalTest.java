package com.liferay.samples.functional.utils;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.liferay.samples.functional.testsSuite.runAllTests;

public abstract class FunctionalTest {

		@AfterClass
		public static void afterClass() throws Exception {
			runAllTests.closeDriver();
		}

		@After
		public final void takeScreenshot() {
			if (DRIVER instanceof TakesScreenshot) {
				_screenshot = ((TakesScreenshot)DRIVER).getScreenshotAs(OutputType.BYTES);
			}
		}

		@Rule
		public TestWatcher writeScreenshotOnFailure = new TestWatcher() {

			protected void failed(Throwable e, Description description) {
				if (_screenshot == null) {
					return;
				}

				String fileName = description.getClassName() + "." + description.getMethodName() + ".png";

				try {
					FileUtils.writeByteArrayToFile(new File(_SCREENSHOTS_DIR, fileName), _screenshot);
				}
				catch (IOException ioe) {
					ioe.printStackTrace();
				}
			};

		};

		private static final String _SCREENSHOTS_DIR = "build/test-results/functionalTest/attachments/";

		private byte[] _screenshot = null;

	}