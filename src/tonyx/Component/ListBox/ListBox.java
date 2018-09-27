package tonyx.Component.ListBox;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListBox<E> extends JList implements ListSelectionListener {
	private DefaultListModel listModel;

//	 private ListModel<E> data;

	public ListBox() {
		listModel = new DefaultListModel();
		this.setModel(listModel);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addListSelectionListener(this);
	}

//	private ListBox(ListModel dataModelm) {
//		super(dataModelm);
//		// listModel = dlm;
//	}

	public ListBox(E[] values) {
//		this(new AbstractListModel<E>() {
//			public int getSize() {
//				return values.length;
//			}
//
//			public E getElementAt(int i) {
//				return values[i];
//			}
//		});
		// listModel = this.getModel()
		// listModel = new DefaultListModel();
		// super
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

		}
	}

	public int elementSize() {
		return listModel.size();
	}

	public void addElement(Object obj) {
		listModel.addElement(obj);
	}

	public void addElement(int index, Object element) {
		listModel.add(index, element);
	}

	public void removeAllElements() {
		listModel.removeAllElements();
	}

	public boolean removeElement(Object obj) {
		return listModel.removeElement(obj);
	}

	public void removeElementAt(int index) {
		listModel.removeElementAt(index);
	}
}
