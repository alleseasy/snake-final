package hdm.lab.snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Snake {

	public static int score = 0;

	public static boolean waitToMove = false;

	public static Head head = new Head(12, 12);

	public static ArrayList<Tail> tails = new ArrayList<>();

	public static PickUp pickup = new PickUp();

	public static Snail[] snails = new Snail[3];
	
	static long startTime = System.currentTimeMillis();
	static long elapsedTime;
	static long elapsedSeconds;
	static long secondsDisplay;
	static long elapsedMinutes;
	

	static {
		for (int i = 0; i < snails.length; i++) {
			snails[i] = new Snail();
		}
	}

	public static Random random = new Random();

	public static void addTail() {
		if (tails.size() < 1) {
			tails.add(new Tail(head.getX(), head.getY()));
		} else {
			tails.add(new Tail(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));
		}
	}

	public static void move() throws InterruptedException {
		// move tails
		if (tails.size() >= 2) {
			for (int i = tails.size() - 1; i >= 1; i--) {
				if (tails.get(i).isWait()) {
					tails.get(i).setWait(false);
				} else {
					tails.get(i).setX(tails.get(i - 1).getX());
					tails.get(i).setY(tails.get(i - 1).getY());
				}
			}
		}

		// move tail to head
		if (tails.size() >= 1) {
			if (tails.get(0).isWait()) {
				tails.get(0).setWait(false);
			} else {
				tails.get(0).setX(head.getX());
				tails.get(0).setY(head.getY());
			}
		}

		// move head
		switch (head.getDir()) {
			case RIGHT:
				head.setX(head.getX() + 1);
				break;
			case LEFT:
				head.setX(head.getX() - 1);
				break;
			case UP:
				head.setY(head.getY() - 1);
				break;
			case DOWN:
				head.setY(head.getY() + 1);
				break;
		}
	}

	// move snails
	public static void moveSnails() {
		for (Snail snail : snails) {
			moveSingleSnail(snail);
		}
	}

	// move single snail randomly
	private static void moveSingleSnail(Snail snail) {

		// decide on direction and increment
		int dir = random.nextInt(2);
		int increment = getIncrement(snail, dir);

		if (dir == 0) {
			snail.incrementX(increment);
		} else {
			snail.incrementY(increment);
		}
	}

	private static int getIncrement(Snail snail, int dir) {
		int increment = random.nextInt(3) - 1;
		if (isWallColliding(snail, increment, dir)) {
			increment = -1 * increment;
		}

		return increment;
	}

	private static boolean isWallColliding(Snail snail, int increment, int dir) {
		if (dir == 0) {
			return (snail.getX() + increment < 0
					|| snail.getX() + increment > 23);
		} else {
			return (snail.getY() + increment < 0
					|| snail.getY() + increment > 23);
		}
	}
	
	// timer
	public static void timer() {
		elapsedTime = System.currentTimeMillis() - startTime;
		elapsedSeconds = elapsedTime / 1000;
		secondsDisplay = elapsedSeconds % 60;
		elapsedMinutes = elapsedSeconds / 60;
	}


	// position to coordinates
	public static Point ptc(int x, int y) {
		Point p = new Point(0, 0);
		p.x = x * 30 + Gui.xoff;
		p.y = y * 30 + Gui.yoff;

		return p;
	}

}
