package com.gmail.s.birchyboy.V6.Engine;


/**
 * @author Birch
 * */
public enum Errors {
	FileNotFound("Whoa! The file could not be found!"),
	WriteError("Whoa! The file could not be written!"),
	ReadError("Whoa! The file could not be read!"),
	MathError("Whoa! There was a mathematical error!"),
	IOException("Whoa! The file could not be found!"),
	LWJGLException("Whoa! LWJGL has broken!"),
	AudioPlaybackError("Whoa! The audio could not be played back!"),
	UnsupportedAudioFileException("Whoa! The audio format is not supported!"),
	AudioError("Whoa! There is an error with the audio!"),
	LineUnavailableException("Whoa! An audio error has occured")
	;
    
	private Errors(final String text) {
        this.text = text;
    }

    private final String text;
    
    @Override
    public String toString() {
        return text;
    }
}
