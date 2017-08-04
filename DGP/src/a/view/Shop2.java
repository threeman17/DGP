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
import a.service.GameInfoService;
import a.service.UserInfoService;
import b.view.StartAPP;

public class Shop2 extends JFrame {
	private JPanel bg;

	private int xx, yy;
	private boolean isDraging = false;
	
	
	public Shop2() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		backgroudInit();
		dragInit();
		checkClick();
		this.setVisible(true);
	}
	public void backgroudInit() {
		bg = new JPanel() {  
            @Override  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("img/shop.jpg");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
                  
            }  
        }; 
        bg.setSize(800,600);
        bg.setLayout(null);
        this.add(bg);
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

			private UserInfoService userservice=new UserInfoService();
			private GameInfoService gis=new GameInfoService("推箱子");
			int level=userservice.getUserLevel();
			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				if(x>30&&x<120 && y>261 && y<287) {
					//无名小卒
					int n=JOptionPane.showConfirmDialog(getThis(), "您确定要使用英雄[无名小卒]吗","提示信息",JOptionPane.YES_NO_OPTION);
					if(n==0) {
						gis.setSkin(UserInfoDao.getUser().getAccount(), 1);
						JOptionPane.showMessageDialog(getThis(), "恭喜！您已经装备英雄[无名小卒]", "提示", JOptionPane.PLAIN_MESSAGE);
					}
				}else if(x>440&&x<526 && y>261 && y<287) {
					//神秘宝箱
					int n=JOptionPane.showConfirmDialog(getThis(), "您确定要使用箱子[神秘宝箱]吗","提示信息",JOptionPane.YES_NO_OPTION);
					if(n==0) {
						gis.setBox(UserInfoDao.getUser().getAccount(), 1);
						JOptionPane.showMessageDialog(getThis(), "恭喜！您已经装备箱子[神秘宝箱]", "提示", JOptionPane.PLAIN_MESSAGE);
					}
				}else if(x>770&&x<800 && y>0 && y<28) {
					//右上角退出
					int n=JOptionPane.showConfirmDialog(getThis(), "您确定要退出个人仓库吗","提示信息",JOptionPane.YES_NO_OPTION);
					if(n==0) {
						getThis().dispose();
					}
				}else if(x>30&&x<120 &&y>533 && y<560) {
					//恶煞白虎
					if(level<5) {
						JOptionPane.showMessageDialog(getThis(), "你的等级不满足，无法使用", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					int n=JOptionPane.showConfirmDialog(getThis(), "您确定要使用英雄[恶煞白虎]吗","提示信息",JOptionPane.YES_NO_OPTION);
					if(n==0) {
						gis.setSkin(UserInfoDao.getUser().getAccount(), 2);
						JOptionPane.showMessageDialog(getThis(), "恭喜！您已经装备英雄[恶煞白虎]", "提示", JOptionPane.PLAIN_MESSAGE);
					}
				}else if(x>440&&x<526 && y>533 && y<560) {
					//上古灯笼
					if(level<5) {
						JOptionPane.showMessageDialog(getThis(), "你的等级不满足，无法使用", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					
					int n=JOptionPane.showConfirmDialog(getThis(), "您确定要使用箱子[上古灯笼]吗","提示信息",JOptionPane.YES_NO_OPTION);
					if(n==0) {
						gis.setBox(UserInfoDao.getUser().getAccount(), 2);
						JOptionPane.showMessageDialog(getThis(), "恭喜！您已经装备箱子[上古灯笼]", "提示", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			
		});
	}
	public Shop2 getThis() {
		return this;
	}
	public static void main(String[] args) {
		new Shop2();
	}
}

