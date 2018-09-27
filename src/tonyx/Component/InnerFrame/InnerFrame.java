package tonyx.Component.InnerFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class InnerFrame extends JInternalFrame {
	private boolean isHidden = false;
	private InnerFrameOperatorPane opPane;
	BasicInternalFrameUI oldUi = null;

	public InnerFrame(String title, boolean resizable, boolean closable,
			boolean maximiable, boolean iconifiable) {
		super(title, resizable, closable, maximiable, iconifiable);
		commonOperator();
	}

	public InnerFrame(String title, boolean resizable, boolean closable,
			boolean maximiable) {
		super(title, resizable, closable, maximiable);
		commonOperator();
	}

	public InnerFrame(String title, boolean resizable, boolean closable) {
		super(title, resizable, closable);
		commonOperator();
	}

	public InnerFrame(String title, boolean resizable) {
		super(title, resizable);
		commonOperator();
	}

	public InnerFrame(String title) {
		super(title);
		commonOperator();
	}

	public InnerFrame() {
		super();
		commonOperator();
	}

	public void commonOperator() {
		oldUi = (BasicInternalFrameUI) getUI();

		addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				InnerFrame selectedFrame = (InnerFrame) e.getSource();
				if (selectedFrame.isMaximum()) {
					selectedFrame.hideNorthPanel();
					opPane.setCurrentFrame(selectedFrame);
					opPane.setEnabled(true);
					try {
						selectedFrame.setMaximum(true);
					} catch (PropertyVetoException ex) {
						ex.printStackTrace();
					}

				}
			}
		});
	}

	public void hideNorthPanel() {
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
		isHidden = true;
	}

	public void showNorthPanel() {
		this.setUI(oldUi);
		this.putClientProperty("JInternalFrame.isPalette", Boolean.FALSE);
		isHidden = false;
	}

	@Override
	public void updateUI() {
		super.updateUI();
		if (isHidden) {
			hideNorthPanel();
		}
	}

	public void setOpPane(InnerFrameOperatorPane opPane) {
		this.opPane = opPane;
	}
}