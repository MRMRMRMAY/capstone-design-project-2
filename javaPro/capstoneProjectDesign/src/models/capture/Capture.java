package models.capture;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.prefs.Preferences;
import java.awt.Button;
import java.awt.Frame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import countdata.ButtonLableClass;
import countdata.Date;

public class Capture extends Frame {
	final String SUFFIX = ".wav";
	// final String DIRNAME = "record/";
	boolean stopCapture = false; // ����¼����־
	AudioFormat audioFormat; // ¼����ʽ
	// ��ȡ���ݣ���TargetDataLineд��ByteArrayOutputStream¼��
	ByteArrayOutputStream byteArrayOutputStream;
	int totaldatasize = 0;
	TargetDataLine targetDataLine;
	// �������ݣ���AudioInputStreamд��SourceDataLine����
	AudioInputStream audioInputStream;
	SourceDataLine sourceDataLine;
	String filepath = null;

	public Capture() {
		// ������ť
		sourceDataLine = null;
		final Button captureBtn = new Button(ButtonLableClass.CAPTURE);
		final Button stopBtn = new Button(ButtonLableClass.STOP);
		final Button playBtn = new Button(ButtonLableClass.PLAY);
		final Button saveBtn = new Button(ButtonLableClass.SAVE);
		captureBtn.setEnabled(true);
		stopBtn.setEnabled(false);
		playBtn.setEnabled(false);
		saveBtn.setEnabled(false);
		// ע��¼���¼�
		captureBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captureBtn.setEnabled(false);
				stopBtn.setEnabled(true);
				playBtn.setEnabled(false);
				saveBtn.setEnabled(false);
				// ��ʼ¼��
				capture();
			}
		});
		add(captureBtn);
		// ע��ֹͣ�¼�
		stopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				captureBtn.setEnabled(true);
				stopBtn.setEnabled(false);
				playBtn.setEnabled(true);
				saveBtn.setEnabled(true);
				// ֹͣ¼��
				stop();
			}
		});
		add(stopBtn);
		// ע�Ქ���¼�
		playBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����¼��
				play();
			}
		});
		add(playBtn);
		// ע�ᱣ���¼�
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ����¼��
				save();
			}
		});
		add(saveBtn);
		// ע�ᴰ��ر��¼�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// ���ô�������
		setLayout(new FlowLayout());
		setTitle("¼��������");
		setSize(350, 70);
		setVisible(true);
	}

	// ��1��¼���¼������浽ByteArrayOutputStream��
	private void capture() {
		// filepath = String.format("%s%s%s", DIRNAME, Date.getCurrentDate(),
		// SUFFIX);
		try {
			// ��¼��
			audioFormat = getAudioFormat();
			DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
			targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
			targetDataLine.open(audioFormat);
			targetDataLine.start();
			// ���������߳̽���¼��
			Thread captureThread = new Thread(new CaptureThread());
			captureThread.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	// ��2������ByteArrayOutputStream�е�����
	private void play() {
		try {
			// ȡ��¼������
			byte audioData[] = byteArrayOutputStream.toByteArray();
			// ת����������
			InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
			AudioFormat audioFormat = getAudioFormat();
			audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
					audioData.length / audioFormat.getFrameSize());
			DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
			sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
			sourceDataLine.open(audioFormat);
			sourceDataLine.start();
			// ���������߳̽��в���
			Thread playThread = new Thread(new PlayThread());
			playThread.start();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	// ��3��ֹͣ¼��
	public void stop() {
		stopCapture = true;
	}

	// ��4�������ļ�
	public void save() {
		// ȡ��¼��������
		AudioFormat audioFormat = getAudioFormat();
		byte audioData[] = byteArrayOutputStream.toByteArray();
		InputStream byteArrayInputStream = new ByteArrayInputStream(audioData);
		audioInputStream = new AudioInputStream(byteArrayInputStream, audioFormat,
				audioData.length / audioFormat.getFrameSize());
		// д���ļ�
		try {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.wav", "wav");
			JFileChooser fc = new JFileChooser(new File("./"));
			fc.setFileFilter(filter);
			fc.setMultiSelectionEnabled(false);
			int result = fc.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				if (!file.getPath().endsWith(SUFFIX)) {
					file = new File(file.getPath() + SUFFIX);
				}
				System.out.println("file path=" + file.getPath());
				if (file.exists()) {
					int i = JOptionPane.showConfirmDialog(Capture.this, "���ļ��Ѿ����ڣ�ȷ��Ҫ������");
					if (i == JOptionPane.YES_OPTION)
						;
					else
						return;
				} else {
					file.createNewFile();
				}
				AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ȡ��AudioFormat
	private AudioFormat getAudioFormat() {
		float sampleRate = 16000.0F;
		// 8000,11025,16000,22050,44100
		// int sampleSizeInBits = 16;
		int sampleSizeInBits = 8;
		// 8,16
		// int channels = 1;
		int channels = 2;
		// 1,2
		boolean signed = true;
		// true,false
		// boolean bigEndian = false;
		boolean bigEndian = true;
		// true,false
		return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
	}

	class CaptureThread extends Thread {
		// ��ʱ����
		byte tempBuffer[] = new byte[10000];

		public void run() {
			byteArrayOutputStream = new ByteArrayOutputStream();
			totaldatasize = 0;
			stopCapture = false;
			try {// ѭ��ִ�У�ֱ������ֹͣ¼����ť
				while (!stopCapture) {
					// ��ȡ10000������
					int cnt = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
					if (cnt > 0) {
						// ���������
						byteArrayOutputStream.write(tempBuffer, 0, cnt);
						totaldatasize += cnt;
					}
				}
				byteArrayOutputStream.close();
				targetDataLine.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

	class PlayThread extends Thread {
		byte tempBuffer[] = new byte[10000];

		public void run() {
			try {
				int cnt;
				// ��ȡ���ݵ���������
				while ((cnt = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
					if (cnt > 0) {
						// д�뻺������
						sourceDataLine.write(tempBuffer, 0, cnt);
					}
				}
				// Block�ȴ���ʱ���ݱ����Ϊ��
				sourceDataLine.drain();
				sourceDataLine.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}
}
//
// package models.capture;
//
// import java.io.IOException;
// import java.util.Vector;
// import javax.media.CaptureDeviceInfo;
// import javax.media.CaptureDeviceManager;
// import javax.media.DataSink;
// import javax.media.Manager;
// import javax.media.MediaLocator;
// import javax.media.NoDataSinkException;
// import javax.media.NoProcessorException;
// import javax.media.Processor;
// import javax.media.control.StreamWriterControl;
// import javax.media.format.AudioFormat;
// import javax.media.protocol.DataSource;
// import javax.media.protocol.FileTypeDescriptor;
//
//
// public class Capture {
// public static void main(String[] args) {
// CaptureDeviceInfo di = null;
// Processor p = null;
// StateHelper sh = null;
// // ��ѯCaptureDeviceManager������λ����Ҫʹ�õ�ý��ɼ��豸��
// Vector deviceList = CaptureDeviceManager.getDeviceList(new
// AudioFormat(AudioFormat.LINEAR, 44100, 16, 2));
// if (deviceList.size() > 0) {
// // �õ����豸��CaptureDeviceInfoʵ����
// di = (CaptureDeviceInfo) deviceList.firstElement();
// } else
// // �Ҳ������㣨linear, 44100Hz, 16 bit,stereo audio.����Ƶ�豸���˳���
// System.out.println("There is not any audio device");
// System.exit(-1);
// try {
// // ���MediaLocator�����ɴ˴���һ��Processor��
// p = Manager.createProcessor(di.getLocator());
// sh = new StateHelper(p);
// } catch (IOException e) {
// e.printStackTrace();
// System.exit(-1);
// } catch (NoProcessorException e) {
// e.printStackTrace();
// System.exit(-1);
// }
// // Configure the processor
// if (!sh.configure(10000)) {
// System.out.println("configure wrong!");
// System.exit(-1);
// }
// // ������洢��ý����������ͣ�content type����
// p.setContentDescriptor(new FileTypeDescriptor(FileTypeDescriptor.WAVE));
// // realize the processor.
// if (!sh.realize(10000)) {
// System.out.println("realize wrong!");
// System.exit(-1);
// }
// // get the output of the processor
// DataSource source = p.getDataOutput();
// // ����洢��ý����ļ���
// MediaLocator dest = new MediaLocator(new
// java.lang.String("file:///F:/Dvp/workspace/JavaSoundMedia/foo.wav"));
// // ����һ�����ݳ�
// DataSink filewriter = null;
// try {
// filewriter = Manager.createDataSink(source, dest);
// filewriter.open();
// } catch (NoDataSinkException e) {
// e.printStackTrace();
// System.exit(-1);
// } catch (IOException e) {
// e.printStackTrace();
// System.exit(-1);
// } catch (SecurityException e) {
// e.printStackTrace();
// System.exit(-1);
// }
// // if the Processor implements StreamWriterControl, we can
// // call setStreamSizeLimit
// // to set a limit on the size of the file that is written.
// StreamWriterControl swc = (StreamWriterControl)
// p.getControl("javax.media.control.StreamWriterControl");
// // set limit to 5MB
// if (swc != null)
// swc.setStreamSizeLimit(5000000);
// // now start the filewriter and processor
// try {
// filewriter.start();
// } catch (IOException e) {
// e.printStackTrace();
// System.exit(-1);
// }
// // Capture for 5 seconds
// sh.playToEndOfMedia(5000);
// sh.close();
// // Wait for an EndOfStream from the DataSink and close it...
// filewriter.close();
// }
// }