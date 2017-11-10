package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import interfacePackage.MusicPlayer;

public class RecordFunction extends JFrame {
	private BufferedReader input;
	MusicPlayer player = null;
	public RecordFunction(){
		player = new PianoPlayer();
	}
	public File getFile() {
		final JFileChooser fc = new JFileChooser("./");
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		// JFileChooser.FILES_ONLY
		// JFileChooser.DIRECTORIES_ONLY
		int returnVal = fc.showOpenDialog(this);
		File file_choosed = fc.getSelectedFile();
		return file_choosed;
	}

	public void play(File file) {
		Thread t = new Thread() {
			public void run() {
				try {
					input = Files.newBufferedReader(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
					String line = null;
					while ((line = input.readLine()) != null) {
						player.stop();
						System.out.println(line);
						player.play(line);
						TimeUnit.MILLISECONDS.sleep(500);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		t.start();
	}

//	public static void main(String varg[]) {
//		Thread t = new Thread() {
//			public void run() {
//				RecordFunction main = new RecordFunction();
//				File file = main.getFile();
//				main.play(file);
//			}
//		};
//		t.start();
//	}
}