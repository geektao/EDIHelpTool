package tonyx.Component.InnerFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JPanel;

final public class InnerFrameOperatorPane extends JPanel {
	private JButton restore;
	private JButton close;
	private InnerFrame currentFrame;

	public InnerFrameOperatorPane() {
		this.setLayout(new FlowLayout(FlowLayout.TRAILING));
		restore = new JButton("#");
		restore.setMargin(new Insets(0, 0, 0, 0));
		restore.setPreferredSize(new Dimension(15, 15));
		restore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					currentFrame.setMaximum(false);
				} catch (PropertyVetoException ex) {
					ex.printStackTrace();
				}
				currentFrame.showNorthPanel();
				currentFrame = null;
				setVisible(false);
				restore.setEnabled(false);
				close.setEnabled(false);
			}
		});
		this.add(restore);

		close = new JButton("X");
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setPreferredSize(new Dimension(15, 15));
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				currentFrame.dispose();
				currentFrame = null;
				setVisible(false);
				restore.setEnabled(false);
				close.setEnabled(false);
			}
		});
		this.add(close);
		this.setVisible(false);
	}

	public void setEnabled(boolean b) {
		this.setVisible(b);
		restore.setEnabled(b);
		close.setEnabled(b);
	}

	public InnerFrame getCurrentFrame() {
		return currentFrame;
	}

	public void setCurrentFrame(InnerFrame currentFrame) {
		this.currentFrame = currentFrame;
	}
}
