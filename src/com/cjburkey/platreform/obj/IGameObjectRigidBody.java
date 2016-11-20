package com.cjburkey.platreform.obj;

import com.cjburkey.platreform.math.Rect;

public interface IGameObjectRigidBody extends IGameObjectVelocity {
	
	public Rect getCollisionBounds();
	
}