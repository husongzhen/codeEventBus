package com.example.eventBus;

import java.lang.reflect.Method;

public class EventInfor {

	private Method m;
	private Class[] ps;
	private Object o;

	public EventInfor(Object o, Method m, Class[] ps) {
		super();
		this.m = m;
		this.ps = ps;
		this.o = o;
	}

	public Method getM() {
		return m;
	}

	public Class[] getPs() {
		return ps;
	}

	public Object getO() {
		return o;
	}

}
