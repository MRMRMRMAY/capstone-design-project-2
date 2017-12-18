package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controllers.KeyController;
import models.capture.Capture;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private StudentModeFrame stdFrame;
	private Capture freeFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
		stdFrame = new StudentModeFrame();
		stdFrame.setMainJF(frame);
		freeFrame = new Capture();
		freeFrame.setMainJF(frame);
		Thread keyctrThread = new Thread(){
			public void run() {
				KeyController keyctr = new KeyController();
				keyctr.setJFrame(stdFrame);
				try {
					keyctr.serialStart();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		keyctrThread.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("student mode");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				stdFrame.setVisible(true);;//Jump to
			}
		});
		btnNewButton.setBounds(220, 100, 170, 60);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("free mode");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				freeFrame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(220, 199, 170, 60);
		frame.getContentPane().add(btnNewButton_1);
	}
}
