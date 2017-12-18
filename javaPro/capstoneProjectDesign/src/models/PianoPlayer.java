package models;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import countdata.Keys;
import interfacePackage.MusicPlayer;

public class PianoPlayer extends MusicPlayer{
	private Map<String, AudioClip> audioList;
	private AudioClip audio1 = null;
	protected final String FILEPATH = "/voice/piano/";
	public PianoPlayer(){
		audioList = new HashMap<String, AudioClip>();
		URL codebase = null;
		for(String voice : Keys.getKeys()){
			try {
				//System.out.println(Keys.getVoice(voice));
				codebase = new URL("file:/" + System.getProperty("user.dir") + FILEPATH + voice + SUFFIX);
				audioList.put(voice, Applet.newAudioClip(codebase));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void stop() {
		if (audio1 == null)
			return;
		else
			audio1.stop();
	}

	@Override
	public void play(String voice) {
//		URL codebase = null;
//		try {
//			codebase = new URL("file:/" + System.getProperty("user.dir") + FILEPATH + voice + SUFFIX);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//		audio1 = Applet.newAudioClip(codebase);
//		String myVoice = Keys.getVoice(voice);
		audio1 = audioList.get(voice);
		audio1.play();
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
