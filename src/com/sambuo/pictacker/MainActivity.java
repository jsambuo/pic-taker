package com.sambuo.pictacker;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Client mKinveyClient = new Client.Builder("kid_PTxf3dWkUO", "c41dcceb19d24cf09f347c30397fea6d", this.getApplicationContext()).build();
		
		mKinveyClient.ping(new KinveyPingCallback() {
		    public void onFailure(Throwable t) {
		        Log.e("Test", "Kinvey Ping Failed", t);
		    }
		    public void onSuccess(Boolean b) {
		        Log.d("Test", "Kinvey Ping Success");
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
