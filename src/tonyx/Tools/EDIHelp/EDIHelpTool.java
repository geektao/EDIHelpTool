package tonyx.Tools.EDIHelp;
import java.awt.EventQueue;

import javax.swing.JFrame;


public class EDIHelpTool {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new EDIHelpToolMDIFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
