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

import a.service.UserInfoService;



public class Login2 extends JFrame {
	private int xx, yy;
	private boolean isDraging = false;
	
	private JPanel bg;
	private JTextField username;
	private JPasswordField password;
	Login2() {
		this.setSize(438, 475);
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
				ImageIcon icon = new ImageIcon("img/login.jpg");
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());

			}
		};
		bg.setSize(438, 475);
		bg.setLayout(null);
		this.add(bg);
	}
	
	
	public void textInit() {
		
		Font f=new Font("微软雅黑", 0, 14);
		Color c=new Color(156, 157, 159);
	
		username=new JTextField();
		
		username.setFont(f);
		username.setForeground(c);
		username.setOpaque(false);
		username.setBorder(null);
		username.setSize(205,44);
		username.setLocation(143, 193);
		bg.add(username);
		
		password=new JPasswordField();
		password.setFont(f);
		password.setForeground(c);
		password.setOpaque(false);
		password.setBorder(null);
		password.setSize(205,44);
		password.setLocation(143, 251);
		bg.add(password);
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
				}else if(x>87&&x<347 && y>331&&y<375) {
					
					
					String usernamestr=username.getText().trim();
					String passwordstr=password.getText().trim();
					if(usernamestr.equals("")||passwordstr.equals("")) {
						JOptionPane.showMessageDialog(getThis(), "账号或者密码不能为空", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}
					UserInfoService user=new UserInfoService();
					boolean isUser=user.login(usernamestr,passwordstr);
					if(!isUser) {
						JOptionPane.showMessageDialog(getThis(), "账号或者密码错误", "警告", JOptionPane.ERROR_MESSAGE);
					}else {
						close();
						new GameMain();
					}
				}else if(x>220&&x<320 && y>384&&y<408) {
					close();
					new Register2();
				}
			}
			
		});
	}
	public void close() {
		this.dispose();
	}
	public Login2 getThis(){
		return this;
	}
	public static void main(String[] args) {
		new Login2();
	}
}
