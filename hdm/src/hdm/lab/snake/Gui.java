package hdm.lab.snake;

import javax.swing.*;
public class Gui {
	
	JFrame jf;
	Draw d;
	public static int height=920, width=794;
	public static int xoff=30, yoff=120;
	
	public void create() {
		jf = new JFrame("Snake");
		jf.setSize(width, height);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.setResizable(false);
		jf.addKeyListener(new KeyHandler());
		
		d = new Draw();
		d.setBounds(0, 0, width, height);
		d.setVisible(true);
		jf.add(d);
		
		jf.requestFocus();
		jf.setVisible(true);
	}
}
