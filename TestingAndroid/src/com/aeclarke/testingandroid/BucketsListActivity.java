package com.aeclarke.testingandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BucketsListActivity extends ActionBarredActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);

        String[] typesOfBuckets = {"Sand Castle Bucket", "Paint Bucket", "Lunch Pail"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, typesOfBuckets);

        ListView bucketList = (ListView) findViewById(R.id.bucketsListView);
        bucketList.setAdapter(adapter);
    }
}
