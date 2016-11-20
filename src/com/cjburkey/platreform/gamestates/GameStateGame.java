package com.cjburkey.platreform.gamestates;

import com.cjburkey.platreform.gamestate.IGameState;
import com.cjburkey.platreform.gui.GuiHandler;
import com.cjburkey.platreform.math.Vector2;
import com.cjburkey.platreform.render.RenderUtils;
import javafx.scene.paint.Color;

public class GameStateGame implements IGameState {
	
	private GuiHandler handler;
	
	public String getName() { return "GameStateGame"; }
	public GuiHandler getGuiHandler() { return handler; }
	
	public void tick() {  }
	public void render() { RenderUtils.fillRect(Vector2.zero(), RenderUtils.getSize(), Color.rgb(125, 200, 255)); }
	public void gui() { handler.render(); }
	
	public void exit(IGameState next) { handler = null; }
	public void enter(IGameState prev) { handler = new GuiHandler(); }
	
}