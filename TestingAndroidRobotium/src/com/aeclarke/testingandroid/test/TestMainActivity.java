package com.aeclarke.testingandroid.test;

import android.test.ActivityInstrumentationTestCase2;

import com.aeclarke.testingandroid.MainActivity;
import com.jayway.android.robotium.solo.Solo;

import junit.framework.TestCase;

public class TestMainActivity extends ActivityInstrumentationTestCase2<MainActivity>{
	private Solo solo;
	
	public TestMainActivity(){ 
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	public void testNavigatingToLogin() {
		solo.clickOnButton("Login");
        solo.waitForText("Login Screen");
        assertEquals("Login Screen", solo.getText("Login Screen").getText());
	}

	protected void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

}
