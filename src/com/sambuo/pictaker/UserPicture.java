package com.sambuo.pictaker;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("UserPicture")
public class UserPicture extends ParseObject {
	
	public UserPicture() {
		
	}
	
	public ParseFile getPhotoFile() {
		return getParseFile("photo");
	}
	
	public void setPhotoFile(ParseFile file) {
		put("photo", file);
	}
}
