package com.cjburkey.platreform.render;

import com.cjburkey.platreform.PlatReform;
import com.cjburkey.platreform.io.FontLoader;
import com.cjburkey.platreform.math.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class RenderUtils {
	
	private static Font font;
	
	public static final GraphicsContext getGC() { return PlatReform.getGame().getWindow().getCanvas().getGraphicsContext2D(); }
	public static final Vector2 getSize() { return new Vector2(getGC().getCanvas().getWidth(), getGC().getCanvas().getHeight()); }

	public static final Font getFont() { return getFont(12); }
	public static final Font getFont(int size) { if(font == null) font = FontLoader.getFont("Montserrat", size); return font; }
	
	public static final void fillRect(Vector2 pos, Vector2 size, Paint color) { getGC().setFill(color); getGC().fillRect(pos.getX(), pos.getY(), size.getX(), size.getY()); }
	public static final void fillText(String text, Vector2 pos, Paint color, Font font) { getGC().setFont(font); getGC().setFill(color); getGC().fillText(text, pos.getX(), pos.getY()); }
	
}