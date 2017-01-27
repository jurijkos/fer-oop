package zi2016.treci;

import java.awt.FlowLayout;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MBZFrameTemplate extends JFrame {

    public MBZFrameTemplate() {
        FlowLayout lm = new FlowLayout();
        lm.setAlignment(FlowLayout.CENTER);
        super.setLayout(lm);

        JLabel nameLabel = new JLabel("Ime:");
        super.add(nameLabel);
        JTextField nameField = new JTextField(15);
        super.add(nameField);
        JLabel surnameLabel = new JLabel("Prezime:");
        super.add(surnameLabel);
        JTextField surnameField = new JTextField(15);
        super.add(surnameField);
        JLabel dateLabel = new JLabel("Datum rođenja:");
        super.add(dateLabel);

        //TODO 1. Dodati ComboBox-ove i popuniti ih vrijednostima 

        JButton button = new JButton("Dohvati");
        super.add(button);

        JLabel mbzLabel = new JLabel("Matični broj znanstvenika:");
        super.add(mbzLabel);
        JTextField mbzField = new JTextField(15);
        mbzField.setEditable(false);
        super.add(mbzField);

        //TODO 2. Dodati slušatelja na gumb
    }

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            JFrame frame = new MBZFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocation(200, 200);
            frame.setSize(200, 270);
            frame.setVisible(true);
        });            
    }
}