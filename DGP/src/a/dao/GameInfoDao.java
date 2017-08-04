package a.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import a.bean.GameInfo;
import a.utils.DataSourceUtils;

public class GameInfoDao {
	/**
	 * 载入改玩家的基本数据
	 * @param account
	 * @param game_name
	 * @return
	 */
	public GameInfo getCurrentGameInfo(String account,String game_name) {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from gameinfo where account=? and game_name=?";
		GameInfo gi = null;
		try {
			gi=qr.query(sql, new BeanHandler<GameInfo>(GameInfo.class),account,game_name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gi;
	}
	/**
	 * 修改皮肤
	 * @param account
	 * @param skin
	 */
	
	public void setSkin(String account,int skin,String game_name) {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update gameinfo set current_skin=? where account=? and game_name=?";
		try {
			qr.update(sql, skin,account,game_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改箱子
	 * @param account
	 * @param skin
	 */
	
	public void setBox(String account,int box,String game_name) {
		QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update gameinfo set current_box=? where account=? and game_name=?";
		try {
			qr.update(sql, box,account,game_name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
