package tonyx.Tools.EDIHelp;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreePath;

import tonyx.Component.InnerFrame.InnerFrame;
import tonyx.Component.XmlTree.InputTreeNodeSelectionListener;
import tonyx.Component.XmlTree.MapTree;
import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Component.XmlTree.MapTreeRenderer;
import tonyx.Component.XmlTree.OutputTreeNodeSelectionListener;
import tonyx.EDI.Common.Mapper;
import tonyx.Tools.Utilities.Build;

public class EDIHelpToolInnerFrame extends InnerFrame {
	private static final long serialVersionUID = 1L;
	private String fileName ;
	private JScrollPane leftScrollPane, rightScrollPane;
	private MapTree inputtree, outputtree;
	private MapTreeNode inputroot, outputroot;
	private Mapper mapper;
	
	public EDIHelpToolInnerFrame(String title){
		super(title, true, true, true, true);
		this.setBounds(80, 50, 800, 500);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		
		inputtree = initTree("INPUT");
		outputtree = initTree("OUTPUT");
		
		leftScrollPane = new JScrollPane(inputtree);	
		rightScrollPane = new JScrollPane(outputtree);
		panel.add(leftScrollPane);
		panel.add(rightScrollPane);
		this.add(panel,BorderLayout.CENTER);
		
		mapper = new Mapper();
	}
	
	private MapTree initTree(String mode){
		MapTreeNode node = new MapTreeNode(mode, "HEADER");
		MapTree maptree = new MapTree(node);
		if("INPUT".equals(mode)){
			inputroot = node;
			maptree.addMouseListener(new InputTreeNodeSelectionListener());
		}else if("OUTPUT".equals(mode)){
			outputroot = node;
			maptree.addMouseListener(new OutputTreeNodeSelectionListener());
		}
		
		maptree.setCellRenderer(new MapTreeRenderer());
		maptree.setRootVisible(false);
		return maptree;
	}

	public Mapper getMapper() {
		return mapper;
	}
	
	public void showTree(){
		Build.buildTree(mapper,inputtree,outputtree);
		
		inputtree.setTreeType(mapper.getEdiINPUT().getActiveSgntax().getClass().getSimpleName());
		TreePath path = new TreePath(inputroot.getPath());
		inputtree.expandPath(path);
		

		outputtree.setTreeType(mapper.getEdiOUTPUT().getActiveSgntax().getClass().getSimpleName());
		path = new TreePath(outputroot.getPath());
		outputtree.expandPath(path);
	}
	
	public MapTree getInputtree() {
		return inputtree;
	}
	public MapTree getOutputtree() {
		return outputtree;
	}
	public MapTreeNode getInputroot() {
		return inputroot;
	}
	public MapTreeNode getOutputroot() {
		return outputroot;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}