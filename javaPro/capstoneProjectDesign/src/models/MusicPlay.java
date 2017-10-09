package models;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;

public class MusicPlay extends JFrame {
	private final String FILEPATH = "/voice/";
	private final String SUFFIX = ".wav";
	private AudioClip audio1 = null;
	public void stop() {
		if (audio1 == null)
			return;
		else
			audio1.stop();
	}
	public void play(String voice) {
		URL codebase = null;
		try {
			codebase = new URL("file:/" + System.getProperty("user.dir") + FILEPATH + voice + SUFFIX);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		audio1 = Applet.newAudioClip(codebase);
		audio1.play();
	}
}
