package a.bean;

public class Games {
		public String game_introduction;
		public String game_name;
		public int game_id;
		public String getGame_introduction() {
			return game_introduction;
		}
		public void setGame_introduction(String game_introduction) {
			this.game_introduction = game_introduction;
		}
		public String getGame_name() {
			return game_name;
		}
		public void setGame_name(String game_name) {
			this.game_name = game_name;
		}
		public int getGame_id() {
			return game_id;
		}
		public void setGame_id(int game_id) {
			this.game_id = game_id;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + game_id;
			result = prime * result + ((game_introduction == null) ? 0 : game_introduction.hashCode());
			result = prime * result + ((game_name == null) ? 0 : game_name.hashCode());
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
			Games other = (Games) obj;
			if (game_id != other.game_id)
				return false;
			if (game_introduction == null) {
				if (other.game_introduction != null)
					return false;
			} else if (!game_introduction.equals(other.game_introduction))
				return false;
			if (game_name == null) {
				if (other.game_name != null)
					return false;
			} else if (!game_name.equals(other.game_name))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Games [game_introduction=" + game_introduction + ", game_name=" + game_name + ", game_id=" + game_id
					+ "]";
		}
		
}
