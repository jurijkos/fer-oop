package fer.oop.swing;
import java.lang.Exception;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JButton;

import java.awt.Dimension;
public class FirstComponentWindow extends JFrame {
	public static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					FirstComponentWindow window = new FirstComponentWindow();
					window.setVisible(true);
					window.setSize(400, 200);
					window.setLocation(100, 100);
					window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					JButton button = new JButton("gumb");
					//nis ne znaic ak nemam neki svoj layyout
					button.setPreferredSize(new Dimension(20,10));
					button.setMaximumSize(new Dimension(40,20));
					window.add(button);
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
