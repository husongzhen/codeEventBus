package com.example.testview;

import com.example.eventBus.Event;

import android.app.Activity;

public class BaseActivity extends Activity {

	@Event(tag = "exit")
	public void exit() {
		finish();
	}
}
