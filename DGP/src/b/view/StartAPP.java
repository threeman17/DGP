package b.view;

public class StartAPP {
	public static MainUI main;
	public static void start() {
		main=new MainUI();
	}
	public static void ag() {
		main.dispose();
		main=new MainUI();
	}
}
