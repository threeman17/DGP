package a.service;

import org.junit.Test;

import a.bean.GameInfo;
import a.dao.GameInfoDao;
import a.dao.UserInfoDao;

public class GameInfoService {
	String game_name;
	public GameInfoService(String game_name) {
		this.game_name=game_name;
	}
	public GameInfo getCurrentGameInfo() {
		return new GameInfoDao().getCurrentGameInfo(UserInfoDao.getUser().getAccount(), game_name);
	}
	
	@Test
	public void demo(){
//		System.out.println(new GameInfoService().getCurrentGameInfo("1", "推箱子").getCurrent_box());
	}
}
