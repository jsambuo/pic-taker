package com.sambuo.pictaker;

import com.parse.ParseQueryAdapter;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class HomeFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_home, container, false);

		final ParseQueryAdapter<UserPicture> adapter = new ImageAdapter(getActivity(), UserPicture.class);
		GridView gridview = (GridView) v.findViewById(R.id.gridview);
		gridview.setAdapter(adapter);

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				Intent intentViewPicture = new Intent(v.getContext(), ViewPictureActivity.class);
				intentViewPicture.putExtra(MainActivity.EXTRA_USER_PICTURE_ID, adapter.getItem(position).getObjectId());
				startActivity(intentViewPicture);
			}
		});

		final Button buttonTakePicture = (Button) v.findViewById(R.id.buttonTakePicture);
		buttonTakePicture.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
				Fragment cameraFragment = new CameraFragment();
				getFragmentManager()
				.beginTransaction()
				.replace(R.id.fragmentContainer, cameraFragment)
				.addToBackStack("CameraFragment")
				.commit();
			}
		});	    

		return v;
	}
}
