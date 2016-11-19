package com.cjburkey.platreform.io;

import javafx.scene.text.Font;

public class FontLoader {
	
	public static final Font getFont(String name, int size) {
		Font f = Font.loadFont(FontLoader.class.getResourceAsStream("/res/font/" + name + ".ttf"), size);
		return f;
	}
	
}