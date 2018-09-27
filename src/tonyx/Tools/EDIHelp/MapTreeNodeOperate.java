package tonyx.Tools.EDIHelp;

import java.util.Vector;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;

public class MapTreeNodeOperate {

	public static void resetChildCount(MapTreeNode node) {
		Object dataObj = node.getDataObj();
		Reflect.invokeSetMethod(dataObj.getClass(), dataObj,
				PropertyName.getSetterName("ChildCount"),
				"" + node.getChildCount());
	}

	public static void resetChildCountRecursion(MapTreeNode node) {
		resetChildCount(node);

		int count = node.getChildCount();
		for (int i = 0; i < count; i++) {
			resetChildCountRecursion((MapTreeNode) node.getChildAt(i));
		}
	}

	public static boolean ifNodeCanInsert(MapTreeNode node,
			Vector<MapTreeNode> insertNodeList) {
		String dType = node.getNodeType();
		int dTypeNumber = NODETYPE.typeNumber(dType);

		// ÌØÊâÇé¿ö
		//group
		if (dTypeNumber >= 7) {
			return true;
		}

		int topTypeNum = theTopType(insertNodeList);
		if (dTypeNumber > topTypeNum) {
			return true;
		}

		return false;
	}

	public static int theTopType(Vector<MapTreeNode> insertNodeList) {
		String type = "";
		int topTypeNumber = NODETYPE.FIELD;
		int typeNumber;
		int size = insertNodeList.size();
		for (int i = 0; i < size; i++) {
			type = insertNodeList.elementAt(i).getNodeType();
			typeNumber = NODETYPE.typeNumber(type);

			if (typeNumber > topTypeNumber) {
				topTypeNumber = typeNumber;
				if (topTypeNumber == NODETYPE.GROUP) {
					break;
				}
			}
		}
		return topTypeNumber;
	}

	public static void setAllNodeChekcBoxVisible(MapTreeNode node) {
		// node.setCheckBoxVisible(true);
		int chlCount = node.getChildCount();
		MapTreeNode childnode = null;
		for (int i = 0; i < chlCount; i++) {
			childnode = (MapTreeNode) node.getChildAt(i);
			childnode.setCheckBoxVisible(true);
			setAllNodeChekcBoxVisible(childnode);
		}
	}
}