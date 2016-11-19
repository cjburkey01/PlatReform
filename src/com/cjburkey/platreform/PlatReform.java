package com.cjburkey.platreform;

import javafx.application.Application;
import javafx.stage.Stage;

public class PlatReform extends Application {
	
	private static Game game;
	
	public void start(Stage s) {
		Util.log("Start Game.");
		
		game = new Game();
		game.launch(s);
	}
	
	public static void main(String[] args) {
		Thread.currentThread().setName("Launcher");
		Util.defError();
		launch(args);
	}
	
	public static Game getGame() { return game; }
	
}