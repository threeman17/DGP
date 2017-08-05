package b.keyListener;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import a.dao.UserInfoDao;
import a.service.GamePlayHistoryService;
import a.service.UserInfoService;
import a.view.GameMain;
import b.datas.GameTime;
import b.view.StartAPP;

public class TimerDate extends TimerTask{
	JFrame jf;
	GameKeyListener gkl;
	JLabel jl;
	int time;
	static Timer timer;
	public TimerDate(JFrame jf,GameKeyListener gkl,JLabel jl,int time,Timer timer){
		this.jf=jf;
		this.gkl=gkl;
		this.jl=jl;
		this.time=time;
		this.timer=timer;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		time--;
		System.out.println(time);
		if(time<=0) {
			time=0;
			timer.cancel();
			
		}
		jl.setText(String.valueOf(time));
		
		if(time==0) {
			showMess();
			setGamePlayHistory();
		}
	}
	public void showMess() {
		jf.removeKeyListener(gkl);
		int n=JOptionPane.showConfirmDialog(jf, "您挑战失败！点击确认重玩游戏，点击取消退出游戏","提示信息",JOptionPane.YES_NO_OPTION);
		if(n==0) {
			StartAPP.start();
		}else if (n==1){
			jf.dispose();
			new GameMain();
		}
		System.out.println(n);
	}
	public static Timer getTimer() {
		return timer;
		
	}
	public void setGamePlayHistory() {
		UserInfoService uis=new UserInfoService();
		GamePlayHistoryService gphs=new GamePlayHistoryService();
		
		int level=gphs.selrecord(UserInfoDao.getUser().getAccount(), "推箱子");
		
		new GamePlayHistoryService().insGamePlayHistory("推箱子", new Date(),GameTime.getGameTime(), 0, 0, 0, 0,level ,0);
	}
}
