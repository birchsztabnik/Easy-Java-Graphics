package com.gmail.s.birchyboy.V6.Particles;

import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;

import com.gmail.s.birchyboy.V6.Engine.Time;

public class Particle {
	private float r;
	private float b;
	private float g;
	private float a;
	
	private Vector2f velocity;
	
	private int life;
	private int currentLife = 0;
	
	private Vector2f position;
	
	private boolean markForDeletion = false;
	
	private Random random;
	
	public Particle(float r, float b, float g, float a, int life, Vector2f v, Vector2f p){
		this.r = r;
		this.b = b;
		this.g = g;
		this.a = a;
		
		this.life = life;
		
		
		velocity = v;
		
		position = p;
		
		random = new Random();
	}
	
	public Particle(float r, float b, float g, float a, int life, Vector2f v, int x, int y){
		this.r = r;
		this.b = b;
		this.g = g;
		this.a = a;
		
		this.life = life;
		
		
		velocity = v;
		
		position = new Vector2f(x,y);
		
		random = new Random();
	}
	
	public Particle(float r, float b, float g, float a, int life){
		random = new Random();
		
		this.r = random.nextFloat();
		this.b = random.nextFloat();
		this.g = random.nextFloat();
		this.a = a;
		
		this.life = life;
		
		velocity = new Vector2f((random.nextInt(5 - -5 +1)+-5) + random.nextFloat(), random.nextInt(5 - -5 +1)+-5 + random.nextFloat());
		
		position = new Vector2f((float)(Display.getWidth()+ ((random.nextInt(50 - -50 +1)+-50)/Math.PI*2)), (float) (540 + ((random.nextInt(50 - -50 +1)+-50)/Math.PI*2)));
		
	}
	
	public void render(){
		glColor4f(r,g,b,a);
		glVertex2f(position.x, position.y);

		slow();
		
		if(currentLife>=life || a<=0)
			markForDeletion = true;
		
		currentLife++;
	}
	
	public void slow(){
		a-= .001*Time.getDelta();
		
		position.x += velocity.x;
		position.y += velocity.y;
		
		velocity.y -= .001 * Time.getDelta();
	}
	
	public boolean canDelete(){
		return markForDeletion;
	}
}
