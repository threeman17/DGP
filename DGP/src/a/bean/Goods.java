






package a.bean;

public class Goods {
		public String goods_name;
		public String goods_introduction;
		public String game_id;
		public int goods_id;
		public int goods_price;
		public double xp_gain_factory;
		public double integral_gain_factor;
		public String getGoods_name() {
			return goods_name;
		}
		public void setGoods_name(String goods_name) {
			this.goods_name = goods_name;
		}
		public String getGoods_introduction() {
			return goods_introduction;
		}
		public void setGoods_introduction(String goods_introduction) {
			this.goods_introduction = goods_introduction;
		}
		public String getGame_id() {
			return game_id;
		}
		public void setGame_id(String game_id) {
			this.game_id = game_id;
		}
		public int getGoods_id() {
			return goods_id;
		}
		public void setGoods_id(int goods_id) {
			this.goods_id = goods_id;
		}
		public int getGoods_price() {
			return goods_price;
		}
		public void setGoods_price(int goods_price) {
			this.goods_price = goods_price;
		}
		public double getXp_gain_factory() {
			return xp_gain_factory;
		}
		public void setXp_gain_factory(double xp_gain_factory) {
			this.xp_gain_factory = xp_gain_factory;
		}
		public double getIntegral_gain_factor() {
			return integral_gain_factor;
		}
		public void setIntegral_gain_factor(double integral_gain_factor) {
			this.integral_gain_factor = integral_gain_factor;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((game_id == null) ? 0 : game_id.hashCode());
			result = prime * result + goods_id;
			result = prime * result + ((goods_introduction == null) ? 0 : goods_introduction.hashCode());
			result = prime * result + ((goods_name == null) ? 0 : goods_name.hashCode());
			result = prime * result + goods_price;
			long temp;
			temp = Double.doubleToLongBits(integral_gain_factor);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(xp_gain_factory);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Goods other = (Goods) obj;
			if (game_id == null) {
				if (other.game_id != null)
					return false;
			} else if (!game_id.equals(other.game_id))
				return false;
			if (goods_id != other.goods_id)
				return false;
			if (goods_introduction == null) {
				if (other.goods_introduction != null)
					return false;
			} else if (!goods_introduction.equals(other.goods_introduction))
				return false;
			if (goods_name == null) {
				if (other.goods_name != null)
					return false;
			} else if (!goods_name.equals(other.goods_name))
				return false;
			if (goods_price != other.goods_price)
				return false;
			if (Double.doubleToLongBits(integral_gain_factor) != Double.doubleToLongBits(other.integral_gain_factor))
				return false;
			if (Double.doubleToLongBits(xp_gain_factory) != Double.doubleToLongBits(other.xp_gain_factory))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Goods [goods_name=" + goods_name + ", goods_introduction=" + goods_introduction + ", game_id="
					+ game_id + ", goods_id=" + goods_id + ", goods_price=" + goods_price + ", xp_gain_factory="
					+ xp_gain_factory + ", integral_gain_factor=" + integral_gain_factor + "]";
		}
		
}
