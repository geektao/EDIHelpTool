package tonyx.Tools.EDIHelp.Utilities;

import tonyx.Component.XmlTree.MapTreeNode;

public abstract class SyntaxStruct {
	public StringBuffer sbuf = new StringBuffer();

	public abstract StringBuffer exportSyntaxStruct(MapTreeNode root);

	public void addStrToBuf(String str) {
		sbuf.append(str + "\n");
	}
}
