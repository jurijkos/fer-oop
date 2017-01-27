package fer.oop.swing;


import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ClosableWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	 public ClosableWindow() {
			setLocation(100, 300);
			setSize(400, 200);
			setVisible(true);
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setTitle("Moj prozor");
	 }
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() ->{
				//CloseableWindow window = 
				new ClosableWindow();
				/*window.setLocation(100, 300);
				window.setSize(400, 200);
				window.setVisible(true);
				window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				window.setTitle("Moj prozor");
				*/
			});
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
