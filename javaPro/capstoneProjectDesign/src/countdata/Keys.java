package countdata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Keys {
	public static Map<Integer,String> INSTRUMENTKEYSMAP = new HashMap<Integer,String>();
	final int KEYS[] = {48,49,50,51,52,53,54};
	static final String VOICES[] = {"C3","D3","E3","F3","G3","A3","B3"};
	public Keys(){
		initialize();
	}
	public void initialize(){
		for(int i = 0; i < KEYS.length; i++){
			INSTRUMENTKEYSMAP.put(KEYS[i], VOICES[i]);
		}
	}
	public static String[] getVoices(){
		return VOICES;
	}
	public String getVoice(int key){
		return INSTRUMENTKEYSMAP.get(key);
	}
	
	
}
