package hdm.lab.snake;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Draw extends JLabel {

	Point p;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

		// Draw BAckground
		g.setColor(new Color(190, 191, 174));
		g.fillRect(0, 0, Gui.width, Gui.height);
		
		// draw border
		g.setColor(new Color(25, 133, 45));
		g.fillRect(0, 90, 780, 780);
		
		// Draw BAckground Field
		g.setColor(new Color(243, 250, 110));
		g.fillRect(30, 120, 720, 720);

		// Draw snake tails
		g.setColor(new Color(227, 107, 217));
		for (int i = 0; i < Snake.tails.size(); i++) {
			p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
			g.fillRect(p.x, p.y, 30, 30);
		}

		// draw snake head
		g.setColor(new Color(145, 26, 135));
		p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
		g.fillRect(p.x, p.y, 30, 30);

		// draw pickup
		g.setColor(Color.red);
		p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
		g.fillRect(p.x, p.y, 30, 30);

		// draw snails
		g.setColor(Color.orange);
		for (Snail snail : Snake.snails) {
			p = Snake.ptc(snail.getX(), snail.getY());
			g.fillRect(p.x, p.y, 30, 30);
		}

		// Draw grid
		g.setColor(Color.black);
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 24; j++) {
				g.drawRect(i * 30 + Gui.xoff, j * 30 + Gui.yoff, 30, 30);
			}
		}

		// Draw Border
		g.setColor(Color.black);
		g.drawRect(Gui.xoff, Gui.yoff, 720, 720);

		// draw score
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString("Punkte: " + Snake.score, 5, 25);
		g.drawString("Spielzeit: " + Snake.elapsedMinutes + ":" + Snake.secondsDisplay, 645, 25);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("SNAKE", 300, 50);

		repaint();

	}

}
