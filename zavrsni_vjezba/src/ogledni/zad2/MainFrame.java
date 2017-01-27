package ogledni.zad2;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Container;
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private ButtonGroup sideBtnGroup;
	private ButtonGroup upDownBtnGroup;
	private JLabel text;
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new MainFrame();
		});
	}
	
	
	
	public MainFrame() {
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		text = new JLabel("");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setFont(text.getFont().deriveFont(64f));
		
		add(text, BorderLayout.CENTER);
		JPanel north = new JPanel();
		north.setLayout(new GridLayout(1,0));
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(1,0));
		JPanel east = new JPanel();
		east.setLayout(new GridLayout(0,1));
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(0,1));
		
		
		cp.add(north, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);
		cp.add(west, BorderLayout.WEST);
		cp.add(east, BorderLayout.EAST);
		
		
		upDownBtnGroup = new ButtonGroup();
		sideBtnGroup = new ButtonGroup();
		ActionListener al = a -> {
			ButtonModel m1 = upDownBtnGroup.getSelection();
			ButtonModel m2 = sideBtnGroup.getSelection();
			if(m1!=null && m2!=null) {
				int rez = Integer.parseInt(m1.getActionCommand())*Integer.parseInt(m2.getActionCommand());
				text.setText(String.valueOf(rez));
			}
		};
		
		createButtons(upDownBtnGroup,north,south,al);
		createButtons(sideBtnGroup,west,east,al);
		
		pack();
	}
	private void createButtons(ButtonGroup bg, JPanel one,JPanel two, ActionListener al){
		for (int i = 0; i < 10; i++){
			String text = String.valueOf(i);
			JToggleButton b1 = new JToggleButton(text);
			b1.getModel().setActionCommand(text);
			b1.getModel().addActionListener(al);
			
			
			JToggleButton b2 = new JToggleButton(text);
			b2.setModel(b1.getModel());
			bg.add(b1);
			
			one.add(b1);
			two.add(b2);
			
		}
	}
}
