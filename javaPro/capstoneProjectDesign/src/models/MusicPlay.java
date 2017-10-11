package models;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import countdata.Pianokeys;
import interfacePackage.MusicPlayerInterface;

public class MusicPlay implements MusicPlayerInterface{
	private final String FILEPATH = "/voice/";
	private final String SUFFIX = ".wav";
	private Map<String, AudioClip> audioList;
	private AudioClip audio1 = null;
	public MusicPlay(){
		audioList = new HashMap<String, AudioClip>();
		URL codebase = null;
		for(String voice : Pianokeys.getVoicesList()){
			try {
				codebase = new URL("file:/" + System.getProperty("user.dir") + FILEPATH + voice + SUFFIX);
				audioList.put(voice, Applet.newAudioClip(codebase));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
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
		audio1 = audioList.get(voice);
		audio1.play();
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}
