package countdata;
import java.util.Calendar;
public class Date {
	public static String getCurrentDate(){
		String date = null;
		Calendar c = Calendar.getInstance();
		return String.format("%02d%02d%02d%2d%2d%2d",
				c.get(Calendar.YEAR),
				c.get(Calendar.MONTH),
				c.get(Calendar.DATE),
				c.get(Calendar.HOUR),
				c.get(Calendar.MINUTE),
				c.get(Calendar.SECOND)
				);
	}
}
