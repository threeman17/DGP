package a.service;

import java.sql.SQLException;

import a.bean.UserInfo;
import a.dao.UserInfoDao;

public class UserInfoService {

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
	
	public boolean isUserExist(String account) {
		UserInfoDao userinfodao=new  UserInfoDao();
		UserInfo userinfo=new UserInfo();
		try {
			userinfo=userinfodao.seluser(account);
			if(userinfo!=null) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public void register(String account,String nickname,String password) {
		UserInfoDao userinfodao=new  UserInfoDao();
		userinfodao.register(account, password, nickname);
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
