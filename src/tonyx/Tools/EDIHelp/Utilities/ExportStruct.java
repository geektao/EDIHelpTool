package tonyx.Tools.EDIHelp.Utilities;

import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Tools.EDIHelp.Config.ReadProperties;
import tonyx.Tools.Utilities.CreateFile;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;
import tonyx.Tools.Utilities.TreeOperate;

public class ExportStruct {
	private StringBuffer sbuf = new StringBuffer();

	public ExportStruct(String treeType, MapTreeNode root) {
		if ("EDISyntax".equals(treeType)) {
			processEDISyntax((MapTreeNode) root.getChildAt(0));
		}

		CreateFile.createCSVFile(sbuf,
				ReadProperties.getProperty("ExportFolderPath"), "mapStruct");
	}

	private void processEDISyntax(MapTreeNode node) {
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
				if (type.equals("Segment")) {
					processSegment("0", name, subnode);
				} else if (type.equals("Group")) {
					processGroup(name, subnode);
				}
			}
		}
	}

	public void processGroup(String groupName, MapTreeNode node) {
		String temp = "";
		int childnum = node.getChildCount();
		for (int i = 0; i < childnum; i++) {
			MapTreeNode subnode = (MapTreeNode) node.getChildAt(i);
			if (subnode.isActive()) {
				Object obj = subnode.getDataObj();
				String name = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Name"));

				// String [] pName = name.split(":");
				// name = pName[0];

				String desc = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Description"));
				temp += name + "," + groupName + "," + name + "," + name + ","
						+ desc;
				this.addStrToBuf(temp);
				temp = "";
				if (subnode.getNodeType().equals("Group")) {
					processGroup(name, subnode);
				} else {
					processSegment(groupName, name, subnode);
				}
			}
		}
	}

	private void processSegment(String groupName, String segName,
			MapTreeNode node) {
		String temp = "";
		int childnum = node.getChildCount();
		for (int i = 0; i < childnum; i++) {
			MapTreeNode subnode = (MapTreeNode) node.getChildAt(i);
			if (subnode.isActive()) {
				Object obj = subnode.getDataObj();
				String name = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Name"));

				// String [] pName = name.split(":");
				// name = pName[0];

				String desc = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Description"));

				temp += segName +"-"+ TreeOperate.formatNumber(i + 1) + ","
						+ groupName + "," + segName + "," + "#"+ name + "," + desc;
				this.addStrToBuf(temp);
				temp = "";

				if (subnode.getNodeType().equals("Composite")) {
					processComposite(groupName, segName, name, subnode, i);
				}
			}
		}
	}

	private void processComposite(String groupName, String segName,
			String compName, MapTreeNode compNode, int compNum) {
		int childnum = compNode.getChildCount();
		String temp = "";
		for (int i = 0; i < childnum; i++) {
			MapTreeNode subnode = (MapTreeNode) compNode.getChildAt(i);
			if (subnode.isActive()) {
				Object obj = subnode.getDataObj();
				String filedname = (String) Reflect
						.invokeGetMethod(obj.getClass(), obj,
								PropertyName.getGetterName("Name"));

				// String [] pName = filedname.split(":");
				// filedname = pName[0];

				String desc = (String) Reflect.invokeGetMethod(obj.getClass(),
						obj, PropertyName.getGetterName("Description"));
				temp += segName +"-"+ TreeOperate.formatNumber(compNum + 1)
						+ TreeOperate.formatNumber(i + 1) + "," + groupName
						+ "," + segName + "," + "#"+compName + "." + filedname
						+ "," + desc;
				this.addStrToBuf(temp);
				temp = "";

			}
		}
	}

	public void addStrToBuf(String str) {
		sbuf.append(str + "\n");
	}
}
