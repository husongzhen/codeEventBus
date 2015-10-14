package com.example.eventBus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import android.util.Log;

public class EventBus {

	private static EventManager eventMap = new EventManager();

	public static void unregister(Object activity) {
		// TODO Auto-generated method stub
		Class<Object> clazz = (Class<Object>) activity.getClass();
		for (Method m : clazz.getDeclaredMethods()) {
			Event anno = m.getAnnotation(Event.class);
			if (anno != null) {
				EventList eventList = eventMap.get(anno.tag());
				for (Iterator iterator = eventList.iterator(); iterator
						.hasNext();) {
					EventInfor eventInfor = (EventInfor) iterator.next();
					Object o = eventInfor.getO();
					if (o == activity) {
						eventList.remove(iterator);
					}
				}
				if (eventList.isEmpty()) {
					eventMap.remove(anno.tag());
				}
			}
		}

	}

	public static void register(Object activity) {
		Class<Object> clazz = (Class<Object>) activity.getClass();
		for (Method m : clazz.getDeclaredMethods()) {
			Event anno = m.getAnnotation(Event.class);
			if (anno != null) {
				Class<?>[] paramClazzs = m.getParameterTypes();
				EventInfor infor = new EventInfor(activity, m, paramClazzs);
				String tag = anno.tag();
				EventList eventList = getEventList(tag);
				eventList.add(infor);
			}
		}
	}

	private static EventList getEventList(String tag) {
		// TODO Auto-generated method stub
		EventList result = eventMap.get(tag);
		if (result == null) {
			result = new EventList();
			eventMap.put(tag, result);
		}
		return result;
	}

	public static void post(String tag, Object... args) {
		// TODO Auto-generated method stub
		EventList list = eventMap.get(tag);
		for (EventInfor infor : list) {
			excuteEvent(infor, args);
		}

	}

	private static void excuteEvent(EventInfor infor, Object... args) {
		// TODO Auto-generated method stub
		Method m = infor.getM();
		Object o = infor.getO();
		if (args.length == infor.getPs().length) {
			try {
				Log.d("excuteEvent", o.getClass().getName() + "." + m.getName());
				m.invoke(o, args);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
