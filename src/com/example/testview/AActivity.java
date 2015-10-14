package com.example.testview;

import com.example.eventBus.Event;
import com.example.eventBus.EventBus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AActivity extends BaseActivity implements OnClickListener {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EventBus.register(this);
		textview = (TextView) findViewById(R.id.text);
		textview.setText("pager a");
		textview.setOnClickListener(this);
	}

	@Event(tag = "show_tag")
	public void show(String str) {
		textview.setText(str);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		// EventBus.post("show_tag", "¹þ¹þ");
		Intent intent = new Intent(this, BActivity.class);
		startActivity(intent);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.unregister(this);
	}

	

}
