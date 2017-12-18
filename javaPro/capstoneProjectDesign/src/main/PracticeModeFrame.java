package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import countdata.Book;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PracticeModeFrame extends JFrame {

	private JPanel contentPane;
	private JFrame MainJF;
	private final PracticeModeFrame jframe = this;
	private JLabel lblReady;
	final ImageIcon[] icons = new ImageIcon[Book.bookTitle.length];
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
	public PracticeModeFrame() {
		for(int i = 0; i < Book.bookTitle.length; i++) {
			URL path = null;

				//path = new URL();
				icons[i] = new ImageIcon("image/book/"+Book.bookTitle[i]+".jpg");
				//icons[i].setImage(icons[i].getImage().getScaledInstance(200,750,Image.SCALE_DEFAULT));
				System.out.println(icons[i]);
		
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 839, 1078);
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
		
		lblReady = new JLabel("",JLabel.CENTER);
		lblReady.setBounds(17, 81, 725, 717);
		lblReady.setIcon(icons[0]);
		//lblReady.setFont(new Font("Dialog",Font.BOLD, 40));
		contentPane.add(lblReady);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(17, 785, 800, 237);
		ImageIcon icon = new ImageIcon("image/piano.jpg");
		icon.setImage(icon.getImage().getScaledInstance(750,200,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icon);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(275, 16, 209, 27);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				//temp.setImage(	(400,700,Image.SCALE_DEFAULT));
				lblReady.setIcon(icons[index]);
				lblReady.getIcon();
				System.out.println(index+lblReady.getIcon().toString());
			}
		});
		for(String img : Book.bookTitle)
			comboBox.addItem(img);
		contentPane.add(comboBox);
	}
}
