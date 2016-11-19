package com.cjburkey.platreform;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Util {
	
	public static final void log(Object msg) { System.out.println(msg); }
	public static final long now() { return System.nanoTime(); }
	
	public static final void error(Throwable t) {
		System.err.println(t.getMessage());
		t.printStackTrace();
		
		Alert a = new Alert(AlertType.ERROR);
		a.setTitle("Error!");
		a.setContentText("Something went wrong!  That game threw a fatal exception, the game will now close.");
		a.show();
		
		Game g = PlatReform.getGame();
		if(g != null) g.die();
	}
	
	public static final void defError() {
		log("Setting default error handler for: '" + Thread.currentThread().getName() + "'");
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> Util.error(e));
	}
	
}