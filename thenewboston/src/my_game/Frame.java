package my_game;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;

import javax.swing.JFrame;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		DisplayMode dMode = new DisplayMode(800, 600, 16, 50);
		Frame frame = new Frame();
		frame.run(dMode);
	}
	public void run(DisplayMode dMode){
		setBackground(Color.PINK);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN,24)); 
		Window window = new Window();
		try {
			window.setFullScreen(dMode, this);
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}finally {
			window.restoreWindow();
		}
	}
}
