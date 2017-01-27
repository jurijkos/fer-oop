package thenewboston.gui3;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Apple {
	public static void main(String[] args) {
		Tuna tuna = new Tuna();
		tuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		tuna.setSize(800, 400);
		tuna.setVisible(true);
	}
}
