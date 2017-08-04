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

import a.dao.UserInfoDao;
import a.service.UserInfoService;
import b.view.StartAPP;

public class GameMain extends JFrame {
	private JPanel bg;
	private JLabel close;
	private JLabel game1;
	private UserInfoService userservice=new UserInfoService();

	private int xx, yy;
	private boolean isDraging = false;
	
	
	public GameMain() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		backgroudInit();
		moreInit();
		dragInit();
		checkClick();
		this.setVisible(true);
	}
	public void backgroudInit() {
		bg = new JPanel() {  
            @Override  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("img/userinfo.jpg");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
                  
            }  
        }; 
        bg.setSize(800,600);
        bg.setLayout(null);
        this.add(bg);
	}
	public void moreInit() {
//		close=new JLabel(new ImageIcon("img/close.png"));
//		close.setLocation(745, 0);
//		close.setSize(54,53);
//		
//		bg.add(close);
//		close.addMouseListener(new MouseAdapter(){
//			public void mousePressed(MouseEvent e) {
//				int n=JOptionPane.showConfirmDialog(getThis(), "您确定要退出游戏平台吗","提示信息",JOptionPane.YES_NO_OPTION);
//				if(n==0) {
//					System.exit(0);
//				}
//			};
//		});
//		
//		game1=new JLabel(new ImageIcon("img/game1.png"));
//		game1.setSize(232,256);
//		game1.setLocation(0, 335);
//		bg.add(game1);
//		
//		game1.addMouseListener(new MouseAdapter(){
//			public void mousePressed(MouseEvent e) {
//				StartAPP.start();
//			};
//		});
		
		//用户名label
		JLabel username=new JLabel(userservice.getUserNickName(),JLabel.CENTER);
		username.setFont(new Font("微软雅黑", 0, 24));
		username.setForeground(Color.cyan);
		username.setSize(315, 35);
		username.setLocation(20, 88);
		bg.add(username);
		
		//等级与经验字体设置
		Font lae=new Font("微软雅黑", 0, 14);
		
		//等级label
		JLabel level=new JLabel("LV"+userservice.getUserLevel(),JLabel.CENTER);
		level.setFont(lae);
		level.setForeground(Color.WHITE);
		level.setSize(50, 20);
		level.setLocation(601, 142);
		bg.add(level);
		
		
		//积分label
		JLabel integral=new JLabel(userservice.Userintegral()+"",JLabel.CENTER);
		integral.setFont(lae);
		integral.setForeground(Color.WHITE);
		integral.setSize(50, 20);
		integral.setLocation(601, 172);
		bg.add(integral);
	};
	
	
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
				if(x>150&&x<225 && y>328 && y<360) {
					new Shop();
				}else if(x>226&&x<336 && y>328 && y<360) {
					new HistoryWindow(UserInfoDao.getUser().getAccount());
				}else if(x>747&&x<800 && y>0 && y<50) {
					int n=JOptionPane.showConfirmDialog(getThis(), "您确定要退出游戏平台吗","提示信息",JOptionPane.YES_NO_OPTION);
					if(n==0) {
						System.exit(0);
					}
				}else if(x>25&&x<195 && y>383 && y<558) {
					StartAPP.start();
				}
			}
			
		});
	}
	public GameMain getThis() {
		return this;
	}
}
