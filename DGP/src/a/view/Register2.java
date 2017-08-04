package a.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import a.service.MailService;
import a.service.UserInfoService;



public class Register2 extends JFrame {
	private int xx, yy;
	private boolean isDraging = false;
	
	private JPanel bg;
	private JTextField account;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;
	private JPasswordField confirempassword;
	Register2() {
		this.setSize(438, 655);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		backgroudInit();
		textInit();
		dragInit();
		checkClick();
		this.setVisible(true);
	}

	public void backgroudInit() {
		bg = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon("img/register.jpg");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());

			}
		};
		bg.setSize(438, 655);
		bg.setLayout(null);
		this.add(bg);
	}
	
	
	public void textInit() {
		
		Font f=new Font("微软雅黑", 0, 14);
		Color c=new Color(156, 157, 159);
		
		account=new JTextField();
		
		account.setFont(f);
		account.setForeground(c);
		account.setOpaque(false);
		account.setBorder(null);
		account.setSize(205,44);
		account.setLocation(143, 193);
		bg.add(account);
	
		username=new JTextField();
		
		username.setFont(f);
		username.setForeground(c);
		username.setOpaque(false);
		username.setBorder(null);
		username.setSize(205,44);
		username.setLocation(143, 251);
		bg.add(username);
		
		email=new JTextField();
		
		email.setFont(f);
		email.setForeground(c);
		email.setOpaque(false);
		email.setBorder(null);
		email.setSize(205,44);
		email.setLocation(143, 310);
		bg.add(email);
		
		password=new JPasswordField();
		password.setFont(f);
		password.setForeground(c);
		password.setOpaque(false);
		password.setBorder(null);
		password.setSize(205,44);
		password.setLocation(143, 365);
		bg.add(password);
		
		
		confirempassword=new JPasswordField();
		confirempassword.setFont(f);
		confirempassword.setForeground(c);
		confirempassword.setOpaque(false);
		confirempassword.setBorder(null);
		confirempassword.setSize(205,44);
		confirempassword.setLocation(143, 423);
		bg.add(confirempassword);
	}
	public void dragInit() {
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				isDraging = true;

				xx = e.getX();

				yy = e.getY();
			}

			public void mouseReleased(MouseEvent e) {

				isDraging = false;
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {

				if (isDraging) {

					int left = getLocation().x;

					int top = getLocation().y;

					setLocation(left + e.getX() - xx, top + e.getY() - yy);

				}
			}
		});
	}
	
	
	public void checkClick() {
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				if(x>398&&x<430 && y>6&&y<33) {
					System.exit(0);
				}else if(x>87&&x<347 && y>503&&y<547) {
					
					String accountstr=account.getText().trim();
					String usernamestr=username.getText().trim();
					String emailstr=email.getText().trim();
					String passwordstr=password.getText().trim();
					String confirmpasswordstr=confirempassword.getText().trim();
					if(accountstr.equals("")||usernamestr.equals("")||emailstr.equals("")||passwordstr.equals("")||confirmpasswordstr.equals("")) {
						JOptionPane.showMessageDialog(getThis(), "请将信息填写完整", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(!passwordstr.equals(confirmpasswordstr)) {
						JOptionPane.showMessageDialog(getThis(), "两次密码不一致", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(!emailstr.matches("^[A-Za-z0-9][\\w\\-\\.]{3,12}@([\\w\\-]+\\.)+[\\w]{2,3}$")) {
						System.out.println(emailstr);
						JOptionPane.showMessageDialog(getThis(), "邮箱格式不正确", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}
					//注册
					UserInfoService userService=new UserInfoService();
					boolean isUserExist=userService.isUserExist(accountstr);
					System.out.println(isUserExist);
					
					if(!isUserExist) {
						MailService.register(emailstr, usernamestr);
						userService.register(accountstr, usernamestr, passwordstr,emailstr);
						close();
						new Login2();
						
					}else {
						JOptionPane.showMessageDialog(getThis(), "用户名存在", "警告", JOptionPane.ERROR_MESSAGE);
					}
				}else if(x>220&&x<320 && y>384&&y<408) {
					close();
					new Register().setVisible(true);
				}
			}
			
		});
	}
	public void close() {
		this.dispose();
	}
	public Register2 getThis(){
		return this;
	}
	public static void main(String[] args) {
		new Register2();
	}
}
