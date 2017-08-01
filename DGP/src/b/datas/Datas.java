package b.datas;

public class Datas {
	public static int[][] pass1 = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,3,4,0,0,0,1,1,1,0,0,0,1},
			{1,0,2,0,3,4,0,0,0,1,0,0,0,0,0,1},
			{1,0,0,0,0,0,4,0,0,1,1,1,0,0,0,1},
			{1,0,1,0,0,3,0,0,0,0,0,1,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,1,1,1,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
	
	public static int[][] pass2 = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,3,4,0,1,0,1,1,1,0,0,0,1},
			{1,0,2,0,3,4,0,3,0,1,0,0,0,0,0,1},
			{1,0,0,0,0,0,4,0,4,1,1,1,0,0,0,1},
			{1,0,1,0,0,3,0,0,0,0,0,1,0,0,0,1},
			{1,0,0,0,0,0,0,1,0,1,1,1,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
	public static int[][] ergodic(int[][] pass) {
		int[][] datas=new int[12][16];
		for (int i = 0; i < pass.length; i++) {
			for (int j = 0; j < pass[i].length; j++) {
				datas[i][j]=pass[i][j];
			}
		}
		return datas;
	}
}
