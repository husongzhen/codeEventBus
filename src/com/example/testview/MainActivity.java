package com.example.testview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.eventBus.Event;
import com.example.eventBus.EventBus;

public class MainActivity extends BaseActivity implements OnClickListener {

	private TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		EventBus.register(this);
		text = (TextView) findViewById(R.id.text);
		text.setOnClickListener(this);
	}

	@Event(tag = "show_tag")
	public void show(String str) {
		text.setText(str);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		EventBus.unregister(this);
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, AActivity.class);
		startActivity(intent);

	}

}
