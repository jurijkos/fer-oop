package thenewboston.gui2;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Second  extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel item1;
	public Second() {
		super("The title bar");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("This is a sentence");
		item1.setToolTipText("This is gona show up on hover.");
		this.add(item1);
	}
}
