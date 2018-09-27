package tonyx.Tools.EDIHelp.Dialogs;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tonyx.Component.ListBox.ListBox;
import tonyx.Component.XmlTree.MapTree;
import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.Tools.EDIHelp.Config.ReadProperties;
import tonyx.Tools.EDIHelp.Utilities.SyntaxStruct;
import tonyx.Tools.EDIHelp.Utilities.SyntaxStructFactroy;
import tonyx.Tools.Utilities.CreateFile;

@SuppressWarnings("serial")
final public class ExportStructDialog extends JDialog implements ActionListener {
	ListBox<String> leftbox;
	ListBox<String> rightbox;
	JButton ltor;
	JButton rtol;
	JCheckBox activeOnly;
	JCheckBox splitToTwo;
	private MapTree inputtree, outputtree;

	public ExportStructDialog(MapTree inputtree,MapTree outputtree) {
		initDialog();
		this.inputtree = inputtree;
		this.outputtree = outputtree;
	}
	
	private void initDialog(){
		this.setTitle("Struct Field");
		this.setBounds(40, 40, 460, 600);
		this.setLayout(null);

		JPanel panel = new JPanel(null);
		panel.setBounds(0, 0, 460, 570);

		JLabel label = new JLabel("选择需要导出字段:");
		label.setBounds(20, 10, 200, 20);

		leftbox = new ListBox<String>();
		leftbox.setBorder(BorderFactory.createEtchedBorder(Color.white,
				Color.black));
		leftbox.setBounds(20, 40, 180, 225);
		leftbox.addElement("GroupName");
		leftbox.addElement("FieldName");
		leftbox.addElement("FieldName");

		ltor = new JButton(">>");
		ltor.addActionListener(this);
		ltor.setMargin(new Insets(0, 0, 0, 0));
		ltor.setBounds(205, 102, 25, 20);

		rtol = new JButton("<<");
		rtol.addActionListener(this);
		rtol.setMargin(new Insets(0, 0, 0, 0));
		rtol.setBounds(205, 152, 25, 20);

		rightbox = new ListBox<String>();
		rightbox.setBorder(BorderFactory.createEtchedBorder(Color.white,
				Color.black));
		rightbox.setBounds(236, 40, 180, 225);

		JLabel label2 = new JLabel("导出条件：");
		label2.setBounds(20, 275, 100, 20);

		activeOnly = new JCheckBox("只导出激活字段");
		activeOnly.setBounds(20, 295, 200, 20);
		activeOnly.setSelected(true);
		splitToTwo = new JCheckBox("输入输出分2个文件输出");
		splitToTwo.setBounds(20, 315, 200, 20);

		JButton ok_btn = new JButton("确定");
		ok_btn.setBounds(100, 500, 80, 20);
		ok_btn.addActionListener(this);
		JButton cancel_btn = new JButton("取消");
		cancel_btn.setBounds(220, 500, 80, 20);
		cancel_btn.addActionListener(this);

		panel.add(label);
		panel.add(ltor);
		panel.add(rtol);
		panel.add(leftbox);
		panel.add(rightbox);
		panel.add(label2);
		panel.add(activeOnly);
		panel.add(splitToTwo);

		panel.add(ok_btn);
		panel.add(cancel_btn);
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		int index;
		if (">>".equals(cmd)) {
			index = leftbox.getSelectedIndex();
			if (index != -1) {
				rightbox.addElement(leftbox.getSelectedValue());
				leftbox.removeElementAt(index);
				rtol.setEnabled(true);
			}
		} else if ("<<".equals(cmd)) {
			index = rightbox.getSelectedIndex();
			if (index != -1) {
				leftbox.addElement(rightbox.getSelectedValue());
				rightbox.removeElementAt(index);
				ltor.setEnabled(true);
			}
		} else if ("确定".equals(cmd)) {
			SyntaxStruct synStruct ;
			synStruct = SyntaxStructFactroy.createSyntaxStruct(inputtree.getTreeType());
			StringBuffer inputBuf = synStruct.exportSyntaxStruct((MapTreeNode)inputtree.getModel().getRoot());
			
			synStruct = SyntaxStructFactroy.createSyntaxStruct(outputtree.getTreeType());
			StringBuffer outputBuf = synStruct.exportSyntaxStruct((MapTreeNode)outputtree.getModel().getRoot());
			
			if(splitToTwo.isSelected()){
				CreateFile.createCSVFile(inputBuf,
						ReadProperties.getProperty("ExportFolderPath"), "InputSideStruct");
				CreateFile.createCSVFile(outputBuf,
						ReadProperties.getProperty("ExportFolderPath"), "OutputSideStruct");
			}else{
				inputBuf.append(outputBuf);
				CreateFile.createCSVFile(inputBuf,
						ReadProperties.getProperty("ExportFolderPath"), "MapStruct");
			}
			
			this.dispose();
		} else if ("取消".equals(cmd)) {
			this.dispose();
		}

		if (leftbox.elementSize() <= 0) {
			ltor.setEnabled(false);
		}
		if (rightbox.elementSize() <= 0) {
			rtol.setEnabled(false);
		}
	}

}
