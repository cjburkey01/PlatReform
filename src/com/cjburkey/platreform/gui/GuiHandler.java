package com.cjburkey.platreform.gui;

import java.util.ArrayList;
import java.util.List;

public class GuiHandler {
	
	private final List<IGuiElement> els = new ArrayList<IGuiElement>();
	
	public void render() {
		for(IGuiElement e : els) {
			e.render();
		}
	}
	
	public void addElement(IGuiElement e) { els.add(e); }
	public void remElement(IGuiElement e) { els.remove(e); }
	
}