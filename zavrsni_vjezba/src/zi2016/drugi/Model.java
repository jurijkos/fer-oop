package zi2016.drugi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class Model implements ListModel<Integer> {
	
	private List<Integer> lista = new ArrayList<>();
	private List<ListDataListener> listeners = new ArrayList<>();
	
	@Override
	public Integer getElementAt(int index) {
		return lista.get(index);
	}
	
	@Override
	public int getSize() {
		return lista.size();
	}
	
	public void dodaj(int broj) {
		int n = lista.size();
		lista.add(broj);
		ListDataEvent e = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, n, n);
		for(ListDataListener l : listeners) {
			l.intervalAdded(e);
		}
	}
	
	// sortira od manjih prema vecim; priznajemo i kontra sort.
	public void sort() {
		Collections.sort(lista);
		ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, lista.size()-1);
		for(ListDataListener l : listeners) {
			l.contentsChanged(e);
		}
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		//listeners = new ArrayList<>(listeners);
		// Prihvacamo rjesenje i sa samo ovim drugim retkom...
		// Mislim da na predavanjima nismo pricali o cemu sve treba
		// paziti pri pisanju listenera i cemu onaj gore redak...
		listeners.add(l);
	}
	
	@Override
	public void removeListDataListener(ListDataListener l) {
		if(listeners.contains(l)) {
			listeners = new ArrayList<>(listeners);
			// Prihvacamo rjesenje i sa samo ovim drugim retkom...
			// Mislim da na predavanjima nismo pricali o cemu sve treba
			// paziti pri pisanju listenera i cemu onaj gore redak...
			listeners.remove(l);
		}
	}
}