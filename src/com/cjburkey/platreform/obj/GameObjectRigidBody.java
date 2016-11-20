package com.cjburkey.platreform.obj;

import com.cjburkey.platreform.math.Rect;

public interface GameObjectRigidBody extends GameObjectVelocity {
	
	public Rect getCollisionBounds();
	
}