package Multiverse;


public class StartMultiverse {
	
	private final static int TIME = 10;
	private final static int speed = 30;
	private static Windows wind = new Windows();
	private static Board board;
	
	public static void main(String[] args) {
		
		board = new Board(wind);
		wind.add(board);
		trame();
	}
	
	public static void menu() {
		
	}
	
	public static void trame() {
		long t0 = System.nanoTime();

		while (board.getTime() < TIME) {
			while ((System.nanoTime() - t0)/1000000 < speed);
			t0 = System.nanoTime();
			
			board.action();
			board.repaint();
		}
		System.exit(0);
	}
}
