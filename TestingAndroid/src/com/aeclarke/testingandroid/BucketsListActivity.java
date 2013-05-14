package com.aeclarke.testingandroid;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import roboguice.inject.InjectView;

public class BucketsListActivity extends ActionBarredActivity {

    @InjectView(R.id.bucketsListView) ListView bucketTypesList;
    @InjectView(R.id.buckets_list_id) ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_list);
        String[] typesOfBuckets = {};

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadTypesOfBucketsTask().execute("buckets_url");
        } else {
            typesOfBuckets = new String[]{"No Network Bucket"};
            populateBucketTypesList(typesOfBuckets);
        }
    }

    private void populateBucketTypesList(String[] typesOfBuckets) {
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, typesOfBuckets);
        bucketTypesList.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
        bucketTypesList.setAdapter(adapter);
    }

    private class DownloadTypesOfBucketsTask extends AsyncTask<String, Void, String[]>{
        @Override
        protected String[] doInBackground(String... objects) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new String[]{"Sand Castle Bucket", "Paint Bucket", "Lunch Pail"};
        }

        @Override
        protected void onPostExecute(String[] typesOfBuckets) {
            BucketsListActivity.this.populateBucketTypesList(typesOfBuckets);
        }
    }
}
