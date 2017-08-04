package b.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import a.dao.UserInfoDao;
import a.service.GameInfoService;
import a.service.GamePlayHistoryService;
import b.datas.Datas;
import b.keyListener.GameKeyListener;
import b.model.Barrier;
import b.model.Box;
import b.model.Destination;
import b.model.Hero;

public class MainUI extends JFrame{
	private JPanel bg;
	private Hero hero;
	int[][] datas=new int[12][16];
	JLabel[][] boxs=new JLabel[12][16]; 
	public MainUI main;
//	Map<Integer, Integer> des=new HashMap<Integer, Integer>();
	LinkedList<Integer> des=new LinkedList<Integer>();
	
	
	private int xx, yy;
	private boolean isDraging = false;
	
	GamePlayHistoryService gphs=new GamePlayHistoryService();
	int level=gphs.selrecord(UserInfoDao.getUser().getAccount(), "推箱子");
	public MainUI() {
		backgroudInit();
		heroInit();
		mainUIInit();
		DigInit();
		this.addKeyListener(new GameKeyListener(hero,boxs,des,main));
	}
	public void mainUIInit() {
		this.setLayout(null);
		this.setTitle("推箱子");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.dragInit();
		this.setVisible(true);
		
	}
	public void backgroudInit() {
		bg = new JPanel() {  
            @Override  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("img/bg"+level+".jpg");  
                Image img = icon.getImage();  
                g.drawImage(img, 0, 0, icon.getIconWidth(), icon.getIconHeight(), icon.getImageObserver());  
                  
            }  
        }; 
        bg.setSize(800,600);
        bg.setLayout(null);
        this.add(bg);
	}
	public void heroInit() {
		System.out.println("初始化");
//		for (int i = 0; i < Datas.pass1.length; i++) {
//			for (int j = 0; j < Datas.pass1[i].length; j++) {
//				datas[i][j]=Datas.pass1[i][j];
//			}
//		}
		datas=Datas.getGameLevel();
		GameInfoService gis=new GameInfoService("推箱子");
		System.out.println("人物是"+gis.getCurrentGameInfo().getCurrent_skin());
		System.out.println("皮肤是"+gis.getCurrentGameInfo().getCurrent_box());
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if(datas[i][j]==1) {
					bg.add(new Barrier(j, i, "img/ob"+level+".png").getJLabel());
				}else if(datas[i][j]==2) {
					hero=new Hero(j, i, "img/0"+gis.getCurrentGameInfo().getCurrent_skin()+"3.png");
					System.out.println("img/0"+gis.getCurrentGameInfo().getCurrent_skin()+"3.png");
					bg.add(hero.getJLabel());
				}else if(datas[i][j]==3) {
					JLabel temp=new Box(j, i, "img/box"+gis.getCurrentGameInfo().getCurrent_box()+".png").getJLabel();
					boxs[i][j]=temp;
					bg.add(temp);
				}else if(datas[i][j]==4) {
					bg.add(new Destination(j, i, "img/target.png").getJLabel());
//					des.put(i, j);
					des.add(i);
					des.add(j);
					System.out.println(des);
				}
			}
		}
	}
	public void ag() {
//		main.dispose();
//		main=new MainUI();
		System.out.println("ag"+main);
	}
	
	public void DigInit() {
		// 弹窗
		
		
		if(level!=1) {
			return;
		}
		JDialog victory = new JDialog(this,"欢迎你来到推箱子游戏",true);
		victory.setSize(400, 300);
		victory.setLocationRelativeTo(null);
		victory.setLayout(null);
		
//		JLabel info = new JLabel(new ImageIcon("gg.jpg"));
//		info.setBounds(2, 2, 380, 180);
//		victory.add(info);
//		
//		JLabel click = new JLabel(new ImageIcon("gg2.jpg"));
//		click.setBounds(2, 182, 380, 88);
//		click.addMouseListener(new MouseAdapter(){
//			public void mousePressed(MouseEvent e) {
//				try {
//					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler http://www.baidu.com");
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		victory.add(click);
		
		
//		JLabel username=new JLabel(userservice.getUserNickName(),JLabel.CENTER);
//		username.setFont(new Font("微软雅黑", 0, 24));
//		username.setForeground(Color.cyan);
//		username.setSize(315, 35);
//		username.setLocation(20, 88);
//		bg.add(username);
		String str="推箱子是一个来自日本的古老游戏，"
				+ "目的是在训练你的逻辑思考能力。在一个狭小的仓库中，"
				+ "要求把木箱放到指定的位置，"
				+ "稍不小心就会出现箱子无法移动或者通道被堵住的情况，"
				+ "所以需要巧妙的利用有限的空间和通道，合理安排移动的次序和位置，"
				+ "才能顺利的完成任务。我们会根据你的移动的步数和事件来计算最后的积分与经验，祝你好运！";
		JTextArea info=new JTextArea(str);
		info.setSize(380,180);
		info.setFont(new Font("微软雅黑", 0, 14));
		info.setLineWrap(true);
		info.setEditable(false);
		info.setOpaque(false);
		victory.add(info);
		victory.setVisible(true);
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
}
