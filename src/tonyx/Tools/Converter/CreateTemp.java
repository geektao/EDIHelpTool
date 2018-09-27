package tonyx.Tools.Converter;

import java.util.Vector;

import javax.swing.tree.TreePath;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;

public class CreateTemp {
	private Vector<TreePath> selectedPaths;
	private Vector<TreePath> newSelectedPaths;
	private SyntaxConverter synCovert;

	public CreateTemp(Vector<TreePath> selectedPath, SyntaxConverter synCovert) {
		this.selectedPaths = selectedPath;
		this.synCovert = synCovert;
//
//		System.out.println("old");
//		for (TreePath otp : selectedPaths) {
//			System.out.println(otp);
//		}

		newSelectedPaths = sortSelectPaths();

//		System.out.println("new");
//		for (TreePath ntp : newSelectedPaths) {
//			System.out.println(ntp);
//		}
	}

	public Vector<MapTreeNode> create() {
		Vector<MapTreeNode> nodeList = new Vector<MapTreeNode>();
		for (TreePath path : newSelectedPaths) {
			MapTreeNode node = (MapTreeNode) path.getLastPathComponent();
			Vector<MapTreeNode> newnode = createNode(node);
			if (newnode != null) {
				for (MapTreeNode subnode : newnode) {
					nodeList.add(subnode);
				}
			}
		}
		return nodeList;
	}

	public Vector<MapTreeNode> createNode(MapTreeNode node) {
		Vector<MapTreeNode> temp = new Vector<MapTreeNode>();			
		MapTreeNode dnode = synCovert.Coverter(node);

		if (dnode != null) {			
			if (node.isLeaf()) {
//				System.out.println(node.getDataObj().getClass().getCanonicalName());
//				Object dataObj = node.getDataObj();
//				if(dataObj.getClass().getCanonicalName().equals("tonyx.EDI.Common.XMLSyntax.Field")){
//					tonyx.EDI.Common.XMLSyntax.Field xmlfield = (tonyx.EDI.Common.XMLSyntax.Field)dataObj;
//					if("PCDATA".equals(xmlfield.getEdiFieldType())){
////						MapTreeNode pnode = (MapTreeNode) node.getParent();
//						MapTreeNode prValue =synCovert.Coverter((MapTreeNode)node.getParent());
//					}
//					System.out.println("field");
//				}
				temp.add(dnode);
				return temp;
			}
			Object dataObj = dnode.getDataObj();
			
			int count = node.getChildCount();
			for (int i = 0; i < count; i++) {
				MapTreeNode subnode = (MapTreeNode) node.getChildAt(i);
				
				if (subnode.isSelected()) {
					Vector<MapTreeNode> newsubnode = createNode(subnode);
					if (newsubnode != null) {
						for (MapTreeNode ssubnode : newsubnode) {
							Object subDataObj = ssubnode.getDataObj();
							String type = subDataObj.getClass().getSimpleName();
							Reflect.invokeSetMethod(dataObj.getClass(), dataObj, PropertyName.getSetterName(type), subDataObj);
							
							dnode.add(ssubnode);
						}
					}
				}
			}
			temp.add(dnode);
			return temp;
		} else {
			int count = node.getChildCount();
			for (int i = 0; i < count; i++) {
				MapTreeNode subnode = (MapTreeNode) node.getChildAt(i);
				if (subnode.isSelected()) {
					Vector<MapTreeNode> newsubnode = createNode(subnode);
					if (newsubnode != null) {
						for (MapTreeNode ssubnode : newsubnode) {
							temp.add(ssubnode);
						}
					}
				}
			}
			return temp;
		}
	}

	public Vector<TreePath> sortSelectPaths() {
		Vector<TreePath> newSelectedPaths = new Vector<TreePath>();

		for (TreePath path : selectedPaths) {
			TreePath newPath = isParentInVector(path);
			if (!newSelectedPaths.contains(newPath)) {
				newSelectedPaths.add(newPath);
			}
		}
		return newSelectedPaths;
	}

	public TreePath isParentInVector(TreePath path) {
		TreePath parentPath = path.getParentPath();
		if (this.selectedPaths.contains(parentPath)) {
			return isParentInVector(parentPath);
		}
		return path;
	}
}
