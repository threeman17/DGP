package b.view;

import b.keyListener.TimerDate;

public class StartAPP {
	public static MainUI main;
	public static void start() {
		if(main!=null) {
			TimerDate.getTimer().cancel();
		}
		main=new MainUI();
		main.timerInit();
	}
	public static void close() {
		main.dispose();
	}
}
