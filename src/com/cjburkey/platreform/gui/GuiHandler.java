package com.cjburkey.platreform.gui;

import java.util.ArrayList;
import java.util.List;

public class GuiHandler {
	
	private final List<GuiElement> els = new ArrayList<GuiElement>();
	
	public void render() {
		for(GuiElement e : els) {
			e.render();
		}
	}
	
	public void addElement(GuiElement e) { els.add(e); }
	public void remElement(GuiElement e) { els.remove(e); }
	
}