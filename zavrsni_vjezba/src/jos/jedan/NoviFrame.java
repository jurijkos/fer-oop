package jos.jedan;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
public class NoviFrame extends JFrame{
	public NoviFrame() {
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800,600);
		setLayout(new BorderLayout());
		JButton ok = new JButton("OK");
		JLabel tekst = new JLabel();
		ok.addActionListener((e)->{
			tekst.setText("stisnuo si ok");
		});
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(ok);
		panel.add(tekst);
		add(panel,BorderLayout.CENTER);
		JPanel panel2 = new JPanel();
		JComboBox<String> broj = new JComboBox<>();
		broj.addItem("Jurij");
		broj.addItem("Marija");
		panel2.add(broj);
		add(panel2, BorderLayout.NORTH);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new NoviFrame();
		});
	}

}
