package com.sambuo.pictaker;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseImageView;
import com.parse.ParseQuery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewPictureActivity extends Activity {

	private static final String TAG = "ViewPictureActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);        
		// Request progress bar
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_view_picture);

		Intent intent = getIntent();
		if (!intent.hasExtra(MainActivity.EXTRA_USER_PICTURE_ID)) {
			Log.e(TAG, "UserPictureId was not given to ViewPictureActivity");
		} else {
			final String userPictureId = intent.getStringExtra(MainActivity.EXTRA_USER_PICTURE_ID);

			final ParseImageView imageView = (ParseImageView) findViewById(R.id.image);
			ParseQuery<UserPicture> query = new ParseQuery<UserPicture>(UserPicture.class);
			query.getInBackground(userPictureId, new GetCallback<UserPicture>() {

				@Override
				public void done(UserPicture userPicture, ParseException e) {
					if (e == null) {
						imageView.setParseFile(userPicture.getPhotoFile());
						imageView.loadInBackground();
					} else {
						Log.e(TAG, "Error getting UserPicture: " + e.getMessage());
						Toast.makeText(ViewPictureActivity.this, "Error getting picture", Toast.LENGTH_SHORT).show();
					}
					setProgressBarIndeterminate(false);				
				}
			});

			setProgressBarIndeterminate(true);
		}
	}
}
