package a.service;

import java.sql.SQLException;

import a.bean.UserInfo;
import a.dao.UserInfoDao;

public class UserInfoService {
	/**
	 * 提供用户登陆注册的方法
	 * @param username
	 * @param password
	 * @return
	 */
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
	/**
	 * 根据账号判断注册用户是否存在
	 * @param account
	 * @return
	 */
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
	/**
	 * 提供注册方法
	 * @param account
	 * @param nickname
	 * @param password
	 */
	public void register(String account,String nickname,String password) {
		UserInfoDao userinfodao=new  UserInfoDao();
		userinfodao.register(account, password, nickname);
	}
	/**
	 * 获得当前玩家的昵称
	 * @return
	 */
	public String getUserNickName() {
		return UserInfoDao.getUser().getNick_name();
	}
	/**
	 * 获得当前玩家的等级
	 * @return
	 */
	public int getUserLevel() {
		double xp=UserInfoDao.getUser().getXp();
		
		int level=(int)xp/1000;
		return level;
	}
	/**
	 * 获得当前玩家的积分
	 * @return
	 */
	public int Userintegral() {
		return UserInfoDao.getUser().getIntegral();
	}
	
}
