package tonyx.Tools.EDIHelp.Dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tonyx.Tools.EDIHelp.Config.ReadProperties;

final public class TempOptionDialog extends JDialog implements ActionListener {
	// private TempOption option;
	private JTextField prefix;

	public TempOptionDialog() {
		this.setBounds(400, 300, 400, 300);
		this.setLayout(null);

		// this.option = option;

		JLabel label = new JLabel("前缀：");
		label.setBounds(10, 15, 40, 20);
		prefix = new JTextField();
		prefix.setBounds(55, 15, 100, 20);
		// prefix.setText(option.getPrefix());
		this.add(label);
		this.add(prefix);

		JButton btn_ok = new JButton("确定");
		btn_ok.addActionListener(this);
		btn_ok.setBounds(200, 40, 60, 20);
		JButton btn_cancel = new JButton("取消");
		btn_cancel.addActionListener(this);
		btn_cancel.setBounds(200, 80, 60, 20);
		this.add(btn_ok);
		this.add(btn_cancel);

		prefix.setText(ReadProperties.getProperty("Prefix"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if ("确定".equals(cmd)) {
			// option.setPrefix(prefix.getText());
			ReadProperties.setProperty("Prefix", prefix.getText());
			this.dispose();
		} else if ("取消".equals(cmd)) {
			this.dispose();
		}
	}
}
