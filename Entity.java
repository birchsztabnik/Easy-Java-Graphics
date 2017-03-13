package com.gmail.s.birchyboy.V6.Entities;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;

import com.gmail.s.birchyboy.V6.Engine.Animation;

/**
 * @author Birch
 * */
public abstract class Entity {
	protected int       x, y;//Bottom left corner of entity
	protected float     strength;
	protected Animation animation;
	protected boolean markForDeletion = false;
	
	public Entity() {
		x = 0;
		y = 0;
		
		strength = 10;
		
		animation = new Animation();
		
	}
	
	public Entity(int x, int y, float s, Animation a) {
		this.x = x;
		this.y = y;
		
		strength = s;
		
		animation = a;
		
	}
	
	public abstract void update();

	public final void render(){
		glPushMatrix(); {
			glTranslatef(x,y,0);
			animation.render();
		}
		glPopMatrix();
	}
	
	protected void translate(int nX, int nY){
		x += nX;
		y += nY;
	}
	
	public boolean canDelete(){return markForDeletion;}
	public void remove(){markForDeletion = true;}
	/**
	 * @return the x
	 */
	public final int getX() {return x;}

	/**
	 * @param x New x position
	 */
	public final void setX(int x) {this.x = x;}

	/**
	 * @return the y
	 */
	public final int getY() {return y;}

	/**
	 * @param y New y position
	 */
	public final void setY(int y) {this.y = y;}
	
	public final int getWidth() {return animation.getWidth();}
	
	public final int getHeight() {return animation.getHeight();}
}
