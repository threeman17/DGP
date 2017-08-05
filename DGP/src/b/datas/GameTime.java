package b.datas;

import a.dao.UserInfoDao;
import a.service.GamePlayHistoryService;

public class GameTime {
	
	
	
	public static int getGameTime() {
		GamePlayHistoryService gphs=new GamePlayHistoryService();
		int level=gphs.selrecord(UserInfoDao.getUser().getAccount(), "推箱子");
		
		switch(level) {
		case 1:
			return 30;
		case 2:
			return 45;
		case 3:
			return 600;
		case 4:
			return 1200;
		case 5:
			return 3000;
		}
		return 30;
	}
}
