package a.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import a.service.UserInfoService;
import a.service.UserInfoService;

import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/1.jpg")));
		setTitle("\u5806\u7CD6\u6E38\u620F\u5E73\u53F0--\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		panel.setForeground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String account=textField.getText().trim();
				String nickname=textField_1.getText().trim();
				String password=textField_2.getText().trim();
				
				UserInfoService userService=new UserInfoService();
				boolean isUserExist=userService.isUserExist(account);
				System.out.println(isUserExist);
				
				if(!isUserExist) {
					userService.register(account, nickname, password,"cewin95@foxmail.com");
					close();
					new Login().setVisible(true);;
				}else {
					JOptionPane.showMessageDialog(null, "用户名存在", "警告", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(74, 200, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				new Login().setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(223, 200, 93, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(60, 59, 107, 23);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 20));
		lblPassword.setBounds(60, 90, 107, 23);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(133, 61, 200, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(133, 92, 200, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(60, 123, 107, 23);
		panel.add(lblNewLabel_1);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(133, 125, 200, 23);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("email：");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(59, 156, 70, 15);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(133, 156, 200, 23);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("游戏注册");
		label.setForeground(Color.CYAN);
		label.setFont(new Font("幼圆", Font.BOLD | Font.ITALIC, 24));
		label.setBounds(162, 10, 107, 32);
		panel.add(label);
	}
	public void close() {
		this.dispose();
	}
}
