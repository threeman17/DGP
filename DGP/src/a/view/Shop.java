package a.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shop extends JFrame {

	private JPanel contentPane;
	private final JLabel label = new JLabel("皮肤简介");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Shop() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/1.jpg")));
		setTitle("\u5546\u57CE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		 

       contentPane = new JPanel();
       contentPane.setBackground(new Color(240,255,240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("丐帮长老");
		lblNewLabel.setBounds(33, 62, 54, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("shop/s1.png"));
		lblNewLabel_1.setBounds(33, 87, 54, 146);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("流氓兔");
		lblNewLabel_2.setBounds(242, 62, 54, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("恶煞白虎");
		lblNewLabel_4.setBounds(33, 236, 54, 15);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("皮肤四");
		lblNewLabel_5.setBounds(242, 236, 54, 15);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("shop/sx3.png"));
		lblNewLabel_6.setBounds(230, 87, 66, 135);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("shop/sx3.png"));
		lblNewLabel_7.setBounds(242, 266, 69, 117);
		panel.add(lblNewLabel_7);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 36, 2, 2);
		panel.add(scrollPane);
		label.setBounds(110, 53, 109, 33);
		panel.add(label);
		
		JLabel label_1 = new JLabel("皮肤简介");
		label_1.setBounds(321, 62, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("皮肤简介");
		label_2.setBounds(110, 227, 109, 33);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("皮肤简介");
		label_3.setBounds(321, 227, 109, 33);
		panel.add(label_3);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("shop/s2.png"));
		lblNewLabel_3.setBounds(33, 266, 66, 137);
		panel.add(lblNewLabel_3);
		
		JLabel label_4 = new JLabel("角色：");
		label_4.setBounds(33, 22, 54, 15);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("箱子：");
		label_5.setBounds(242, 23, 54, 15);
		panel.add(label_5);
		
		JButton button = new JButton("购买");
		button.setBounds(102, 194, 82, 39);
		panel.add(button);
		
		JButton button_1 = new JButton("购买");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setBounds(321, 194, 83, 39);
		panel.add(button_1);
		
		JButton button_2 = new JButton("购买");
		button_2.setBounds(102, 364, 82, 39);
		panel.add(button_2);
		
		JButton button_3 = new JButton("购买");
		button_3.setBounds(321, 364, 83, 39);
		panel.add(button_3);
		
		JLabel label_6 = new JLabel("所需积分：");
		label_6.setBounds(110, 119, 74, 39);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("所需积分：");
		label_7.setBounds(321, 119, 83, 39);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("所需积分：");
		label_8.setBounds(110, 282, 74, 39);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("所需积分：");
		label_9.setBounds(321, 282, 83, 39);
		panel.add(label_9);
	}
	
}
