package tonyx.Component.XmlTree;

import java.util.Vector;

import javax.swing.JTree;
import javax.swing.tree.TreePath;

final public class MapTree extends JTree {
	private String treeType;
	private Vector<TreePath> treepath = new Vector<TreePath>();

	public MapTree(MapTreeNode node) {
		super(node);
	}

	public void addSelectedTreePath(TreePath path) {
		treepath.add(path);
	}

	public Vector<TreePath> getSelectedTreePath() {
		return this.treepath;
	}

	public void clearSelectedTreePath() {
		this.treepath.removeAllElements();
	}

	public int getSelectedTreePathCount() {
		return this.treepath.size();
	}

	public void removeSelectedTreePath(TreePath path) {
		this.treepath.removeElement(path);
	}

	public String getTreeType() {
		return treeType;
	}

	public void setTreeType(String treeType) {
		this.treeType = treeType;
	}
}
