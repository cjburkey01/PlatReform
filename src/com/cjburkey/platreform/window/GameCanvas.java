package com.cjburkey.platreform.window;

import com.cjburkey.platreform.math.Vector2;
import javafx.scene.canvas.Canvas;

public class GameCanvas extends Canvas {
	
	public GameCanvas(Vector2 size) {
		this.prefWidth(size.getX());
		this.prefHeight(size.getY());
		
		this.minWidth(size.getX());
		this.minHeight(size.getY());
		
		this.maxWidth(size.getX());
		this.maxHeight(size.getY());
		
		this.setWidth(size.getX());
		this.setHeight(size.getY());
	}
	
}