package fer.oop.swing;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MyBorderLayout extends JFrame {
	private static final long serialVersionUID = 1L;
	public MyBorderLayout() {
		setTitle("naslov");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(300, 200);
		add(new JButton("Sjever"), BorderLayout.NORTH);
		add(new JButton("Zapad"), BorderLayout.WEST);
		add(new JButton("Centar"), BorderLayout.CENTER);
		add(new JButton("Istok"), BorderLayout.EAST);
		add(new JButton("Jug"), BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() ->{
				new MyBorderLayout();
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}