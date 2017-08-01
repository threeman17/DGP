package a.service;

import java.util.Date;

import org.junit.Test;

import a.bean.GamePlayHistory;
import a.dao.GamePlayHistoryDao;
import a.dao.UserInfoDao;

public class GamePlayHistoryService {
	/**
	 * 插入一条游戏记录
	 * @param game_name
	 * @param start_time
	 * @param play_min
	 * @param integral
	 * @param integral_factor
	 * @param xp
	 * @param xp_factor
	 * @param record
	 */
	public void insGamePlayHistory(String game_name,Date start_time,int play_min,int integral,double integral_factor,int xp,double xp_factor,int record) {
		GamePlayHistory gph=new GamePlayHistory();
		
		gph.setAccount(UserInfoDao.getUser().getAccount());
		gph.setGame_name(game_name);
		gph.setStart_time(start_time);
		gph.setPlay_min(play_min);
		gph.setIntegral_get(integral);
		gph.setIntegral_gain_factor(integral_factor);
		gph.setXp_get(xp);
		gph.setXp_gain_factor(xp_factor);
		gph.setRecord(record);
		
		new GamePlayHistoryDao().insGamePlayHistory(gph);;
	}
	@Test
	public void demo() {
		new GamePlayHistoryService().insGamePlayHistory("推箱子", new Date(), 1000, 1200, 0.2, 500, 0.4, 1);
	}
}
