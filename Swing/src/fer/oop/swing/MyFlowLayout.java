package fer.oop.swing;


import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;



public class MyFlowLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	public MyFlowLayout() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("title");
		setLayout(new java.awt.FlowLayout());
		setVisible(true);
		setSize(200, 120);
		add(new JButton("Gumb 1"));
		add(new JButton("2"));
		add(new JButton("Gumb 3"));
		add(new JButton("Dugački naziv gumba 4"));
		add(new JButton("Gumb 5"));
	}
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() -> {
				new MyFlowLayout();
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}