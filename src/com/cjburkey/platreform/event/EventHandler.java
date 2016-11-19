package com.cjburkey.platreform.event;

import java.util.ArrayList;
import java.util.List;

public class EventHandler {
	
	public static final String MOUSE_CLICKED = "mouseClicked";
	
	private static final List<EventListener> listeners = new ArrayList<EventListener>();
	
	public static final void callEvent(String eventName) {
		for(EventListener e : listeners) {
			if(e.getName().equals(eventName)) {
				e.getToCall().call();
			}
		}
	}
	
	public static final int addListener(String eventName, ECall onCall) { listeners.add(new EventListener(eventName, onCall)); return listeners.size() - 1; }
	public static final void remListener(int i) { listeners.remove(i); }
	public static final void clear() { listeners.clear(); }
	
	private static class EventListener {
		private String listen;
		private ECall call;
		
		public EventListener(String l, ECall c) {
			this.listen = l;
			this.call = c;
		}
		
		public String getName() { return listen; }
		public ECall getToCall() { return call; }
	}
	
}