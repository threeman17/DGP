package a.bean;

import java.util.Date;

public class UserInfo {
		public String account;
		public String pass_word;
		public String nick_name;
		public int integral;
		public double xp;
		public Date registration_date;
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getPass_word() {
			return pass_word;
		}
		public void setPass_word(String pass_word) {
			this.pass_word = pass_word;
		}
		public String getNick_name() {
			return nick_name;
		}
		public void setNick_name(String nick_name) {
			this.nick_name = nick_name;
		}
		public int getIntegral() {
			return integral;
		}
		public void setIntegral(int integral) {
			this.integral = integral;
		}
		public double getXp() {
			return xp;
		}
		public void setXp(double xp) {
			this.xp = xp;
		}
		public Date getRegistration_date() {
			return registration_date;
		}
		public void setRegistration_date(Date registration_date) {
			this.registration_date = registration_date;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((account == null) ? 0 : account.hashCode());
			result = prime * result + integral;
			result = prime * result + ((nick_name == null) ? 0 : nick_name.hashCode());
			result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
			result = prime * result + ((registration_date == null) ? 0 : registration_date.hashCode());
			long temp;
			temp = Double.doubleToLongBits(xp);
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
			UserInfo other = (UserInfo) obj;
			if (account == null) {
				if (other.account != null)
					return false;
			} else if (!account.equals(other.account))
				return false;
			if (integral != other.integral)
				return false;
			if (nick_name == null) {
				if (other.nick_name != null)
					return false;
			} else if (!nick_name.equals(other.nick_name))
				return false;
			if (pass_word == null) {
				if (other.pass_word != null)
					return false;
			} else if (!pass_word.equals(other.pass_word))
				return false;
			if (registration_date == null) {
				if (other.registration_date != null)
					return false;
			} else if (!registration_date.equals(other.registration_date))
				return false;
			if (Double.doubleToLongBits(xp) != Double.doubleToLongBits(other.xp))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "UserInfo [account=" + account + ", pass_word=" + pass_word + ", nick_name=" + nick_name
					+ ", integral=" + integral + ", xp=" + xp + ", registration_date=" + registration_date + "]";
		}
		
}
