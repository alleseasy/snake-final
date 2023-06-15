package hdm.lab.snake;

public class Collision {
	public static boolean collideSelf() {
		for (int i = 0; i < Snake.tails.size(); i++) {
			if (Snake.head.getX() == Snake.tails.get(i).getX()
					&& Snake.head.getY() == Snake.tails.get(i).getY()
					&& !Snake.tails.get(i).isWait()) {
				Snake.tails.clear();
				Snake.score = 0;
				System.exit(0);
			}
		}
		return false;
	}

	public static boolean collideWall() {
		if (Snake.head.getX() < 0
				|| Snake.head.getX() > 23
				|| Snake.head.getY() < 0
				|| Snake.head.getY() > 23) {

			Snake.tails.clear();
			Snake.score = 0;
			System.exit(0);

			return true;

		} else {
			return false;
		}
	}

	public static void collidePickUp() {
		if (Snake.head.getX() == Snake.pickup.getX()
				&& Snake.head.getY() == Snake.pickup.getY()) {

			Snake.pickup.reset();
			Snake.addTail();

			// score
			Snake.score += 1;
		}
	}

	public static void collideSnail() {
		for (Snail snail : Snake.snails) {
			if (isColliding(snail)) {
				snail.reset();
				Snake.addTail();
				Snake.score += 1;
			}
		}
	}

	private static boolean isColliding(Snail snail) {
		return (Snake.head.getX() == snail.getX()
				&& Snake.head.getY() == snail.getY());
	}

	// Check for wall collision
	public static void collideSnailWall() {
		for (Snail snail : Snake.snails) {
			if (isWallColliding(snail)) {
				snail.reset();
			}
		}
	}

	private static boolean isWallColliding(Snail snail) {
		return (snail.getX() < 0
				|| snail.getX() > 23
				|| snail.getY() < 0
				|| snail.getY() > 23);
	}
}
