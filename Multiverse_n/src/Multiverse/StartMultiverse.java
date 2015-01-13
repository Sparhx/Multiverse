package Multiverse;


public class StartMultiverse {
	
	private static View view;	
	private static Game game;
	
	public static void main(String[] args) {
		
		view = new View();
		game = new Game(view);
		

	}
	
}
