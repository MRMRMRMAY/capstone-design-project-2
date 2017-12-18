package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import countdata.Keys;
public class StudentModeFrame extends JFrame {

	private JPanel contentPane;
	private String KeyList[];
	private JLabel lblReady;
	private Random random;
	private JFrame MainJF;
	private JButton btnBack;
	private final StudentModeFrame jframe = this;
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
	public void setMainJF(JFrame jf) {
		this.MainJF = jf;
	}
	/**
	 * Create the frame.
	 */
	public StudentModeFrame() {
		
		KeyList = Keys.getVoices();
		random = new Random();
		int randomVal = random.nextInt(KeyList.length);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainJF.setVisible(true);
				jframe.setVisible(false);
			}
		});
		btnBack.setBounds(17, 15, 76, 29);
		contentPane.add(btnBack);
		
		lblReady = new JLabel(KeyList[randomVal],JLabel.CENTER);
		lblReady.setBounds(17, 81, 725, 201);
		lblReady.setFont(new Font("Dialog",Font.BOLD, 40));
		System.out.println(lblReady.getText());
		contentPane.add(lblReady);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(17, 292, 800, 237);
		ImageIcon icon = new ImageIcon("image/piano.jpg");
		icon.setImage(icon.getImage().getScaledInstance(750,200,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
	}
	public void updateLable(String key) {
		String labletext = lblReady.getText();
		int randomVal = random.nextInt(KeyList.length);
		String val = Keys.getVoice(key);
		if(val.equals(labletext)) {
			lblReady.setText(KeyList[randomVal]);
		}
	}

}
