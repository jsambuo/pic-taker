package com.sambuo.pictaker;

import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyPingCallback;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

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
		
		final Button button = (Button) findViewById(R.id.buttonTakePicture);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentTakePicture = new Intent(v.getContext(), TakePictureActivity.class);
                startActivity(intentTakePicture);
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
