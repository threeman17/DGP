package b.model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Sprite {
	private int x;
	private int y;
	private ImageIcon icon;
	private JLabel jl;
	public Sprite(int x, int y,String url) {
		this.x = x;
		this.y = y;
		icon = new ImageIcon(url);  
		jl=new JLabel(icon);
		jl.setSize(50,50);
		jl.setLocation(x*50,y*50);
	}
	public JLabel getJLabel() {
		return jl;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public JLabel getJl() {
		return jl;
	}
	public void setJl(JLabel jl) {
		this.jl = jl;
	}
	
}
