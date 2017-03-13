package com.gmail.s.birchyboy.V6.Physics;

/**
 * @author Birch
 * */
public class TerminalVelocity {
	private static final float GRAVITY = 9.80665f;
	private static final float DENSITY =     1.5f;
	
	/**
	 * @author birch
	 * @param mass The mass of the entity
	 * @param projectedArea The area of the entity
	 * @param dragCoefficient The drag coefficient of the entity
	 * @return The terminal velocity of the entity
	 * */
	public final static float findTerminalVelocity(float mass, float projectedArea, float dragCoefficient){
		return (float) Math.sqrt( (2*mass*GRAVITY)/(DENSITY*projectedArea*dragCoefficient) );
	}
}
