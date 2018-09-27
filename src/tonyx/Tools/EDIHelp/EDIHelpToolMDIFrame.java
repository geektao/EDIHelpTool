package tonyx.Tools.EDIHelp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultTreeModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import tonyx.Component.InnerFrame.*;
import tonyx.Component.XmlTree.MapTreeNode;
import tonyx.EDI.Common.Mapper;
import tonyx.Tools.Config.Config;
import tonyx.Tools.EDIHelp.Config.ReadConfig;
import tonyx.Tools.EDIHelp.Dialogs.*;
import tonyx.Tools.EDIHelp.Utilities.*;
import tonyx.Tools.Utilities.Build;
import tonyx.Tools.Utilities.LoadMap;

public class EDIHelpToolMDIFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_LOCATION_X = 150;
	private static final int DEFAULT_LOCATION_Y = 120;
	private static final int DEFAULT_WIDTH = 1000;
	private static final int DEFAULT_HEIGHT = 800;

	private JMenuBar mbar;
	private JMenu menu;
	private JMenu menu_1;
	private JMenuItem mitem;
	final JDesktopPane desktopPane = new JDesktopPane();
	private InnerFrameOperatorPane ifo;
	private Config config = new Config();

	public Config getConfig() {
		return config;
	}

	public EDIHelpToolMDIFrame() {
		setTitle("EDIHelpTool     by TonyX");
		setBounds(DEFAULT_LOCATION_X, DEFAULT_LOCATION_Y, DEFAULT_WIDTH,
				DEFAULT_HEIGHT);

		initMenuBar();
		this.getContentPane().add(desktopPane);

		ReadConfig rc = new ReadConfig();
		rc.setConf(config);
		rc.load();
	}

	private void initMenuBar() {
		mbar = new JMenuBar();
		setJMenuBar(mbar);

		// Menu File
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		mitem = new JMenuItem("\u65B0\u5EFA", KeyEvent.VK_N);
		mitem.addActionListener(new MenuBarListener());
		// KeyStroke ctrlOKeyStroke = KeyStroke.getKeyStroke("control O");
		// mitem.setAccelerator(ctrlOKeyStroke);
		menu.add(mitem);

		mitem = new JMenuItem("\u6253\u5F00", KeyEvent.VK_O);
		KeyStroke ctrlOKeyStroke = KeyStroke.getKeyStroke("control O");
		mitem.setAccelerator(ctrlOKeyStroke);
		menu.add(mitem);
		mitem.addActionListener(new MenuBarListener());
		mitem = new JMenuItem("\u5173\u95ED");
		menu.add(mitem);
		mitem.addActionListener(new MenuBarListener());
		// mitem.addActionListener(MenuBarListener);
		menu.addSeparator();
		mitem = new JMenuItem("\u4FDD\u5B58");
		menu.add(mitem);
		mitem.addActionListener(new MenuBarListener());
		// mitem.addActionListener(MenuBarListener);
		menu.addSeparator();
		mitem = new JMenuItem("\u9000\u51FA");
		menu.add(mitem);
		mitem.addActionListener(new MenuBarListener());
		// mitem.addActionListener(MenuBarListener);
		mbar.add(menu);

		// Menu Edit
		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);

		mitem = new JMenuItem("Undo");
		menu.add(mitem);
		mitem = new JMenuItem("Copy");
		KeyStroke ctrlCKeyStroke = KeyStroke.getKeyStroke("control C");
		mitem.setAccelerator(ctrlCKeyStroke);
		menu.add(mitem);
		mitem = new JMenuItem("Parse");
		KeyStroke ctrlVKeyStroke = KeyStroke.getKeyStroke("control V");
		mitem.setAccelerator(ctrlVKeyStroke);
		menu.add(mitem);

		menu.addSeparator();
		mitem = new JMenuItem("Detials");
		mitem.addActionListener(new MenuBarListener());
		// mitem.setVisible(false);
		// KeyStroke ctrlVKeyStroke = KeyStroke.getKeyStroke("control V");
		// mitem.setAccelerator(ctrlVKeyStroke);
		menu.add(mitem);
		mitem = new JMenuItem("\u9009\u62E9");
		mitem.addActionListener(new MenuBarListener());
		menu.add(mitem);
		mbar.add(menu);
		mbar.add(menu);

		// Options
		menu = new JMenu("Options");
		menu.setMnemonic(KeyEvent.VK_O);
		mitem = new JMenuItem("TempOption");
		mitem.addActionListener(new MenuBarListener());
		menu.add(mitem);
		mitem = new JMenuItem("Setting");
		mitem.addActionListener(new MenuBarListener());
		menu.add(mitem);
		mbar.add(menu);

		// Tools
		menu_1 = new JMenu("Tools");
		menu_1.setMnemonic(KeyEvent.VK_T);
		mitem = new JMenuItem("\u5BFC\u51FAMap\u7ED3\u6784");
		mitem.addActionListener(new MenuBarListener());
		menu_1.add(mitem);
		mbar.add(menu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u751F\u6210Spec");
		mntmNewMenuItem.addActionListener(new MenuBarListener());
		menu_1.add(mntmNewMenuItem);

		JMenuItem mntmrules = new JMenuItem("\u5BFC\u51FARules");
		menu_1.add(mntmrules);

		ifo = new InnerFrameOperatorPane();
		mbar.add(ifo);
	}

	class MenuBarListener extends JFrame implements ActionListener {
		private static final long serialVersionUID = 1L;
		private JFileChooser chooser;
		private FileFilter filter;

		public MenuBarListener() {
			chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			String extj[] = { "xml", "mxl" };
			filter = new FileNameExtensionFilter("XML", extj);
			chooser.setFileFilter(filter);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int retval;
			String selection = e.getActionCommand();
			// System.out.println(selection);

			if (selection.equals("New")) {
				EDIHelpToolInnerFrame ehtif = new EDIHelpToolInnerFrame("新建");
				ehtif.setVisible(true);
				ehtif.setOpPane(ifo);
				desktopPane.add(ehtif);
				desktopPane.setSelectedFrame(ehtif);
				ehtif.toFront();
			} else if (selection.equals("打开")) {
				retval = chooser.showOpenDialog(this);
				if (retval == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();

					LoadMap lm = new LoadMap(file);
					lm.setConfig(config);

					EDIHelpToolInnerFrame ehtif = new EDIHelpToolInnerFrame(
							file.getPath());
					ehtif.setFileName(file.getAbsolutePath());
					lm.setMapper(ehtif.getMapper());
					lm.load();
					ehtif.showTree();

					ehtif.setOpPane(ifo);
					ehtif.setVisible(true);
					desktopPane.add(ehtif);
					desktopPane.setSelectedFrame(ehtif);
					ehtif.toFront();
				}
			} else if (selection.equals("保存")) {
				EDIHelpToolInnerFrame currentframe = (EDIHelpToolInnerFrame) desktopPane
						.getSelectedFrame();
				if (currentframe != null) {
					File file = new File(currentframe.getFileName());
					chooser.setSelectedFile(file);
					retval = chooser.showSaveDialog(this);
					if (retval == JFileChooser.APPROVE_OPTION) {
						file = chooser.getSelectedFile();
						String fileName = file.getName();
						int index = fileName.indexOf(".");
						if (index != -1) {
							fileName = fileName.substring(0, index);
						}
						Build.buildXML(currentframe.getMapper(), config,
								file.getParent() + "\\" + fileName);
					}

				}

			} else if (selection.equals("关闭")) {
				EDIHelpToolInnerFrame currentframe = (EDIHelpToolInnerFrame) desktopPane
						.getSelectedFrame();
				if (currentframe != null) {
					currentframe.dispose();
					ifo.setEnabled(false);
				}
			} else if (selection.equals("退出")) {
				System.exit(0);
			} else if (selection.equals("Detials")) {

			} else if (selection.equals("选择")) {
				EDIHelpToolInnerFrame currentframe = (EDIHelpToolInnerFrame) desktopPane
						.getSelectedFrame();
				if (currentframe != null) {
					Mapper map = currentframe.getMapper();
					if (map != null) {
						JTree tree = currentframe.getOutputtree();
						MapTreeNode node = currentframe.getOutputroot();
						MapTreeNodeOperate.setAllNodeChekcBoxVisible(node);
						((DefaultTreeModel) tree.getModel())
								.nodeStructureChanged(node);
					}
				}
			} else if (selection.equals("导出Rules")) {
				EDIHelpToolInnerFrame currentframe = (EDIHelpToolInnerFrame) desktopPane
						.getSelectedFrame();

				ExportExplicitRule ee = new ExportExplicitRule();
				if (currentframe != null) {
					ee.searchRule((MapTreeNode) currentframe.getInputroot()
							.getChildAt(0));
					ee.addRuleToXLS();
				}
			} else if (selection.equals("TempOption")) {
				EDIHelpToolInnerFrame currentframe = (EDIHelpToolInnerFrame) desktopPane
						.getSelectedFrame();
				if (currentframe != null) {
					TempOptionDialog toptiondlg = new TempOptionDialog();
					toptiondlg.setVisible(true);
				}
			} else if (selection.equals("导出Map结构")) {
				EDIHelpToolInnerFrame currentframe = (EDIHelpToolInnerFrame) desktopPane
						.getSelectedFrame();

				if (currentframe != null) {
					ExportStructDialog erd = new ExportStructDialog(
							currentframe.getInputtree(),
							currentframe.getOutputtree());
					erd.setVisible(true);
					// ExportMapStruct ems = new
					// ExportMapStruct(currentframe.getOutputtree().getTreeType(),currentframe.getOutputroot());
					// ExportMapStruct ems = new
					// ExportMapStruct(currentframe.getInputtree().getTreeType(),currentframe.getInputroot());
				}
			} else if (selection.equals("生成Spec")) {
				GenerateSpec gs = new GenerateSpec();
				HSSFWorkbook wb = new HSSFWorkbook();
				gs.createStyles(wb);
				gs.createStyles(wb);
				gs.RevisionHistorySheet(wb);
				gs.mappingSheet(wb);
				gs.issueLogSheet(wb);

				try {
					FileOutputStream fileOut = new FileOutputStream(
							"spec.xls");
					wb.write(fileOut);
					fileOut.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			else if (selection.equals("Setting")) {
				SettingDialog setDlg = new SettingDialog();
				setDlg.setVisible(true);
			}
		}
	}
}