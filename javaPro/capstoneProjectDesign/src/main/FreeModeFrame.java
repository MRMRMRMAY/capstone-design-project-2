package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FreeModeFrame extends JFrame {

	private JPanel contentPane;
	private JFrame MainJF;
	private final FreeModeFrame jframe = this;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FreeMode frame = new FreeMode();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public void setMainJF(JFrame jf) {
		this.MainJF = jf;
	}
	public FreeModeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jframe.setVisible(false);
				MainJF.setVisible(true);
			}
		});
		btnBack.setBounds(17, 15, 76, 29);
		contentPane.add(btnBack);
		
		JLabel lblReady = new JLabel("Ready",JLabel.CENTER);
		lblReady.setBounds(17, 81, 725, 201);
		lblReady.setFont(new Font("Dialog",Font.BOLD, 40));
		contentPane.add(lblReady);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(17, 292, 800, 237);
		ImageIcon icon = new ImageIcon("image/piano.jpg");
		icon.setImage(icon.getImage().getScaledInstance(750,200,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
	}
}
