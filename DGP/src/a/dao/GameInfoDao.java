package a.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import a.bean.GameInfo;
import a.utils.DataSourceUtils;

public class GameInfoDao {
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
}
