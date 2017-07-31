package a.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import a.bean.Goods;
import a.utils.DataSourceUtils;

public class GoodsDao {
	
		static Goods goods;
		//查询一条goods表的信息返回Goods类
		public static Goods selgoods(int goods_id) throws SQLException{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="select * from goods where goods_id=?";
			goods=qr.query(sql,new BeanHandler<Goods>(Goods.class));
			return goods;
		}
		
		//添加商品
		public static void insgoods(int goods_price,String goods_name,String goods_introduction,String game_id,double xp_gain_factory,double integral_gain_factor)
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="insert into goods set goods_id=null,goods_price=?,goods_name=?,goods_introduction=?,game_id=?,xp_gain_factory=?,integral_gain_factor=?";
			try {
				qr.update(sql,goods_price,goods_name,goods_introduction,game_id,xp_gain_factory,integral_gain_factor);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		//更新商品信息
		public static void updgoods(int goods_id,int goods_price,String goods_name,String goods_introduction,String game_id,double xp_gain_factory,double integral_gain_factor)
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="update goods set goods_price=?,goods_name=?,goods_introduction=?,game_id=?,xp_gain_factory=?,integral_gain_factor=? where goods_id=?";
			try {
				qr.update(sql,goods_price,goods_name,goods_introduction,game_id,xp_gain_factory,integral_gain_factor,goods_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//移除商品
		public static void delgoods(int goods_id)
		{
			QueryRunner qr=new QueryRunner(DataSourceUtils.getDataSource());
			String sql="delete from goods where goods_id=?";
			try {
				qr.update(sql,goods_id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
}
