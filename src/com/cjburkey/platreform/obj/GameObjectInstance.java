package com.cjburkey.platreform.obj;

import com.cjburkey.platreform.math.Vector2;

public class GameObjectInstance {
	
	private Vector2 position;
	private IGameObject obj;
	
	public GameObjectInstance(IGameObject obj) {
		this.obj = obj;
	}
	
	public void tick() { obj.tick(this); }
	public void render() { obj.render(this); }
	public void perSecond() { obj.perSecond(this); }
	
	public Vector2 getPosition() { return position; }
	public IGameObject getObject() { return obj; }
	
}