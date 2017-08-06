package a.dao;



import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import a.bean.GamePlayHistory;
import a.utils.DataSourceUtils;

public class GamePlayHistoryDao {
	/**
	 * 查询一个账号的所有游戏记录
	 * @return List<GamePlayHistory>
	 * @throws SQLException 
	 */
		public static  List<GamePlayHistory> selgameplayhistory(String account) throws SQLException
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from gameplayhistory where account=? order by start_time desc";
			List<GamePlayHistory> list=null;
			list=qr.query(sql,new BeanListHandler<GamePlayHistory>(GamePlayHistory.class),account);
			return list;
		}
		/**
		 * 获得用户一个游戏的最高得分纪录
		 * @param account
		 * @param gameplay_id
		 * @return
		 */
		public static Object selrecord(String account,String game_name)
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select record from gameplayhistory where account=? and game_name=? order by record desc";
			Object number=null;
			try {
		         number = qr.query(sql, new ScalarHandler("record"),account,game_name);  
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return number;
		}
		
		/**
		 * 查询一个账号的总游戏时长
		 * @param account
		 * @return
		 * @throws SQLException
		 */
		public static int seltotalplaytime(String account) throws SQLException
		{	
			int st=0;
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select sum(t.play_min) as play_min from (select * from gameplayhistory where account=?) t";
			st=qr.query(sql,new BeanHandler<GamePlayHistory>(GamePlayHistory.class),account).play_min;
			return st;
		}
		/**
		 * 插入游戏记录
		 * @param g
		 */
		public static void insGamePlayHistory(GamePlayHistory g)
		{	
			
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="insert into gameplayhistory set "
					+ "account=?,game_name=?,gameplay_id=?,"
					+ "integral_get=?,play_min=?,record=?,"
					+ "xp_gain_factor=?,integral_gain_factor=?,start_time=?,xp_get=?,result=?";
			try {
				qr.update(sql, g.getAccount(),g.getGame_name(),g.getGamePlay_id(),
							g.getIntegral_get(),g.getPlay_min(),g.getRecord(),
							g.getXp_gain_factor(),g.getIntegral_gain_factor(),
							g.getStart_time(),g.getXp_get(),g.getResult());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
}
