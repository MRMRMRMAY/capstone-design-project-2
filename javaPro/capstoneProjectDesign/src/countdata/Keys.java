package countdata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Keys {
	public static Map<String,String> INSTRUMENTKEYSMAP = new HashMap<String,String>();
	static final String VOICES[] = {"C3", "C#3", "D3", "D#3", "E3", "F3", "F#3", "G3", "G#3", "A3", "A#3", "B3",
            "C4", "C#4", "D4", "D#4", "E4", "F4", "F#4", "G4", "G#4", "A4", "A#4", "B4",
            "C5", "C#5", "D5", "D#5", "E5", "F5", "F#5", "G5", "G#5", "A5", "A#5", "B5"};
	static final String KEYS[] = {"C3", "C13", "D3", "D13", "E3", "F3", "F13", "G3", "G13", "A3", "A13", "B3",
            "C4", "C14", "D4", "D14", "E4", "F4", "F14", "G4", "G14", "A4", "A14", "B4",
            "C5", "C15", "D5", "D15", "E5", "F5", "F15", "G5", "G15", "A5", "A15", "B5"};
	static{
		initialize();
	}
	public static void initialize(){
		for(int i = 0; i < KEYS.length; i++){
			INSTRUMENTKEYSMAP.put(KEYS[i], VOICES[i]);
		}
		System.out.println(INSTRUMENTKEYSMAP);
	}
	public static String[] getVoices(){
		return VOICES;
	}
	public static String[] getKeys() {
		return KEYS;
	}
	public static String getVoice(String key){
		return INSTRUMENTKEYSMAP.get(key);
	}
}
