package grafika.prog;
import java.lang.reflect.InvocationTargetException;
import java.text.AttributedCharacterIterator;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;



public class Main extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public Main() {
		init();
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				new Main();
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void init() {
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("JuCAD");
		Container cp = getContentPane();
		Canvas myCanvas = new Canvas();
		myCanvas.setBackground(Color.PINK);
		cp.add(myCanvas);
		
	}
	
}
