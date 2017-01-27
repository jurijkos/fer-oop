package zi2016.drugi;



import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class Suma extends JLabel {

	public Suma(ListModel<Integer> model) {
		model.addListDataListener(new ListDataListener() {
			@Override
			public void intervalRemoved(ListDataEvent e) {
				azuriraj((ListModel<Integer>)e.getSource());
			}
			@Override
			public void intervalAdded(ListDataEvent e) {
				azuriraj((ListModel<Integer>)e.getSource());
			}
			@Override
			public void contentsChanged(ListDataEvent e) {
				azuriraj((Model)e.getSource());
			}
		});
		azuriraj(model);
	}
	
	private void azuriraj(ListModel<Integer> source) {
		int suma = 0;
		for(int i = 0, n = source.getSize(); i < n; i++) {
			suma += source.getElementAt(i);
		}
		if(source.getSize()==0) {
			setText("N/A");
		} else {
			setText(Double.toString(suma/(double)source.getSize()));
		}
	}
}