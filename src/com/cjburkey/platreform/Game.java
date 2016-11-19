package com.cjburkey.platreform;

import com.cjburkey.platreform.core.GameLoop;
import com.cjburkey.platreform.gamestate.GameStateHandler;
import com.cjburkey.platreform.math.Vector2;
import com.cjburkey.platreform.obj.ObjHandler;
import com.cjburkey.platreform.render.RenderUtils;
import com.cjburkey.platreform.window.GameWindow;
import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Game {
	
	private static boolean launched = false;
	
	private GameLoop gameLoop;
	private GameWindow window;
	private ObjHandler objh;
	private GameStateHandler gsh;
	
	public void launch(Stage s) {
		if(launched) return;
		launched = true;
		
		Util.log("Begin...");
		Util.defError();
		
		gameLoop = new GameLoop();
		window = new GameWindow(s);
		objh = new ObjHandler();
		gsh = new GameStateHandler();
		
		window.start();
		gameLoop.start();
		
		gsh.gotoMenu();
	}
	
	public void tick() {
		objh.tick();
		gsh.tick();
	}
	
	public void render() {
		RenderUtils.fillRect(Vector2.zero(), RenderUtils.getSize(), Color.WHITE);
		
		objh.render();
		gsh.render();
		
		gsh.gui();
	}
	
	public void perSecond() {
		objh.perSecond();
	}
	
	public void die() {
		Util.log("Kill Game.");
		gameLoop.stop();
		Platform.exit();
	}
	
	public GameLoop getGameLoop() { return gameLoop; }
	public GameWindow getWindow() { return window; }
	public ObjHandler getObjectHandler() { return objh; }
	public GameStateHandler getGameStateHandler() { return gsh; }
	
}