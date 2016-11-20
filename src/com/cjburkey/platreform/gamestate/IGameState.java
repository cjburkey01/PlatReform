package com.cjburkey.platreform.gamestate;

import com.cjburkey.platreform.gui.GuiHandler;

public interface IGameState {
	
	public String getName();
	public GuiHandler getGuiHandler();
	
	public void tick();
	public void render();
	public void gui();
	public void enter(IGameState prev);
	public void exit(IGameState next);
	
}