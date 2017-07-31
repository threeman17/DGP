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

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField textField_2;

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
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String account=textField.getText().trim();
				String nickname=textField_1.getText().trim();
				String password=textField_2.getText().trim();
				
				UserInfoService userService=new UserInfoService();
				boolean isUserExist=userService.isUserExist(account);
				System.out.println(isUserExist);
				
				if(!isUserExist) {
					userService.register(account, nickname, password);
					close();
					new Login().setVisible(true);;
				}else {
					JOptionPane.showMessageDialog(null, "用户名存在", "警告", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(68, 199, 93, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u767B\u5F55");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				close();
				new Login().setVisible(true);
			}
			
		});
		btnNewButton_1.setBounds(247, 199, 93, 23);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 23, 107, 32);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblPassword.setFont(new Font("����", Font.PLAIN, 20));
		lblPassword.setBounds(31, 74, 107, 32);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(162, 26, 200, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 77, 200, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(31, 130, 107, 32);
		panel.add(lblNewLabel_1);
		
		textField_2 = new JPasswordField();
		textField_2.setBounds(162, 133, 200, 32);
		panel.add(textField_2);
		textField_2.setColumns(10);
	}
	public void close() {
		this.dispose();
	}
}
