package com.cjburkey.platreform.obj;

import java.util.ArrayList;
import java.util.List;

public class ObjHandler {
	
	private final List<GameObjectInstance> inst = new ArrayList<GameObjectInstance>();
	
	public void tick() {
		for(GameObjectInstance i : inst) {
			i.tick();
		}
	}
	
	public void render() {
		for(GameObjectInstance i : inst) {
			i.render();
		}
	}
	
	public void perSecond() {
		for(GameObjectInstance i : inst) {
			i.perSecond();
		}
	}
	
}