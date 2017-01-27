package primjeri.zadaci;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Primjer1 extends JFrame{

	public Primjer1() {
		setSize(400,200);
		JLabel lab = new JLabel("jurij");
		
		add(lab);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		lab.setHorizontalAlignment(SwingConstants.CENTER);
		
		//lab.setText("kos");
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new Primjer1());
		
	}
}
