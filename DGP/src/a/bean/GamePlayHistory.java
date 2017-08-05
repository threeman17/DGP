package a.bean;

import java.util.Date;

public class GamePlayHistory {
		public String account;
		public String game_name;
		public int gameplay_id;
		public int integral_get;
		public double intergral_get_factor;
		public int play_min;
		public int record;
		public double xp_gain_factor;
		public int xp_get;
		public int result;
		public int getResult() {
			return result;
		}
		public void setResult(int result) {
			this.result = result;
		}
		public int getGameplay_id() {
			return gameplay_id;
		}
		public void setGameplay_id(int gameplay_id) {
			this.gameplay_id = gameplay_id;
		}
		public int getXp_get() {
			return xp_get;
		}
		public void setXp_get(int xp_get) {
			this.xp_get = xp_get;
		}
		public double integral_gain_factor;
		public Date start_time;
		
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getGame_name() {
			return game_name;
		}
		public void setGame_name(String game_name) {
			this.game_name = game_name;
		}
		public int getGamePlay_id() {
			return gameplay_id;
		}
		public void setGamePlay_id(int game_id) {
			this.gameplay_id = game_id;
		}
		public int getIntegral_get() {
			return integral_get;
		}
		public void setIntegral_get(int integral_get) {
			this.integral_get = integral_get;
		}
		public int getPlay_min() {
			return play_min;
		}
		public void setPlay_min(int play_min) {
			this.play_min = play_min;
		}
		public int getRecord() {
			return record;
		}
		public void setRecord(int record) {
			this.record = record;
		}
		public double getXp_gain_factor() {
			return xp_gain_factor;
		}
		public double getIntergral_get_factor() {
			return intergral_get_factor;
		}
		public void setIntergral_get_factor(double intergral_get_factor) {
			this.intergral_get_factor = intergral_get_factor;
		}
		public void setXp_gain_factor(double xp_gain_factor) {
			this.xp_gain_factor = xp_gain_factor;
		}
		public double getIntegral_gain_factor() {
			return integral_gain_factor;
		}
		public void setIntegral_gain_factor(double integral_gain_factor) {
			this.integral_gain_factor = integral_gain_factor;
		}
		public Date getStart_time() {
			return start_time;
		}
		public void setStart_time(Date start_time) {
			this.start_time = start_time;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((account == null) ? 0 : account.hashCode());
			result = prime * result + gameplay_id;
			result = prime * result + ((game_name == null) ? 0 : game_name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(integral_gain_factor);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + integral_get;
			result = prime * result + play_min;
			result = prime * result + record;
			result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
			temp = Double.doubleToLongBits(xp_gain_factor);
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
			GamePlayHistory other = (GamePlayHistory) obj;
			if (account == null) {
				if (other.account != null)
					return false;
			} else if (!account.equals(other.account))
				return false;
			if (gameplay_id != other.gameplay_id)
				return false;
			if (game_name == null) {
				if (other.game_name != null)
					return false;
			} else if (!game_name.equals(other.game_name))
				return false;
			if (Double.doubleToLongBits(integral_gain_factor) != Double.doubleToLongBits(other.integral_gain_factor))
				return false;
			if (integral_get != other.integral_get)
				return false;
			if (play_min != other.play_min)
				return false;
			if (record != other.record)
				return false;
			if (start_time == null) {
				if (other.start_time != null)
					return false;
			} else if (!start_time.equals(other.start_time))
				return false;
			if (Double.doubleToLongBits(xp_gain_factor) != Double.doubleToLongBits(other.xp_gain_factor))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "GamePlayHistory [account=" + account + ", game_name=" + game_name + ", game_id=" + gameplay_id
					+ ", integral_get=" + integral_get + ", play_min=" + play_min + ", record=" + record
					+ ", xp_gain_factor=" + xp_gain_factor + ", integral_gain_factor=" + integral_gain_factor
					+ ", start_time=" + start_time + "]";
		}
		
}
