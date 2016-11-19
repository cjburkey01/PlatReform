package com.cjburkey.platreform.gamestates;

import com.cjburkey.platreform.PlatReform;
import com.cjburkey.platreform.gamestate.GameState;
import com.cjburkey.platreform.math.Rect;
import com.cjburkey.platreform.math.Vector2;
import com.cjburkey.platreform.render.GuiButton;
import com.cjburkey.platreform.render.GuiHandler;
import com.cjburkey.platreform.render.RenderUtils;
import javafx.scene.paint.Color;

public class GameStateMenu implements GameState {
	
	private GuiHandler handler;
	
	public String getName() { return "GameStateMenu"; }
	public GuiHandler getGuiHandler() { return handler; }
	
	public void tick() {  }
	public void render() { RenderUtils.fillRect(Vector2.zero(), RenderUtils.getSize(), Color.WHITE); }
	public void gui() { handler.render(); }
	
	public void exit(GameState next) { handler = null; }

	public void enter(GameState prev) {
		handler = new GuiHandler();
		
		double h = 150;
		Rect playButton = new Rect(0, RenderUtils.getSize().getY() / 2 - h, RenderUtils.getSize().getX(), h);
		GuiButton playBtn = new GuiButton(() -> PlatReform.getGame().getGameStateHandler().gotoGame(), "PLAY", playButton, Color.BLACK, Color.gray(0.5d), Color.WHITE, Color.WHITE,
			RenderUtils.getFont(75));
		
		Rect quitButton = new Rect(0, RenderUtils.getSize().getY() / 2, RenderUtils.getSize().getX(), h);
		GuiButton quitBtn = new GuiButton(() -> PlatReform.getGame().die(), "QUIT", quitButton, Color.BLACK, Color.gray(0.5d), Color.WHITE, Color.WHITE, RenderUtils.getFont(75));
		
		handler.addElement(playBtn);
		handler.addElement(quitBtn);
	}
	
}