package mojzavrsni.cetvrti;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Lotto extends JFrame {
	//private JPanel[] paneli;
	public Lotto() {
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initGUI();
		pack();
	}
	
	private void initGUI() {
		Container cp = getContentPane();
		JComboBox box = new JComboBox<>();
		for (int i = 1; i <= 10; i++) {
			box.addItem(i);
		}
		setLayout(new BorderLayout());
		JButton pokreni = new JButton("pokreni");
		JPanel northPanel = new JPanel(new FlowLayout());
		northPanel.add(box);
		northPanel.add(pokreni);
		add(northPanel, BorderLayout.NORTH);
		JPanel[] paneli = new JPanel[10];
		JPanel centerPanel = new JPanel(new GridLayout(1,10));
		int a = 0;
		for (JPanel pan : paneli) {
			a++;
			pan = new JPanel(new GridLayout(13,3));
			centerPanel.add(pan);
			JToggleButton[] buttoni = new JToggleButton[39];
			int i = 0;
			for (JToggleButton b : buttoni) {
				i++;
				b = new JToggleButton(String.valueOf(i));
				pan.add(b);

			}
		}
		add(centerPanel, BorderLayout.CENTER);
		
		pokreni.addActionListener(l->{
			int x =(Integer)box.getSelectedItem();
			System.out.println(x);
		});
		
	}
	
	
	public static void main(String[] args) {
		try{
			SwingUtilities.invokeLater(()-> new Lotto());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	
}
