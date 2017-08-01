package b.view;


import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


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
	public MainUI() {
		backgroudInit();
		heroInit();
		mainUIInit();
		this.addKeyListener(new GameKeyListener(hero,boxs,des,main));
	}
	public void mainUIInit() {
		this.setLayout(null);
		this.setTitle("推箱子");
		this.setSize(816, 640);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	public void backgroudInit() {
		bg = new JPanel() {  
            @Override  
            protected void paintComponent(Graphics g) {  
                ImageIcon icon = new ImageIcon("img/bg.png");  
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
		datas=Datas.ergodic(Datas.pass2);
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if(datas[i][j]==1) {
					bg.add(new Barrier(j, i, "img/tree.png").getJLabel());
				}else if(datas[i][j]==2) {
					hero=new Hero(j, i, "img/0-1.png");
					bg.add(hero.getJLabel());
				}else if(datas[i][j]==3) {
					JLabel temp=new Box(j, i, "img/sheep-no.png").getJLabel();
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
	
	
	
	
}
