package main;
import java.util.ArrayList;
import java.util.Enumeration;
import controllers.KeyController;
import gnu.io.CommPortIdentifier;
import models.capture.Capture;
public class DianoMain {
	public static void main(String[] args){
		Thread keyctrThread = new Thread(){
			public void run() {
				KeyController keyctr = new KeyController();
				try {
					keyctr.serialStart();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		keyctrThread.start();
		new Capture();
	}
}
