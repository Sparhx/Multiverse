package Multiverse;


public class StartMultiverse {
	
	private static View view;	
	@SuppressWarnings("unused")
	private static Game game;
	
	public static void main(String[] args) {
		
		view = new View();
		game = new Game(view);

	}
	
}
