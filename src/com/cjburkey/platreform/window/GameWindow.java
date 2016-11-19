package com.cjburkey.platreform.window;

import com.cjburkey.platreform.PlatReform;
import com.cjburkey.platreform.event.EventHandler;
import com.cjburkey.platreform.math.Vector2;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GameWindow {
	
	private GameCanvas canvas;
	private Stage stage;
	private Vector2 mousePos = Vector2.zero();
	
	public GameWindow(Stage s) {
		this.stage = s;
	}
	
	public void start() {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root);
		
		Vector2 size = new Vector2(Screen.getPrimary().getVisualBounds().getWidth() / 1.3, Screen.getPrimary().getVisualBounds().getHeight() / 1.3);
		canvas = new GameCanvas(size);
		
		root.setCenter(canvas);
		
		canvas.setOnMouseMoved(e -> { mousePos.setX(e.getX()); mousePos.setY(e.getY()); });
		canvas.setOnMouseClicked(e -> EventHandler.callEvent(EventHandler.MOUSE_CLICKED));
		
		stage.setScene(scene);
		stage.sizeToScene();
		stage.centerOnScreen();
		stage.setTitle("PlatReform");
		stage.setResizable(false);
		stage.setOnCloseRequest(e -> PlatReform.getGame().die());
		stage.show();
	}
	
	public GameCanvas getCanvas() { return canvas; }
	public Stage getStage() { return stage; }
	public final Vector2 getMouse() { return mousePos.copy(); }
	
}