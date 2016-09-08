package com.example.puristitchat;


import android.app.Application;

public class MainApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		FcmPush.init(this);
	}
}
