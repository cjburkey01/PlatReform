package com.cjburkey.platreform.gamestate;

import com.cjburkey.platreform.Util;
import com.cjburkey.platreform.gamestates.GameStateMenu;

public class GameStateHandler {
	
	private GameState current;
	
	private GameStateMenu gsm;
	
	public void tick() {
		if(current != null) current.tick();
	}
	
	public void render() {
		if(current != null) current.render();
	}
	
	public void gui() {
		if(current != null) current.gui();
	}
	
	public void setGameState(GameState s) {
		if(current != null) current.exit(s);
		s.enter(current);
		current = s;
		Util.log("Set GameState: '" + s.getName() + "'");
	}
	
	public void gotoMenu() {
		if(gsm == null) gsm = new GameStateMenu();
		setGameState(gsm);
	}
	
	public GameState getGameState() {
		return current;
	}
	
}