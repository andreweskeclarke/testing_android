package com.aeclarke.testingandroid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import roboguice.inject.InjectView;

public class BucketsListActivity extends ActionBarredActivity {

    @InjectView(R.id.bucketsListView) ListView bucketList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);

        String[] typesOfBuckets = {"Sand Castle Bucket", "Paint Bucket", "Lunch Pail"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, typesOfBuckets);

        bucketList.setAdapter(adapter);
    }
}
