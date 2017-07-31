package a.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import a.bean.UserInfo;
import a.utils.DataSourceUtils;

public class UserInfoDao {
	
	static UserInfo user;
	//登陆
		public static UserInfo login(String account,String pass_word) throws SQLException{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from userinfo where account=?,pass_word=?";
			user=qr.query(sql, new BeanHandler<UserInfo>(UserInfo.class), account,pass_word);
			return user;
		}
		
	//注册
		public static void register(String account,String pass_word,String nick_name){
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="insert into userinfo set account=?,pass_word=?,nick_name=?";
			try {
				qr.update(sql,account,pass_word,nick_name);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//查询账号信息
		public static UserInfo seluser(String account) throws SQLException{
			UserInfo user=new UserInfo();
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from userinfo where account=?";
			user=qr.query(sql, new BeanHandler<UserInfo>(UserInfo.class),account);
			return user;
		}
		//更新用户积分,xp
		public static void updsuer(String account,int integral,double xp){
//			UserInfo user=new UserInfo();
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="update userinfo set integral=?,xp=? where account=?";
			try {
				qr.update(sql, integral,xp,account);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
