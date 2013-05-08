package com.aeclarke.testingandroid;

import android.content.Intent;
import android.widget.Button;

import com.aeclarke.testingandroid.MainActivity;
import com.aeclarke.testingandroid.R;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.robolectric.Robolectric.shadowOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

	private MainActivity activity;
	private Button loginButton;
	
    @Before
    public void setUp() throws Exception {
    	activity = new MainActivity();
    	activity.onCreate(null);
    	loginButton = (Button) activity.findViewById(R.id.login_button);
    }
	
	@Test
    public void shouldHaveWelcomeText() throws Exception {
        String hello = activity.getResources().getString(R.string.main_text);
        assertThat(hello, equalTo("Welcome to Testing Android"));
    }
   
	@Test
	public void pressingTheLoginButtonShouldNavigateToLoginActivity() throws Exception {
		loginButton.performClick();
		
		ShadowActivity shadowActivity = shadowOf(activity);
		Intent startedIntent = shadowActivity.getNextStartedActivity();
		ShadowIntent shadowIntent = shadowOf(startedIntent);
		
		assertThat(shadowIntent.getComponent().getClassName(), equalTo(LoginActivity.class.getName()));
	}
    
}
