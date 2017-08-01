package b.keyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a.dao.UserInfoDao;
import a.service.GamePlayHistoryService;
import a.service.UserInfoService;
import b.datas.Datas;
import b.model.Box;
import b.model.Hero;
import b.view.MainUI;
import b.view.StartAPP;

public class GameKeyListener extends KeyAdapter{
	private Hero hero;
	private int x;
	private int y;
	private int[][] datas=new int[12][16];
	private JLabel[][] boxs;
//	Map<Integer, Integer> des;
	List<Integer> des;
	MainUI main;
	long startGameTime;
	long endGameTime;
	Date currentDate;
	public GameKeyListener(Hero hero,JLabel[][] boxs,List<Integer> des,MainUI main) {
		super();
		this.hero = hero;
		this.x=hero.getX();
		this.y=hero.getY();
		this.boxs=boxs;
		this.des=des;
		this.main=main;
//		for (int i = 0; i < Datas.pass1.length; i++) {
//			for (int j = 0; j < Datas.pass1[i].length; j++) {
//				datas[i][j]=Datas.pass1[i][j];
//			}
//		}
		
		startGameTime=System.currentTimeMillis();
		currentDate=new Date();
		
		
		datas=Datas.ergodic(Datas.pass2);
		System.out.println("des长度"+des.size());
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				System.out.print(datas[i][j]);
			}
			System.out.println();
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		super.keyPressed(e);
		int key = e.getKeyCode();
		if(key == 39) {
			hero.setHeroPic("img/wolf-ym.png");
			if(datas[y][x+1]==1) {
				return;
			}else if(datas[y][x+1]==3 || datas[y][x+1]==5) {
				if(datas[y][x+2]==1 || datas[y][x+2]==3 || datas[y][x+2]==5) {
					return;
				}else {
					if(datas[y][x+2]==4) {
						datas[y][x+2]=5;
					}else {
						datas[y][x+2]=3;
					}
					
					
//					box1.getJl().setLocation((x+2)*50,y*50 );
					boxs[y][x+2]=boxs[y][x+1];
					boxs[y][x+1]=null;
					boxs[y][x+2].setLocation((x+2)*50,y*50);
					
					
				}
			}
			
			
			
			datas[y][x]=0;
			x++;
			datas[y][x]=2;
			hero.getJl().setLocation(x*50, y*50);
			againDes();
			checkSuss();
		}else if(key ==37) {
			hero.setHeroPic("img/wolf-zb.png");
			if(datas[y][x-1]==1) {
				return;
			}else if(datas[y][x-1]==3 || datas[y][x-1]==5) {
				if(datas[y][x-2]==1 || datas[y][x-2]==3 || datas[y][x-2]==5) {
					return;
				}else {
					if(datas[y][x-2]==4) {
						datas[y][x-2]=5;
					}else {
						datas[y][x-2]=3;
					}
//					box1.getJl().setLocation((x-2)*50,y*50 );
					boxs[y][x-2]=boxs[y][x-1];
					boxs[y][x-1]=null;
					boxs[y][x-2].setLocation((x-2)*50,y*50);
				}
			}
			
			datas[y][x]=0;
			x--;
			datas[y][x]=2;
			hero.getJl().setLocation(x*50, y*50);
			againDes();
			checkSuss();
		}else if(key==38) {
			hero.setHeroPic("img/wolf-sm.png");
			if(datas[y-1][x]==1) {
				return;
			}else if(datas[y-1][x]==3 || datas[y-1][x]==5) {
				if(datas[y-2][x]==1 || datas[y-2][x]==3 || datas[y-2][x]==3) {
					return;
				}else {
					if(datas[y-2][x]==4) {
						datas[y-2][x]=5;
					}else {
						datas[y-2][x]=3;
					}
					
					
//					datas[y-2][x]=3;
//					box1.getJl().setLocation(x*50,(y-2)*50 );
					boxs[y-2][x]=boxs[y-1][x];
					boxs[y-1][x]=null;
					boxs[y-2][x].setLocation(x*50,(y-2)*50);
				}
			}
			
			
			datas[y][x]=0;
			y--;
			datas[y][x]=2;
			hero.getJl().setLocation(x*50, y*50);
			againDes();
			checkSuss();
		}else if(key==40) {
			hero.setHeroPic("img/wolf-zm.png");
			if(datas[y+1][x]==1) {
				return;
			}else if(datas[y+1][x]==3 || datas[y+1][x]==5) {
				if(datas[y+2][x]==1 || datas[y+2][x]==3 || datas[y+2][x]==5) {
					return;
				}else {
					if(datas[y+2][x]==4) {
						datas[y+2][x]=5;
					}else {
						datas[y+2][x]=3;
					}
					
					
//					datas[y+2][x]=3;
//					box1.getJl().setLocation(x*50,(y+2)*50 );
					
					boxs[y+2][x]=boxs[y+1][x];
					boxs[y+1][x]=null;
					boxs[y+2][x].setLocation(x*50,(y+2)*50);
				}
			}
			
			
			datas[y][x]=0;
			y++;
			datas[y][x]=2;
			hero.getJl().setLocation(x*50, y*50);
			againDes();
			checkSuss();
		}

		System.out.println(x+"..."+y);
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				System.out.print(datas[i][j]);
			}
			System.out.println();
		}
	}
	/*
	 *根据最初始的数据，保存重点坐标信息，没移动一次，就重绘。 
	 */
	public void againDes() {
		
		if(des!=null) {
//			Set<Integer> set=des.keySet();
//			for (Integer key : set) {
//				if(datas[key][des.get(key)]!=2 && datas[key][des.get(key)]!=5) {
//					datas[key][des.get(key)]=4;
//				}
//				
//			}
			
			for (int i = 0; i < des.size(); i+=2) {
				if(datas[des.get(i)][des.get(i+1)]!=2 && datas[des.get(i)][des.get(i+1)]!=5) {
					datas[des.get(i)][des.get(i+1)]=4;
				}
			}
		}
	}
	public void checkSuss() {
		int count=0;
		for (int i = 0; i < datas.length; i++) {
			for (int j = 0; j < datas[i].length; j++) {
				if(datas[i][j]==5) {
					count++;
					if(count==des.size()/2) {
						System.out.println("胜利了");
//						System.exit(0);
//						MainUI.main.dispose();
//						MainUI.ag();
//						main.ag();
//						return;
//						main.disable();
//						new MainUI();
//						main.removeKeyListener(this);
//						JDialog victory = new JDialog(main,"恭喜你取得了胜利!",true);
//						victory.setSize(400, 300);
//						victory.setLocationRelativeTo(null);
//						victory.setLayout(null);
//						victory.setVisible(true);
//						main.ag();
//						JOptionPane.showConfirmDialog(main, "恭喜你获得胜利");
						endGameTime=System.currentTimeMillis();
						int GameTime=(int) (endGameTime-startGameTime)/1000;
						int integral=GameTime>500?1000:(6000-GameTime*10);
						
						
						UserInfoService uis=new UserInfoService();
						new GamePlayHistoryService().insGamePlayHistory("推箱子", currentDate, GameTime, integral, 0, integral, 0, 1);
						uis.upduser(UserInfoDao.getUser().getAccount(), integral, integral);
						int n = JOptionPane.showConfirmDialog(null, "在"+GameTime+"秒拿到了"+integral+"经验。需要继续下一关吗?", "恭喜"+uis.getUserNickName()+"获得了胜利",JOptionPane.YES_NO_OPTION);//i=0/1  
						StartAPP.close();
						if(n==0) {
							StartAPP.start();
						}
						
//						new MainUI();
					}
				}
			}
		}
	}

}
