package countdata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pianokeys {
	public static Map<Integer,String> PIANOKEYSMAP = new HashMap<Integer,String>();
	final int KEYS[] = {48,49,50,51,52,53,54};
	final String VOICES[] = {"C3","D3","E3","F3","G3","A3","B3"};
	public Pianokeys(){
		initialize();
	}
	public void initialize(){
		for(int i = 0; i < KEYS.length; i++){
			PIANOKEYSMAP.put(KEYS[i], VOICES[i]);
		}
	}
}
