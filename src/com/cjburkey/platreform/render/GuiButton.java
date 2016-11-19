package com.cjburkey.platreform.render;

import com.cjburkey.platreform.PlatReform;
import com.cjburkey.platreform.event.ECall;
import com.cjburkey.platreform.event.EventHandler;
import com.cjburkey.platreform.math.Rect;
import com.cjburkey.platreform.math.Vector2;
import com.sun.javafx.tk.FontMetrics;
import com.sun.javafx.tk.Toolkit;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

@SuppressWarnings("restriction")
public class GuiButton implements GuiElement {

	private String text;
	private Rect bounds;
	private Paint backgroundColor;
	private Paint hoverColor;
	private Paint textColor;
	private Paint textHoverColor;
	private Font font;
	
	private GuiButton(ECall click) { EventHandler.addListener(EventHandler.MOUSE_CLICKED, () -> { if(isHovered()) click.call(); }); }
	
	public GuiButton(ECall click, String text, Vector2 pos, Paint backgroundColor, Paint hoverColor, Paint textColor, Paint textHoverColor, Font font, double padding) {
		this(click);
		this.bounds = new Rect(pos.getX(), pos.getY(), 0, 0);
		this.text = text;
		this.backgroundColor = backgroundColor;
		this.hoverColor = hoverColor;
		this.textColor = textColor;
		this.textHoverColor = textHoverColor;
		this.font = font;
		
		FontMetrics fm = Toolkit.getToolkit().getFontLoader().getFontMetrics(font);
		this.bounds.setW(fm.computeStringWidth(text) + (padding * 2));
		this.bounds.setH(fm.getLineHeight() + (padding * 2));
	}
	
	public GuiButton(ECall click, String text, Rect bounds, Paint backgroundColor, Paint hoverColor, Paint textColor, Paint textHoverColor, Font font) {
		this(click);
		this.text = text;
		this.bounds = bounds;
		this.backgroundColor = backgroundColor;
		this.hoverColor = hoverColor;
		this.textColor = textColor;
		this.textHoverColor = textHoverColor;
		this.font = font;
	}

	public Vector2 getPos() { return bounds.getPos(); }
	public Vector2 getSize() { return bounds.getSize(); }
	public Rect getBounds() { return bounds; }
	
	public void setRect(Rect r) { this.bounds = r; }

	public void render() {
		GraphicsContext gc = RenderUtils.getGC();
		
		gc.setTextAlign(TextAlignment.CENTER);
		gc.setTextBaseline(VPos.CENTER);
		
		boolean hov = isHovered();
		
		RenderUtils.fillRect(bounds.getPos(), bounds.getSize(), (hov) ? this.hoverColor : this.backgroundColor);
		RenderUtils.fillText(text, bounds.getCenter(), (hov) ? this.textHoverColor : this.textColor, font);
	}
	
	public boolean isHovered() { return bounds.contains(PlatReform.getGame().getWindow().getMouse()); }
	
}