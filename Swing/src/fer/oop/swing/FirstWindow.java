package fer.oop.swing;

import javax.swing.JFrame;

public class FirstWindow extends JFrame {
	final static long serialVersionUID=1L;
	public static void main(String[] args) {
		FirstWindow window = new FirstWindow();
		window.setVisible(true);
		window.setSize(500,200);
		window.setLocation(100, 100);
		
		
	}
}
