package a.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import a.bean.UserInfo;
import a.utils.DataSourceUtils;

public class UserInfoDao {
	
	//登陆，返回UserInfo（可为空）
	static private UserInfo user;

		public static UserInfo login(String account,String pass_word) throws SQLException{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from userinfo where account=? and pass_word=?";
			user=qr.query(sql, new BeanHandler<UserInfo>(UserInfo.class), account,pass_word);
			return user;
		}
		

		//注册

		public static void register(String account,String pass_word,String nick_name,String email,Date registration_date){
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="insert into userinfo(account,pass_word,nick_name,email,registration_date) values(?,?,?,?,?)";
			try {
				qr.update(sql,account,pass_word,nick_name,email,registration_date);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			readGameInfo(account);
		}
		
		public static void readGameInfo(String account) {
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="insert into gameinfo(account,game_name) values(?,?)";
			try {
				qr.update(sql,account,"推箱子");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//查询一条账号的信息

		public static UserInfo seluser(String account) throws SQLException{
			UserInfo user=new UserInfo();
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from userinfo where account=?";
			user=qr.query(sql, new BeanHandler<UserInfo>(UserInfo.class),account);
			return user;
		}

		//更新积分，xp
		public static void upduser(String account,int integral,double xp){
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="update userinfo set integral=integral+?,xp=xp+? where account=?";
			try {
				qr.update(sql, integral,xp,account);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 游戏巅峰榜
		 * @return List<UserInfo>
		 * @throws SQLException
		 */
		public static List<UserInfo> selrank() throws SQLException
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from userinfo order by xp desc limit 100";
			List<UserInfo> ls=null;
			ls=qr.query(sql,new BeanListHandler<UserInfo>(UserInfo.class));
			return ls;
		}
		
		public  static  UserInfo getUser() {
			return user;
		}
		public  static  void setUser(UserInfo user) {
			UserInfoDao.user=user;
		}
}
