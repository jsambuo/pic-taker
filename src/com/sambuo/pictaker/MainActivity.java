package com.sambuo.pictaker;

import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class MainActivity extends Activity {
	
	public static final String EXTRA_USER_PICTURE_ID = "com.sambuo.pictaker.USER_PICTURE_ID";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//TODO: Move to Application Class
		ParseObject.registerSubclass(UserPicture.class);
		Parse.initialize(this, "X6WBTy1jE7XbqPVqJVRnZIY782BTrluKZ9kkNRe7", "s9sImNOqS5RSiVjs5K0i2SHk0E1W5ZhnMNKezkJu");
		ParseAnalytics.trackAppOpened(getIntent());
		
	    FragmentManager manager = getFragmentManager();
		Fragment fragment = manager.findFragmentById(R.id.fragmentContainer);
		
		if (fragment == null) {
			fragment = new HomeFragment();
			manager.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
        
		/*
        final Button buttonShowPictures = (Button) findViewById(R.id.buttonShowPictures);
        buttonShowPictures.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentShowPicture = new Intent(v.getContext(), ShowPictureActivity.class);
                startActivity(intentShowPicture);
            }
        });
        */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
