package zi2016.drugi;



import javax.swing.JLabel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class NajveciUPrvaTri extends JLabel {

	public NajveciUPrvaTri(ListModel<Integer> model) {
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
				azuriraj((ListModel<Integer>)e.getSource());
			}
		});
		azuriraj(model);
	}
	
	private void azuriraj(ListModel<Integer> source) {
		int n = source.getSize();
		if(n==0) {
			setText("N/A");
			return;
		}
		int max = source.getElementAt(0);
		for(int i = 1; i < n && i < 3; i++) {
			max = Math.max(max, source.getElementAt(i));
		}
		setText(Integer.toString(max));
	}
}