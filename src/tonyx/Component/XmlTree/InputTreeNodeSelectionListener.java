package tonyx.Component.XmlTree;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import tonyx.Tools.Converter.CoverterFactroy;
import tonyx.Tools.Converter.CreateTemp;
import tonyx.Tools.Converter.SyntaxConverter;
import tonyx.Tools.EDIHelp.EDIHelpToolInnerFrame;
import tonyx.Tools.EDIHelp.MapTreeNodeOperate;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;

final public class InputTreeNodeSelectionListener extends MouseAdapter {
	private MapTree tree = null;
	private MapTreeNode node = null;

	@Override
	public void mouseClicked(MouseEvent event) {

		tree = (MapTree) event.getSource();
		int x = event.getX();
		int y = event.getY();
		int row = tree.getRowForLocation(x, y);

		int butNum = event.getButton();
		// int count = event.getClickCount();

		TreePath path = tree.getPathForRow(row);
		if (path != null) {
			node = (MapTreeNode) path.getLastPathComponent();
			if (butNum == MouseEvent.BUTTON1) {
				//
				// if (node != null) {
				// Rectangle rt = tree.getPathBounds(path);
				// if (x > rt.getX() && x <= rt.getX() + 21 && y > rt.getY()
				// && y <= rt.getY() + 21) {
				// boolean isSelected = !node.isSelected();
				// node.setSelected(isSelected);
				//
				// if(isSelected){
				// tree.addSelectedTreePath(path);
				// }else{
				// tree.removeSelectedTreePath(path);
				// }
				//
				// ((DefaultTreeModel) tree.getModel())
				// .nodeStructureChanged(node);
				// } else {
				//
				// System.out.println("选择个数："+tree.getSelectedTreePathCount());
				// Vector<TreePath> p = tree.getSelectedTreePath();
				// for(Iterator<TreePath> it = p.iterator();it.hasNext();){
				// System.out.println(it.next());
				// }
				// }
				//
				// }

			} else if (butNum == MouseEvent.BUTTON2) {
				System.out.println("mid");
			} else if (butNum == MouseEvent.BUTTON3) {

				PopupMenu popupMenu1 = new PopupMenu();
				MenuItem menuItem1 = new MenuItem();
				MenuItem menuItem2 = new MenuItem();
				MenuItem menuItem3 = new MenuItem();

				menuItem1.setLabel("选择");
				menuItem1.addActionListener(new MouseActionListener());
				menuItem2.setLabel("建立Temp");
				menuItem2.addActionListener(new MouseActionListener());
				menuItem3.setLabel("菜单3");
				popupMenu1.add(menuItem1);
				popupMenu1.add(menuItem2);
				popupMenu1.add(menuItem3);

				menuItem1 = new MenuItem();
				menuItem1.setLabel("移动");
				menuItem1.addActionListener(new MouseActionListener());
				popupMenu1.add(menuItem1);

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
			String cmd = e.getActionCommand();
			if (cmd.equals("选择")) {
				// List oPath = EDIHelpToolFrame.getOutputSelectPath();
			} else if (cmd.equals("建立Temp")) {

				EDIHelpToolInnerFrame currentFrame = (EDIHelpToolInnerFrame) tree
						.getRootPane().getParent();
				MapTree outtree = currentFrame.getOutputtree();
				Vector<TreePath> selectedPaths = outtree.getSelectedTreePath();

				// SyntaxConverter SynCov = (SyntaxConverter)
				// Reflect.getObjectByName(
				// + "To" + , "tonyx.Tools.Converter.");
				SyntaxConverter SynCov = CoverterFactroy.createCoverter(
						outtree.getTreeType(), tree.getTreeType());
				// System.out.println(obj.getClass().getSimpleName());

				CreateTemp ct = new CreateTemp(selectedPaths, SynCov);
				Vector<MapTreeNode> nodelist = ct.create();
				int size = nodelist.size();
				System.out.println("size:" + size);
				Object dataObj = node.getDataObj();
				if (MapTreeNodeOperate.ifNodeCanInsert(node, nodelist)) {
					for (int i = 0; i < size; i++) {
						MapTreeNode sNode = nodelist.get(i);
						// Object subDataObj = sNode.getDataObj();
						// String type = subDataObj.getClass().getSimpleName();
						// Reflect.invokeSetMethod(dataObj.getClass(), dataObj,
						// PropertyName.getSetterName(type), subDataObj);

						addChild(dataObj, sNode.getDataObj(),
								tree.getTreeType());
						node.add(sNode);
					}
					MapTreeNodeOperate.resetChildCountRecursion(node);
				} else {
					System.out.println("类型错误！");
				}

				// 取消选中
				for (TreePath tpath : selectedPaths) {
					MapTreeNode tnode = (MapTreeNode) tpath
							.getLastPathComponent();
					tnode.setSelected(false);
					((DefaultTreeModel) outtree.getModel())
							.nodeStructureChanged(tnode);
				}
				selectedPaths.removeAllElements();

				((DefaultTreeModel) tree.getModel()).nodeStructureChanged(node);
			} else if (cmd.equals("移动")) {
				// tree.getRootPane();
				// System.out.println(tree.getRootPane().getParent());
				// MenuItem mi = (MenuItem) e.getSource();
				// PopupMenu pm = (PopupMenu) mi.getParent();

				// System.out.println(pm.getParent());
				EDIHelpToolInnerFrame frame = (EDIHelpToolInnerFrame) tree
						.getRootPane().getParent();

				MapTreeNodeOperate
						.setAllNodeChekcBoxVisible((MapTreeNode) frame
								.getInputroot().getChildAt(0));
				((DefaultTreeModel) tree.getModel())
						.nodeStructureChanged((MapTreeNode) frame
								.getInputroot().getChildAt(0));
			}
		}

		private void addChild(Object dest, Object src, String treeType) {
			String type = src.getClass().getSimpleName();
			if ("XMLSyntax".equals(treeType) && "Field".equals(type)) {

			} else {
				Reflect.invokeSetMethod(dest.getClass(), dest,
						PropertyName.getSetterName(type), src);
			}
		}
		//
		// public void newXMLRecord(tonyx.EDI.Common.XMLSyntax.Field field){
		// XMLRecord xr = new XMLRecord();
		// xr.setEdiID("1");
		// xr.setEdiName("_pcd_"+field.getEdiName());
		//
		// }
	}
}
