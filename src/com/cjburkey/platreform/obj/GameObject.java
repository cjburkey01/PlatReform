package com.cjburkey.platreform.obj;

public interface GameObject {
	
	public void tick(GameObjectInstance inst);
	public void render(GameObjectInstance inst);
	public void perSecond(GameObjectInstance inst);
	
}