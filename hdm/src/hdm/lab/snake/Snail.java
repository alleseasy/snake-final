package hdm.lab.snake;

import java.util.concurrent.ThreadLocalRandom;

public class Snail {
	int x, y;

	public Snail() {
		this.x = ThreadLocalRandom.current().nextInt(0, 23);
		this.y = ThreadLocalRandom.current().nextInt(0, 23);
	}

	public void reset() {
		this.x = ThreadLocalRandom.current().nextInt(0, 23);
		this.y = ThreadLocalRandom.current().nextInt(0, 23);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void incrementX(int x) {
		this.x += x;
	}

	public void incrementY(int y) {
		this.y += y;
	}
}

