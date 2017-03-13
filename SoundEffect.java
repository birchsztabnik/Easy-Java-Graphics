package com.gmail.s.birchyboy.V6.Audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.gmail.s.birchyboy.V6.Engine.Errors;

/**
 * @author Birch
 * */
public class SoundEffect {
	protected AudioInputStream audiostream;
	protected Clip audio;
	
	public SoundEffect(String filepath){
		try {
			audiostream = AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
		} catch (UnsupportedAudioFileException e) {
			System.out.println(Errors.UnsupportedAudioFileException);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(Errors.IOException);
			e.printStackTrace();
		}
		
		try {
			audio = AudioSystem.getClip();
			audio.open(audiostream);
		} catch (LineUnavailableException | IOException e) {
			System.out.println(Errors.LineUnavailableException);
			e.printStackTrace();
		}
	}
	
	public void play(){
		audio.start();
		System.out.println(audio.isRunning());
	}
	public void stop(){
		audio.stop();
		audio.close();
	}
}
