package ogledni.zad2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class DrugiNoviFrame extends JFrame {
	public static void main(String[] args){
		SwingUtilities.invokeLater(()-> new DrugiNoviFrame());
	}
	public DrugiNoviFrame() {
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		initGUI();
		pack();
	}
	
	private void initGUI() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		JPanel north = new JPanel(new GridLayout(1,0));
		cp.add(north,BorderLayout.NORTH);
		
		JPanel south = new JPanel(new GridLayout(1,0));
		cp.add(south,BorderLayout.SOUTH);
		
		JPanel west = new JPanel(new GridLayout(0,1));
		cp.add(west,BorderLayout.WEST);
		
		JPanel east = new JPanel(new GridLayout(0,1));
		cp.add(east,BorderLayout.EAST);
		
		JLabel text = new JLabel("");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(text.getFont().deriveFont(64f));
		add(text,SwingConstants.CENTER);
		ButtonGroup upDown = new ButtonGroup();
		ButtonGroup sideGrp = new ButtonGroup();
		
		ActionListener  al = (e) -> {
			ButtonModel mod1 = upDown.getSelection();
			ButtonModel mod2 = sideGrp.getSelection();
			if (mod1 != null && mod2 != null) {
				int x = Integer.parseInt(mod1.getActionCommand()) * 
						Integer.parseInt(mod2.getActionCommand());
				String str = String.valueOf(x);
				text.setText(str);
			}
		};
		createButtons(upDown, north,south,al);
		createButtons(sideGrp, west,east,al);
	}
	
	
	
	private void createButtons(ButtonGroup bg, JPanel first, JPanel second,
			ActionListener al) {
		for (int i = 0; i < 10; i++) {
			String ime = String.valueOf(i);
			JToggleButton b1 = new JToggleButton(ime);
			b1.addActionListener(al);
			b1.setActionCommand(ime);
			bg.add(b1);
			JToggleButton b2 = new JToggleButton(ime);
			b2.setModel(b1.getModel());
			first.add(b1);
			second.add(b2);
			
			
		}
	}
}
