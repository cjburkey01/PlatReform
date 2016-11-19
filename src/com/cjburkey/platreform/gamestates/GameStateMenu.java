package com.cjburkey.platreform.gamestates;

import com.cjburkey.platreform.Util;
import com.cjburkey.platreform.event.EventHandler;
import com.cjburkey.platreform.gamestate.GameState;
import com.cjburkey.platreform.math.Vector2;
import com.cjburkey.platreform.render.GuiButton;
import com.cjburkey.platreform.render.GuiHandler;
import com.cjburkey.platreform.render.RenderUtils;
import javafx.scene.paint.Color;

public class GameStateMenu implements GameState {
	
	private GuiHandler handler;
	private int mouseClickedId;
	
	public String getName() { return "GameStateMenu"; }
	public GuiHandler getGuiHandler() { return handler; }
	
	public void tick() {  }
	public void render() { RenderUtils.fillRect(Vector2.zero(), RenderUtils.getSize(), Color.WHITE); }
	public void gui() { handler.render(); }
	
	public void exit(GameState next) {
		handler = null;
		EventHandler.remListener(mouseClickedId);
	}

	public void enter(GameState prev) {
		handler = new GuiHandler();
		
		GuiButton button;
		button = new GuiButton(() -> Util.log("Call"), "Test", new Vector2(50, 50), Color.BLACK, Color.gray(0.5d), Color.WHITE, Color.WHITE, RenderUtils.getFont(155), 0);
		
		handler.addElement(button);
	}
	
}