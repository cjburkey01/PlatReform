package com.cjburkey.platreform.gamestate;

import com.cjburkey.platreform.Util;
import com.cjburkey.platreform.gamestates.GameStateGame;
import com.cjburkey.platreform.gamestates.GameStateMenu;

public class GameStateHandler {
	
	private IGameState current;
	
	private GameStateMenu gsm;
	private GameStateGame gsg;
	
	public void tick() {
		if(current != null) current.tick();
	}
	
	public void render() {
		if(current != null) current.render();
	}
	
	public void gui() {
		if(current != null) current.gui();
	}
	
	public void setGameState(IGameState s) {
		if(current != null) current.exit(s);
		s.enter(current);
		current = s;
		Util.log("Set GameState: '" + s.getName() + "'");
	}
	
	public void gotoMenu() {
		if(gsm == null) gsm = new GameStateMenu();
		setGameState(gsm);
	}
	
	public void gotoGame() {
		if(gsg == null) gsg = new GameStateGame();
		setGameState(gsg);
	}
	
	public IGameState getGameState() {
		return current;
	}
	
}