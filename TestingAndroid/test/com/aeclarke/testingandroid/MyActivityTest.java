package com.aeclarke.testingandroid;

import com.aeclarke.testingandroid.MainActivity;
import com.aeclarke.testingandroid.R;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MyActivityTest {

    @Test
    public void shouldHaveWelcomeText() throws Exception {
        String hello = new MainActivity().getResources().getString(R.string.main_text);
        assertThat(hello, equalTo("Welcome to Testing Android"));
    }
}
