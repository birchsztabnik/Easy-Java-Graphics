package com.gmail.s.birchyboy.V6.Engine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * @author Birch
 * */
public class Management {
	/*
	 * createDisplay();
	 * startGL();
	 * startGame();
	 * cycle();
	 * exit();
	 * */
	private static Game game;
	
	private final static void cycle() {
		getInput();
		update();
		render();
	}
	
	private final static void startGame() {
		game = new Game();
	}	
	
	private final static void getInput() {
		game.getInput();
	}
	
	private final static void update() {
		game.update();
	}
	
	private final static void render() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		
		game.render();
		
		Display.update();
		//Display.sync(60);
	}
	
	private final static void exit() {
		Display.destroy();
		Keyboard.destroy();
	}
	
	private final static void startGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		
		glDisable(GL_DEPTH_TEST);
		
		glClearColor(0,0,0,0);
	}
	
	private final static void createDisplay() {
		try{
			Display.setDisplayMode(new DisplayMode(1280,720));
			Display.create();
			Keyboard.create();
			Display.setResizable(true);
			//Display.setVSyncEnabled(true);
		}catch(LWJGLException ex){
			System.out.println(Errors.LWJGLException);
			System.out.println(ex.getStackTrace());
		}
		
	}
}
