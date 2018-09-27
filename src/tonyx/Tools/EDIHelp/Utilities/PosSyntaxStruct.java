package tonyx.Tools.EDIHelp.Utilities;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;

public class PosSyntaxStruct extends SyntaxStruct {

	@Override
	public StringBuffer exportSyntaxStruct(MapTreeNode root) {
		processPosSyntax((MapTreeNode) root.getChildAt(0));
		return sbuf;
	}

	private void processPosSyntax(MapTreeNode node) {
		String temp = "";
		int childnum = node.getChildCount();
		for (int i = 0; i < childnum; i++) {
			MapTreeNode subnode = (MapTreeNode) node.getChildAt(i);
			if (subnode.isActive()) {
				String type = subnode.getNodeType();
				Object obj = subnode.getDataObj();
				String name = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Name"));

				String desc = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Description"));
				temp += name + "," + "0" + "," + name + "," + name + "," + desc;
				this.addStrToBuf(temp);
				temp = "";
				if (type.equals("PosRecord")) {
					processPosRecord("0", name, subnode);
				} else if (type.equals("Group")) {
					processGroup(name, subnode);
				}
			}
		}
	}

	private void processGroup(String name, MapTreeNode subnode) {	
	}

	private void processPosRecord(String string, String name,
			MapTreeNode subnode) {
	}

}
