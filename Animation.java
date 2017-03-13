package com.gmail.s.birchyboy.V6.Engine;

import java.util.ArrayList;

/**
 * @author Birch
 * */
public class Animation {
	private ArrayList<Frame> frames;
	private int currentFrame;
	
	public Animation() {
		frames = new ArrayList<Frame>();
		frames.add(new Frame());
		
		currentFrame = 0;
	}
	public Animation(ArrayList<Frame> f) {
		frames = f;
		
		currentFrame = 0;
	}
	
	public final void render() {
		Frame tempFrame = frames.get(currentFrame);
		if(tempFrame.render()){
			currentFrame++;
			currentFrame %= frames.size();
		}
	}
	
	public final int getWidth() {
		return frames.get(0).getWidth();
	}
	
	public final int getHeight() {
		return frames.get(0).getHeight();
	}
}
