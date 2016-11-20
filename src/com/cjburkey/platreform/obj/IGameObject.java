package com.cjburkey.platreform.obj;

public interface IGameObject {
	
	public void tick(GameObjectInstance inst);
	public void render(GameObjectInstance inst);
	public void perSecond(GameObjectInstance inst);
	
}