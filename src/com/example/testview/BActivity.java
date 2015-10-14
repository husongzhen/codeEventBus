package com.example.testview;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.eventBus.Event;
import com.example.eventBus.EventBus;

public class BActivity extends BaseActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EventBus.register(this);
		TextView textview = (TextView) findViewById(R.id.text);
		textview.setText("pager b");
		textview.setOnClickListener(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		EventBus.unregister(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		// EventBus.post("show_tag", "¹þ¹þ");
		EventBus.post("exit");

	}

}
