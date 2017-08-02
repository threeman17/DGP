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
	/**
	 * 获得当前玩家某个游戏的最高记录
	 * @param account
	 * @param game_name
	 * @return
	 */
	public int selrecord(String account ,String game_name) {
		GamePlayHistoryDao gphd=new GamePlayHistoryDao();
		
		Object value =gphd.selrecord(account, game_name);
		if(value==null) {
			return 1;
		}
		return Integer.parseInt(String.valueOf(value));
	}
	@Test
	public void demo() {
		System.out.println(new GamePlayHistoryService().selrecord("1", "推箱子"));
	}
}
