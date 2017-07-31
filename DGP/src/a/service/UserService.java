package a.service;

import java.sql.SQLException;

import a.dao.UserInfoDao;

public class UserService {

	public boolean login(String username,String password) {
		// TODO Auto-generated method stub
		try {
			
			if(UserInfoDao.login(username, password)!=null) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getUserNickName() {
		return UserInfoDao.getUser().getNick_name();
	}
	
	public int getUserLevel() {
		double xp=UserInfoDao.getUser().getXp();
		
		int level=(int)xp/1000;
		return level;
	}
	
	public int Userintegral() {
		return UserInfoDao.getUser().getIntegral();
	}
	
}
