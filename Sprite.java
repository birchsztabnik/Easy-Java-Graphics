package com.gmail.s.birchyboy.V6.Engine;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2f;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.lwjgl.opengl.GL11;

/**
 * @author Birch
 * */
public class Sprite {
	private int width, height;
	private final int textureID;
	private BufferedImage image;
	
	public Sprite(String file) throws IOException {
		image = TextureLoader.loadImage(file);
		textureID = TextureLoader.loadTexture(image);
		
		height = image.getHeight();
		width  = image.getWidth();
	}

	public Sprite() {
		width = 0;
		height = 0;
		textureID = 0;
		image = null;
	}
	
	public final void render(){
		glEnable(GL_TEXTURE_2D | GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        
        glPushMatrix();
        glBindTexture(GL_TEXTURE_2D, textureID);
		glBegin(GL_QUADS);
			glTexCoord2f(0, 0);
			glVertex2f(0,     0);
			
			glTexCoord2f(1, 0);
			glVertex2f(0,     height);
			
			glTexCoord2f(1, 1);
			glVertex2f(width, height);
			
			glTexCoord2f(0, 1);
			glVertex2f(width, 0);
		glEnd();

		glDisable(GL_BLEND | GL_TEXTURE_2D);

		glPopMatrix();
	}
	
	public final int getWidth() {
		return width;
	}
	
	public final void setWidth(int width) {
		this.width = width;
	}
	
	public final int getHeight() {
		return height;
	}
	
	public final void setHeight(int height) {
		this.height = height;
	}
	
	public final void resize(int width, int height) {
		this.width  = width;
		this.height = height;
	}
	
	public BufferedImage getImage(){
		return image;
	}
}
