package b.model;

public class Box extends Sprite {
	private boolean flag=false;
	public Box(int x, int y, String url) {
		super(x, y, url);
		// TODO Auto-generated constructor stub
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
