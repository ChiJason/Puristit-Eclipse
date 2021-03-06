package com.example.puristitchat;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends ActionBarActivity {
	
	TextView result;
	Button chat;
	String regid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		regid = FirebaseInstanceId.getInstance().getToken();
		Log.e("Regid:", regid);
	    
		result = (TextView)findViewById(R.id.result);
		
		if(regid==null){
			Log.e("regid:", "Null");
			regid = "";
		}else {
			result.setText("Ready to Chat");
		}
		
		chat = (Button)findViewById(R.id.chatBtn);
		chat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent();
				it.setClass(LoginActivity.this, FullscreenActivity.class);
				it.putExtra("regid", regid);
				startActivity(it);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
