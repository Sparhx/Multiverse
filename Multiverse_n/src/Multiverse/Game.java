package Multiverse;

public class Game  {

	private final static int TIME = 1000000;
	private static int m_speed = 30;
 
	private static View m_view;
	private static Stage m_stage;
	private static StageTest m_stageTest = new StageTest();

	public Game(View view) {
		m_stage= m_stageTest;
		m_view = view;
		run();
	}

	public static void run() {

		long t0 = System.nanoTime();
		int frame = 0;

		while (frame < TIME) {
			while ((System.nanoTime() - t0) / 1000000 < m_speed);
			t0 = System.nanoTime();
			frame++;

			m_stage.action(frame);
			m_view.drawStage(m_stage);
		}
		System.exit(0);
	}

}
