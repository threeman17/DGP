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
	
	/**
	 * 载入某个玩家某个游戏的基本数据
	 * @return
	 */
	public GameInfo getCurrentGameInfo() {
		return new GameInfoDao().getCurrentGameInfo(UserInfoDao.getUser().getAccount(), game_name);
	}
	/**
	 * 修改皮肤
	 * @param account
	 * @param skin
	 */
	public void setSkin(String account ,int skin) {
		GameInfoDao gid=new GameInfoDao();
		gid.setSkin(account, skin,game_name);
	}
	/**
	 * 修改箱子
	 * @param account
	 * @param skin
	 */
	public void setBox(String account ,int box) {
		GameInfoDao gid=new GameInfoDao();
		gid.setBox(account, box,game_name);
	}
	
	
	@Test
	public void demo(){
//		System.out.println(new GameInfoService().getCurrentGameInfo("1", "推箱子").getCurrent_box());
		new GameInfoService("推箱子").setSkin("cewin",2);
	}
	public static void main(String[] args) {
		new GameInfoService("推箱子").setBox("cewin",2);
	}
}
