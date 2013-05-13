package com.aeclarke.testingandroid;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MainActivityTest extends UiAutomatorTestCase {
	
	public void testMainActivity() throws UiObjectNotFoundException {
		getUiDevice().pressHome();
		
		UiObject allAppsButton = new UiObject(new UiSelector().description("All apps"));
		allAppsButton.clickAndWaitForNewWindow();

		UiObject settingsApp = new UiObject(new UiSelector().text("TestingAndroid"));
		settingsApp.clickAndWaitForNewWindow();

        UiObject loginButton = new UiObject(new UiSelector().text("Login"));
        loginButton.clickAndWaitForNewWindow();

		UiObject loginText = new UiObject(new UiSelector().text("Enter your username"));
		assertTrue("Some error", loginText.exists());
	}
}
