package com.gmail.s.birchyboy.V6.Physics;

import com.gmail.s.birchyboy.V6.Entities.Entity;

/**
 * @author Birch
 * */
public class Collision {
	public final static boolean checkSideTopCollision(Entity e1, Entity e2) {
		if ( (e1.getWidth() + e1.getX()) >= e2.getX() )
			return true;
		else if ( (e1.getHeight() + e1.getY()) >= e2.getY() )
			return true;
		else
			return false;
	}
	public final static boolean checkBottomCollision(Entity e1, Entity e2) {
		if( e2.getY() <= (e1.getY() + e1.getHeight()) )
			return true;
		else
			return false;
	}
}
