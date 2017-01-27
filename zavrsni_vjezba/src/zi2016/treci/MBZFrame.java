package zi2016.treci;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Optional;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class MBZFrame extends JFrame {

    public MBZFrame() {
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
        JPanel datePanel = new JPanel();
        add(datePanel);
        JComboBox<Integer> dayBox = new JComboBox<>();
        datePanel.add(dayBox);
        JComboBox<Integer> monthBox = new JComboBox<>();
        datePanel.add(monthBox);
        JComboBox<Integer> yearBox = new JComboBox<>();
        datePanel.add(yearBox);

        for (int i = 1; i <= 46; i++) {
            if (i <= 12) {
                monthBox.addItem(i);
            }
            if (i <= 31) {
                dayBox.addItem(i);
            }
            yearBox.addItem(1945 + i);
        }

        JButton button = new JButton("Dohvati");
        super.add(button);

        JLabel mbzLabel = new JLabel("Matični broj znanstvenika:");
        super.add(mbzLabel);
        JTextField mbzField = new JTextField(15);
        mbzField.setEditable(false);
        super.add(mbzField);

        //TODO 2. Dodati slušatelja na gumb
        button.addActionListener((ActionEvent e) -> {
            new Thread(() -> {                
                //get date of birth
                int year = (Integer) yearBox.getSelectedItem();
                int month = (Integer) monthBox.getSelectedItem();
                int day = (Integer) dayBox.getSelectedItem();
                LocalDate birth = LocalDate.of(year, month, day);
                
                Optional<Scientist> scientist = DBLoader.loadScientists().stream().
                        filter(s -> s.getName().equals(nameField.getText())).
                        filter(s -> s.getSurname().equals(surnameField.getText())).
                        filter(s -> s.getBirth().equals(birth)).findAny();                        

                String mbzText;
                if (scientist.isPresent()) {
                    mbzText = Long.toString(scientist.get().getMbz());
                } else {
                    mbzText = "N/A";
                }
                
                SwingUtilities.invokeLater(() -> {
                    mbzField.setText(mbzText);
                });
            }).start();
        });
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
