package com.aeclarke.testingandroid;

import android.os.RemoteException;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class MainActivityTest extends UiAutomatorTestCase {
	
	public void testMainActivity() throws UiObjectNotFoundException, RemoteException {
        getUiDevice().wakeUp();
        getUiDevice().swipe(100, 100, 100, 200, 1);
        getUiDevice().pressHome();
        getUiDevice().pressHome();
        getUiDevice().pressHome();

		UiObject allAppsButton = new UiObject(new UiSelector().description("All apps"));
		allAppsButton.clickAndWaitForNewWindow();

        UiScrollable appViews = new UiScrollable(new UiSelector().scrollable(true));

        UiObject testingAndroidApp = appViews.getChildByText(new UiSelector().className(android.widget.TextView.class.getName()),"TestingAndroid");
        testingAndroidApp.clickAndWaitForNewWindow();

        UiObject loginButton = new UiObject(new UiSelector().text("Login"));
        loginButton.clickAndWaitForNewWindow();

		UiObject loginText = new UiObject(new UiSelector().text("Login Screen"));
		assertTrue("Could not find correct login title", loginText.exists());
	}
}
