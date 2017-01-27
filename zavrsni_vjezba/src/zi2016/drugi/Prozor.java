package zi2016.drugi;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Prozor extends JFrame {
	private static final long serialVersionUID = 1L;
	private Random rand = new Random();
	
	public Prozor() {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		initGUI();
		setSize(300, 200);
	}
	
	private void initGUI() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new GridLayout(1,0));
		JPanel bottom = new JPanel(new GridLayout(1,0));
		cp.add(top, BorderLayout.PAGE_START);
		cp.add(bottom, BorderLayout.PAGE_END);
		
		Model model = new Model();
		
		JList<Integer> lista = new JList<>(model);
		cp.add(lista, BorderLayout.CENTER);
		
		top.add(new Suma(model));
		top.add(new NajveciUPrvaTri(model));
		
		JButton novi = new JButton("Dodaj novi");
		JButton sort = new JButton("Sortiraj");
		
		bottom.add(novi);
		bottom.add(sort);
		
		novi.addActionListener(e->{model.dodaj(rand.nextInt(100));});
		sort.addActionListener(e->{model.sort();});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			new Prozor().setVisible(true);
		});
	}
}