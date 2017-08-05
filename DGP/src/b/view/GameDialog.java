package b.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a.service.UserInfoService;
import a.view.GameMain;
import a.view.Register2;

public class GameDialog extends JDialog {
	private int xx, yy;
	private boolean isDraging = false;
	
	private JFrame jf;
	private JPanel bg;
	private String src;
	public GameDialog(JFrame jf,String src) {
		this.jf=jf;
		this.src=src;
		setSize(276,351);
		setUndecorated(true);
		localInit();
		dragInit();
		backgroudInit();
		checkClick();
		setVisible(true);
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
	
	public void localInit() {
		if(jf==null) {
			return;
		}
		Point point;
	    point = jf.getLocation();//获得主窗体在屏幕的坐标
	      this.setLocation(
	        point.x + jf.getWidth()/2 - this.getWidth()/2, 
	        point.y + jf.getHeight()/2 - this.getHeight()/2);
	}
	
	
	public void backgroudInit() {
		bg = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(src);
				Image img = icon.getImage();
				g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());

			}
		};
		bg.setSize(276, 351);
		bg.setLayout(null);
		this.add(bg);
	}
	
	public void checkClick() {
		JDialog jd=this;
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				if(x>0&&x<276 && y>300&&y<351) {
					jd.dispose();
				}
			}
			
		});
	}
}
