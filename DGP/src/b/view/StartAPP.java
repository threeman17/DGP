package b.view;

public class StartAPP {
	public static MainUI main;
	public static void start() {
		if(main!=null) {
			main.dispose();
		}
		main=new MainUI();
		main.timerInit();
	}
	public static void close() {
		main.dispose();
	}
}
