package tonyx.Component.XmlTree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.TreeCellRenderer;

import tonyx.Component.CheckBoxTree.CheckBoxTreeLabel;
import tonyx.EDI.Common.ExplicitRule;
import tonyx.Tools.Utilities.PropertyName;
import tonyx.Tools.Utilities.Reflect;

final public class MapTreeRenderer extends JPanel implements TreeCellRenderer {
	protected JCheckBox check;
	protected CheckBoxTreeLabel label;
	String path;

	public MapTreeRenderer() {
		setLayout(null);
		add(check = new JCheckBox());
		add(label = new CheckBoxTreeLabel());
		check.setBackground(UIManager.getColor("Tree.textBackground"));
		check.setVisible(false);
		label.setForeground(UIManager.getColor("Tree.textForeground"));

		// get the application path
		File file = new File("");
		path = file.getAbsolutePath();
		path.replace("\\", "/");
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean selected, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		MapTreeNode node = (MapTreeNode) value;
		// String nodeType = node.getNodeType();

		String stringValue = tree.convertValueToText(value, selected, expanded,
				leaf, row, hasFocus);
		setEnabled(tree.isEnabled());

		check.setSelected(node.isSelected());

		label.setFont(tree.getFont());
		label.setText(stringValue);
		label.setSelected(selected);
		label.setFocus(hasFocus);

		if (!node.isActive()) {
			label.setForeground(Color.gray);
		} else {
			label.setForeground(Color.black);
		}

		label.setIcon(getIcon((MapTree) tree, node));

		check.setVisible(node.isCheckBoxVisible());

		return this;
	}

	@Override
	public Dimension getPreferredSize() {
		if (check.isVisible()) {
			Dimension dCheck = check.getPreferredSize();
			Dimension dLabel = label.getPreferredSize();
			return new Dimension(dCheck.width + dLabel.width,
					dCheck.height < dLabel.height ? dLabel.height
							: dCheck.height);
		}

		return label.getPreferredSize();
	}

	@Override
	public void doLayout() {
		if (check.isVisible()) {
			Dimension dCheck = check.getPreferredSize();
			Dimension dLabel = label.getPreferredSize();
			int yCheck = 0;
			int yLabel = 0;
			if (dCheck.height < dLabel.height)
				yCheck = (dLabel.height - dCheck.height) / 2;
			else
				yLabel = (dCheck.height - dLabel.height) / 2;
			check.setLocation(0, yCheck);
			check.setBounds(0, yCheck, dCheck.width, dCheck.height);
			label.setLocation(dCheck.width, yLabel);
			label.setBounds(dCheck.width, yLabel, dLabel.width, dLabel.height);
		} else {
			Dimension dLabel = label.getPreferredSize();
			// label.setLocation(0, dLabel.w);
			label.setBounds(0, 0, dLabel.width, dLabel.height);
		}
	}

	@Override
	public void setBackground(Color color) {
		if (color instanceof ColorUIResource)
			color = null;
		super.setBackground(color);
	}

	private Icon getIcon(MapTree mapTree, MapTreeNode node) {
		Icon icon = null;
		String treeType = mapTree.getTreeType();
		String nodeType = node.getNodeType();

		MapTreeNode rootNode = (MapTreeNode) mapTree.getModel().getRoot();
		MapTreeNode synRootNode = null;
		if (rootNode.getChildCount() > 0) {
			synRootNode = (MapTreeNode) rootNode.getChildAt(0);
		}

		if ("EDISyntax".equals(treeType) || "CHIPSSyntax".equals(treeType)
				|| "FEDWIRESyntax".equals(treeType)) {
			if (nodeType.equals("Group")) {
				if (synRootNode == node) {
					icon = new ImageIcon(path + "\\res\\bmp186.jpg");
				} else {
					if (isExplicitRuleEmpty(node)) {
						icon = new ImageIcon(path + "\\res\\bmp331.jpg");
					} else
						icon = new ImageIcon(path + "\\res\\bmp177.jpg");
				}
			} else if (nodeType.equals("Segment")) {
				if (isExplicitRuleEmpty(node)) {
					icon = new ImageIcon(path + "\\res\\bmp325.jpg");
				} else {
					icon = new ImageIcon(path + "\\res\\bmp185.jpg");
				}
			} else if (nodeType.equals("Composite")) {
				icon = new ImageIcon(path + "\\res\\bmp181.jpg");
			} else if (nodeType.equals("Field")) {
				if (isExplicitRuleEmpty(node)) {
					icon = new ImageIcon(path + "\\res\\bmp305.jpg");
				} else
					icon = new ImageIcon(path + "\\res\\bmp183.jpg");
			}
		} else if ("XMLSyntax".equals(treeType)) {
			if (nodeType.equals("XMLParticleGroup")) {
				if (isExplicitRuleEmpty(node)) {
					icon = new ImageIcon(path + "\\res\\bmp332.jpg");
				} else
					icon = new ImageIcon(path + "\\res\\bmp267.jpg");
			} else if (nodeType.equals("XMLElementGroup")) {
				if (synRootNode == node) {
					icon = new ImageIcon(path + "\\res\\bmp240.jpg");
				} else {
					if (isExplicitRuleEmpty(node)) {
						icon = new ImageIcon(path + "\\res\\bmp333.jpg");
					} else
						icon = new ImageIcon(path + "\\res\\bmp268.jpg");
				}
			} else if (nodeType.equals("XMLRecord")) {
				icon = new ImageIcon(path + "\\res\\bmp246.jpg");
			} else if (nodeType.equals("Field")) {
				if (XMLFiledType(node).equals("ATTRIBUTE")) {
					if (isExplicitRuleEmpty(node)) {
						icon = new ImageIcon(path + "\\res\\bmp307.jpg");
					} else
						icon = new ImageIcon(path + "\\res\\bmp247.jpg");
				} else {
					if (isExplicitRuleEmpty(node)) {
						icon = new ImageIcon(path + "\\res\\bmp312.jpg");
					} else
						icon = new ImageIcon(path + "\\res\\bmp242.jpg");
				}
			}
		} else if ("PosSyntax".equals(treeType)) {
			if (nodeType.equals("Group")) {
				if (synRootNode == node) {
					icon = new ImageIcon(path + "\\res\\bmp187.jpg");
				} else {
					if (isExplicitRuleEmpty(node)) {
						icon = new ImageIcon(path + "\\res\\bmp331.jpg");
					} else
						icon = new ImageIcon(path + "\\res\\bmp177.jpg");
				}
			} else if (nodeType.equals("PosRecord")) {
				if (isExplicitRuleEmpty(node)) {
					icon = new ImageIcon(path + "\\res\\bmp330.jpg");
				} else
					icon = new ImageIcon(path + "\\res\\bmp179.jpg");
			} else if (nodeType.equals("Field")) {
				if (isExplicitRuleEmpty(node)) {
					icon = new ImageIcon(path + "\\res\\bmp305.jpg");
				} else
					icon = new ImageIcon(path + "\\res\\bmp183.jpg");
			}
		}
		return icon;
	}

	private boolean isExplicitRuleEmpty(MapTreeNode node) {
		Object data = node.getDataObj();
		Object obj = Reflect.invokeGetMethod(data.getClass(), data,
				PropertyName.getGetterName("ExplicitRule"));
		if (obj != null) {
			if (obj.getClass().getSimpleName().equals("String")) {
				if (!"".equals(obj.toString().trim())) {
					return true;
				}
			} else {
				ExplicitRule er = (ExplicitRule) obj;
				if (!er.getEdiOnBegin().equals("")
						|| !er.getEdiOnEnd().equals("")) {
					return true;
				}
			}
		}

		return false;
	}

	private String XMLFiledType(MapTreeNode node) {
		Object data = node.getDataObj();
		return (String) Reflect.invokeGetMethod(data.getClass(), data,
				PropertyName.getGetterName("FieldType"));
	}
}
