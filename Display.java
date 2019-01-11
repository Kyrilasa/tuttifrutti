
 import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFrame frame; 
	private Canvas canvas;
	private String TITLE; //1.címe a keretnek
	private int WIDTH,HEIGHT;
	
	public Display(String TITLE,int WIDTH,int HEIGHT) {
		
		this.TITLE=TITLE;
		this.WIDTH=WIDTH;
		this.HEIGHT=HEIGHT;
		
		createDisplay();
	}
	
		private void createDisplay() {
			//2.létrehozom a Keretet amibe belefoglalom majd a canvast amire a grafikakat fogja kiiratni a render
			frame=new JFrame(TITLE);
			frame.setSize(WIDTH,HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			//3.létrehozom a canvas ojektumot
			canvas = new Canvas();
			canvas.setPreferredSize(new Dimension(WIDTH,HEIGHT));
			canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
			canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
			canvas.setFocusable(false);//ez kell ahoz hogy a keylistener mukodjon
			
			//4.belehelyezem a jframe-be a canvast
			frame.add(canvas);
			frame.pack();
			
			
		}

		public Canvas getCanvas() {
			return canvas;
		}

		public void setCanvas(Canvas canvas) {
			this.canvas = canvas;
		}
		public JFrame getFrame() {
			return frame;
		}

		public int getWIDTH() {
			return WIDTH;
		}

		public void setWIDTH(int wIDTH) {
			WIDTH = wIDTH;
		}

		public int getHEIGHT() {
			return HEIGHT;
		}

		public void setHEIGHT(int hEIGHT) {
			HEIGHT = hEIGHT;
		}

}
