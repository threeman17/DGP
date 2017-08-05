package b.model;

import javax.swing.ImageIcon;


public class Hero extends Sprite {

	public Hero(int x, int y, String url) {
		super(x, y, url);
		// TODO Auto-generated constructor stub
	}
	public void setHeroPic(String url) {
		ImageIcon icon=new ImageIcon(url);
		super.getJLabel().setIcon(icon);
	}

}
