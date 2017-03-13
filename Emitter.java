package com.gmail.s.birchyboy.V6.Particles;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_DST_COLOR;
import static org.lwjgl.opengl.GL11.GL_POINTS;
import static org.lwjgl.opengl.GL11.GL_POINT_SMOOTH;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glPointSize;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class Emitter {
	private ArrayList<Particle> particles;
	private boolean markForDeletion;
	
	public Emitter(int numberOfParticles, float r, float g, float b, float a, int l, Vector2f p){
		particles = new ArrayList<Particle>();
		markForDeletion = false;
		
		for(int z=0; z < numberOfParticles; z++){
			particles.add(new Particle(r, g, b, a, l));
		}
	}
	
	public void render(){
		for(Particle p: particles){
			if(!p.canDelete()){
				glEnable(GL_POINT_SMOOTH);
				glEnable(GL_BLEND);
				glPointSize(5.0f);
				glBlendFunc(GL_SRC_ALPHA, GL_DST_COLOR);
	
				glBegin(GL_POINTS);
				p.render();
				GL11.glEnd();
				
				glDisable(GL_BLEND);
			}else{
				markForDeletion = true;
			}
		}
	}
	
	public boolean canDelete(){
		return markForDeletion;
	}
}
