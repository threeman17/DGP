package a.dao;



import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import a.bean.GamePlayHistory;
import a.utils.DataSourceUtils;

public class GamePlayHistoryDAO {
	/**
	 * 查询一个账号的所有游戏记录
	 * @return List<GamePlayHistory>
	 * @throws SQLException 
	 */
		public static List<GamePlayHistory> selgameplayhistory(String account) throws SQLException
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from gameplayhistory where account=?";
			List<GamePlayHistory> list;
			list=qr.query(sql,new BeanListHandler<GamePlayHistory>(GamePlayHistory.class),account);
			return list;
		}
		/**
		 * 获得用户一个游戏的最高得分纪录
		 * @param account
		 * @param gameplay_id
		 * @return
		 */
		public static int selrecord(String account,int gameplay_id)
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from gameplayhistory where account=?,gameplay_id=?";
			int re = 0;
			try {
				re =qr.query(sql,new BeanHandler<GamePlayHistory>(GamePlayHistory.class),account,gameplay_id).record;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return re;
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
		public static void insgameplayhistory(GamePlayHistory g)
		{	GamePlayHistory gp=new GamePlayHistory();
			gp=g;
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="insert into gameplayhistory set "
					+ "account=?,game_name=?,gameplay_id=?,"
					+ "integral_get=?,play_min=?,record=?,"
					+ "xp_gain_factor=?,integral_gain_factor=?,start_time=?";
			try {
				qr.update(sql, gp.getAccount(),gp.getGame_name(),gp.getGamePlay_id(),
							gp.getIntegral_get(),gp.getPlay_min(),gp.getRecord(),
							gp.getXp_gain_factor(),gp.getIntegral_gain_factor(),
							gp.getStart_time());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	@Test
	public void demo(){
		try {
			System.out.println(seltotalplaytime("lxy"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
