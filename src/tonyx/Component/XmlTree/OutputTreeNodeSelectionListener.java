package tonyx.Component.XmlTree;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

final public class OutputTreeNodeSelectionListener extends MouseAdapter {
	private MapTree tree = null;
	private MapTreeNode node = null;

	@Override
	public void mouseClicked(MouseEvent event) {

		tree = (MapTree) event.getSource();
		int x = event.getX();
		int y = event.getY();
		int row = tree.getRowForLocation(x, y);

		int butNum = event.getButton();

		TreePath path = tree.getPathForRow(row);
		if (path != null) {
			node = (MapTreeNode) path.getLastPathComponent();
			if (butNum == MouseEvent.BUTTON1) {

				if (node != null) {
					Rectangle rt = tree.getPathBounds(path);
					if (x > rt.getX() && x <= rt.getX() + 21 && y > rt.getY()
							&& y <= rt.getY() + 21) {
						boolean isSelected = !node.isSelected();
						node.setSelected(isSelected);

						if (isSelected) {
							tree.addSelectedTreePath(path);
						} else {
							tree.removeSelectedTreePath(path);
						}

						((DefaultTreeModel) tree.getModel())
								.nodeStructureChanged(node);
					} else {
						System.out.println("选择个数："
								+ tree.getSelectedTreePathCount());
						Vector<TreePath> p = tree.getSelectedTreePath();
						for (TreePath tp :p) {
							System.out.println(tp);
						}
					}

				}

			} else if (butNum == MouseEvent.BUTTON2) {
				System.out.println("mid");
			} else if (butNum == MouseEvent.BUTTON3) {

				PopupMenu popupMenu1 = new PopupMenu();
				MenuItem menuItem1 = new MenuItem();
				MenuItem menuItem2 = new MenuItem();
				MenuItem menuItem3 = new MenuItem();

				menuItem1.setLabel("选择");
				menuItem1.addActionListener(new MouseActionListener());
				menuItem2.setLabel("添加节点");
				menuItem2.addActionListener(new MouseActionListener());
				menuItem3.setLabel("菜单3");
				popupMenu1.add(menuItem1);
				popupMenu1.add(menuItem2);
				popupMenu1.add(menuItem3);
				tree.add(popupMenu1);
				popupMenu1.show(tree, x, y);
			}
		}
	}

	class MouseActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand() + ":" + e.getModifiers()
					+ ":" + e.getClass() + ":" + e.getSource());
			// e.getSource();

			if (e.getActionCommand().equals("选择")) {
				// List oPath = EDIHelpToolFrame.getOutputSelectPath();
			} else if (e.getActionCommand().equals("添加节点")) {

				// tree.getRootPane();
				// System.out.println(tree.getRootPane().getParent());
				// MenuItem mi = (MenuItem) e.getSource();
				// PopupMenu pm = (PopupMenu) mi.getParent();

				// System.out.println(pm.getParent());

			}
		}

	}
}
