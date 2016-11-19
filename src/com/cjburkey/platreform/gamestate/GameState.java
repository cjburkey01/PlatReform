package com.cjburkey.platreform.gamestate;

import com.cjburkey.platreform.render.GuiHandler;

public interface GameState {
	
	public String getName();
	public GuiHandler getGuiHandler();
	
	public void tick();
	public void render();
	public void gui();
	public void enter(GameState prev);
	public void exit(GameState next);
	
}