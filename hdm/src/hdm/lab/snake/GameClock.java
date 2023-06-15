package hdm.lab.snake;

public class GameClock extends Thread {
	public static boolean running = true;
	//timer
	static long startTime = System.currentTimeMillis();
	static long elapsedTime = System.currentTimeMillis() - startTime;
	static long elapsedSeconds = elapsedTime / 1000;
	static long secondsDisplay = elapsedSeconds % 60;
	static long elapsedMinutes = elapsedSeconds / 60;
	
	public void run() {
		for (int i = 0; i < 9; i++) {
			Snake.addTail();
		}

		while (running) {
			try {
				sleep(200);
				Snake.move();
				Snake.moveSnails();
				Snake.waitToMove = false;
				Collision.collideSnailWall();
				Collision.collidePickUp();
				Collision.collideSnail();
				Collision.collideSelf();
				Collision.collideWall();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}