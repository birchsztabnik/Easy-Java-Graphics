package com.gmail.s.birchyboy.V6.Engine;

import org.lwjgl.Sys;

/**
 * @author Birch
 * */
public class Time{
	
	private static long lastFrame;
	
	public static final long getTime(){//returns the time in milliseconds
		return(Sys.getTime()*1000) / Sys.getTimerResolution();
	}
	
	public static final int getDelta(){
		long time = getTime();
		int delta = (int) (time - lastFrame);
		lastFrame = time;
		
		return delta;
	}
	
	public static void setLastFrame(){
		lastFrame = getTime();
	}
}
