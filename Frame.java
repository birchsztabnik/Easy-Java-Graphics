package com.gmail.s.birchyboy.V6.Engine;

/**
 * @author Birch
 * */
public class Frame {
	private int length;
	private int displayedCount;
	private Sprite sprite;
	
	public Frame(){
		sprite = new Sprite();
		length = 60;
		displayedCount = 0;
	}
	public Frame(Sprite s, int l){
		sprite = s;
		length = l;
		displayedCount = 0;
	}
	
	public final boolean render(){
		displayedCount++;
		if(displayedCount >= length){
			displayedCount=0;
			return true;
		}else
			return false;
	}
	
	public final int getWidth() {
		return sprite.getWidth();
	}
	
	public final int getHeight() {
		return sprite.getHeight();
	}
}
