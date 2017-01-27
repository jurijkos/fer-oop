package fer.oop.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class EnterNameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public EnterNameFrame() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("naslov");
		setVisible(true);
		//setSize(300, 200);
		setBounds(10,10,500,200);
		JPanel panel = (JPanel) getContentPane();
		//panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setBorder(BorderFactory.createLineBorder(new Color(500), 5));
		JLabel lblTitle = new JLabel("Naslov");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitle, BorderLayout.NORTH);
		JLabel lblName = new JLabel("Unesite ime i prezime:");
		panel.add(lblName, BorderLayout.WEST);
		JTextField tfInput = new JTextField();
		panel.add(tfInput, BorderLayout.CENTER);
		tfInput.setColumns(10);
		JPanel southPanel = new JPanel();
		panel.add(southPanel, BorderLayout.SOUTH);
		JButton btnOK = new JButton("OK");
		southPanel.add(btnOK);
	}
	
	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(() ->{
				new EnterNameFrame().pack();;
			});
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}