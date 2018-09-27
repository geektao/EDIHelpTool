package tonyx.Component.XmlTree;

import javax.swing.Icon;

import tonyx.Component.CheckBoxTree.CheckBoxTreeNode;

final public class MapTreeNode extends CheckBoxTreeNode {
	private String nodeType;
	private Icon icon;
	private boolean isActive;

	private Object dataObj;

	public MapTreeNode() {
		super();
	}

	public MapTreeNode(Object userObject) {
		super(userObject);
	}

	public MapTreeNode(Object userObject, String type) {
		super(userObject);

		this.nodeType = type;
	}

	public Object getDataObj() {
		return dataObj;
	}

	public <T> void setDataObj(T dataObj) {
		this.dataObj = dataObj;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
		System.out.println("setIcon " + icon);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}