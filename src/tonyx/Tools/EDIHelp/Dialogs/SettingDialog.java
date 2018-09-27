package tonyx.Tools.EDIHelp.Dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class SettingDialog extends JDialog implements ActionListener {
	JTextField textField;

	public SettingDialog() {
		this.setBounds(400, 300, 530, 200);
		this.setLayout(null);
		this.setTitle("����");

		JLabel label = new JLabel("ExportFolder:");
		label.setBounds(20, 20, 80, 20);
		this.add(label);
		textField = new JTextField();
		textField.setBounds(110, 20, 300, 20);
		this.add(textField);
		JButton btn_browsn = new JButton("���...");
		btn_browsn.setBounds(420, 20, 70, 20);
		btn_browsn.addActionListener(this);
		this.add(btn_browsn);

		JButton btn_ok = new JButton("ȡ��");
		btn_ok.setBounds(260, 100, 70, 20);
		btn_ok.addActionListener(this);
		this.add(btn_ok);
		JButton btn_cancel = new JButton("ȷ��");
		btn_cancel.setBounds(400, 100, 70, 20);
		btn_cancel.addActionListener(this);
		this.add(btn_cancel);

		// label = new JLabel("ExportFolder:");
		// label.setBounds(20, 20, 80, 20);
		// this.add(label);
		// textField = new JTextField();
		// textField.setBounds(110,20,300,20);
		// this.add(textField);
		// btn_browsn = new JButton("���...");
		// btn_browsn.setBounds(420,20,70,20);
		// btn_browsn.addActionListener(this);
		// this.add(btn_browsn);

		// ��ʼֵ
		textField.setText(ReadProperties.getProperty("ExportFolderPath"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("���...".equals(cmd)) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int retval = fileChooser.showOpenDialog(this);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				textField.setText(file.getPath());
			}
		} else if ("ȡ��".equals(cmd)) {
			this.dispose();
		} else if ("ȷ��".equals(cmd)) {
			ReadProperties.setProperty("ExportFolderPath", textField.getText());
			this.dispose();
		} else {

		}

	}
}
