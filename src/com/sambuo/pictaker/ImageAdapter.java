package com.sambuo.pictaker;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQueryAdapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends ParseQueryAdapter<UserPicture> {
	
	private static final String TAG = "ImageAdapter";

	public ImageAdapter(Context context, Class<UserPicture> class1) {
		super(context, class1);
	}

	@Override
	public View getItemView(UserPicture userPicture, View v, ViewGroup parent) {
	 
	    if (v == null) {
	        v = View.inflate(getContext(), R.layout.item_list_photos, null);
	    }
	 
	    super.getItemView(userPicture, v, parent);
	 
	    ParseImageView userImage = (ParseImageView) v.findViewById(R.id.icon);
	    ParseFile photoFile = userPicture.getParseFile("photo");
	    if (photoFile != null) {
	    	userImage.setParseFile(photoFile);
	    	userImage.loadInBackground(new GetDataCallback() {

				@Override
				public void done(byte[] arg0, ParseException arg1) {
					// do nothing
					Log.d(TAG, "photoFile loaded");
				}
	        });
	    } else {
	    	Log.d(TAG, "photoFile is null");
	    }
	    return v;
	}
}