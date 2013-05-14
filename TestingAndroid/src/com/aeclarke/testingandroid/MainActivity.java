package com.aeclarke.testingandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import roboguice.inject.InjectView;

public class MainActivity extends ActionBarredActivity {


    @InjectView(R.id.login_button) Button loginButton;
    @InjectView(R.id.buckets_list_button) Button contentListButton;

	private OnClickListener loginListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, LoginActivity.class);
			startActivity(intent);
		}
	};

    private OnClickListener contentListListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, BucketsListActivity.class);
            startActivity(intent);
        }
    };

    @Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		loginButton.setOnClickListener(loginListener );
        contentListButton.setOnClickListener(contentListListener);
	}
}
