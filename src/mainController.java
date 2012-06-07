import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.InputEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.KeyStroke;

public class mainController {
	JMenuBar jmb;
	JMenu filemenu;
	JMenuItem open;
	KeyStroke ks;
	JMenuItem newfile;
	JMenuItem load;
	JMenuItem save;
	KeyStroke ks1;
	KeyStroke ks2;
	JMenuItem saveAs;
	JMenuItem exit;
	JMenu viewmenu;
	JMenuItem redr;
	JMenuItem showlabel;
	JMenu helpmenu;
	JMenuItem about;
	JToolBar toolbarmenu;
	JButton opendsm;
	JButton redraw;
	JButton newclsx;
	JButton openclsx;
	JButton saveclsx;
	JButton saveclsxas;
	JToolBar subbutton;
	JButton expand;
	JButton collapse;
	JButton group;
	JButton ungroup;
	JButton up;
	JButton down;
	JButton delete;
	JTree tree;
	JTreeController jc;
	MatrixModel mx;
	JTable table;
	JList rowheader;
	mainViewer mv;
	int[][] data;
	String[] title;
	MatrixController mc;

	public mainController() {

		data = new int[1][1];
		data[0][0] = 0;
		title = new String[1];
		title[0] = "default";
		// MENU ∫Œ¬¯
		jmb = new JMenuBar();
		jmb.add(this.setFileMenu());
		jmb.add(this.setViewMenu());
		jmb.add(this.setHelpMenu());
		// ToolBar ∫Œ¬¯
		this.setToolBarMenu();
		// subButton ∫Œ¬¯
		this.setSubToolBar();
		// JTree
		this.setJTree();
		// JTable
		this.setJTable();
		// rowheader
		this.setRowHeader();
		this.setOpenAction();
		this.setSaveAction();
		this.setAboutAction();
		this.setExitAction();
		this.setReDrawAction();

		mv = new mainViewer("SE-Project", jmb, toolbarmenu, subbutton, tree,
				table, rowheader);

		/*
		 * // xml->JTree XMLtoJTreeController xjc = new XMLtoJTreeController();
		 * xjc.documentRead("moka_ACDC.clsx"); tree = xjc.getJTree();
		 */

		// actionlistener »£√‚

	}

	public JMenu setFileMenu() {
		filemenu = new JMenu("File");
		filemenu.setMnemonic('F');

		open = new JMenuItem("Open DSM");
		open.setMnemonic('O');
		// ¥‹√‡≈∞
		ks = KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK);
		open.setAccelerator(ks);
		filemenu.add(open);

		newfile = new JMenuItem("New Clustering");
		newfile.setMnemonic('N');
		filemenu.add(newfile);

		load = new JMenuItem("Load Clustering");
		load.setMnemonic('L');
		ks1 = KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK
				^ InputEvent.ALT_MASK);
		load.setAccelerator(ks1);
		filemenu.add(load);

		save = new JMenuItem("Save Clustering");
		save.setMnemonic('S');
		ks2 = KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK);
		save.setAccelerator(ks2);
		filemenu.add(save);

		saveAs = new JMenuItem("Save Clustering As");
		saveAs.setMnemonic('a');
		filemenu.add(saveAs);

		exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		filemenu.add(exit);

		return filemenu;
	}

	public JMenu setViewMenu() {
		viewmenu = new JMenu("View");
		viewmenu.setMnemonic('V');

		redr = new JMenuItem("Redraw");
		redr.setMnemonic('R');
		viewmenu.add(redr);

		showlabel = new JMenuItem("Show Row Labels");
		showlabel.setMnemonic('L');
		viewmenu.add(showlabel);

		return viewmenu;
	}

	public JMenu setHelpMenu() {
		helpmenu = new JMenu("Help");
		helpmenu.setMnemonic('H');

		about = new JMenuItem("About..");
		about.setMnemonic('A');
		helpmenu.add(about);

		return helpmenu;
	}

	public void setToolBarMenu() {
		toolbarmenu = new JToolBar("ToolBar", JToolBar.HORIZONTAL);

		opendsm = new JButton(new ImageIcon("open-dsm.png", "open-dsm"));
		toolbarmenu.add(opendsm);

		redraw = new JButton(new ImageIcon("redraw.png", "redraw"));
		toolbarmenu.add(redraw);

		newclsx = new JButton(new ImageIcon("new-clsx.png", "new-clsx"));
		toolbarmenu.add(newclsx);

		openclsx = new JButton(new ImageIcon("open-clsx.png", "open-clsx"));
		toolbarmenu.add(openclsx);

		saveclsx = new JButton(new ImageIcon("save-clsx.png", "save-clsx"));
		toolbarmenu.add(saveclsx);

		saveclsxas = new JButton(new ImageIcon("save-clsx-as.png",
				"save-clsx-as"));
		toolbarmenu.add(saveclsxas);

	}

	public void setSubToolBar() {
		subbutton = new JToolBar("subButton", JToolBar.HORIZONTAL);

		expand = new JButton(new ImageIcon("expand.png", "expend"));
		subbutton.add(expand);

		collapse = new JButton(new ImageIcon("collapse.png", "collapse"));
		subbutton.add(collapse);

		group = new JButton(new ImageIcon("group.png", "group"));
		subbutton.add(group);

		ungroup = new JButton(new ImageIcon("ungroup.png", "ungroup"));
		subbutton.add(ungroup);

		up = new JButton(new ImageIcon("up.png", "up"));
		subbutton.add(up);

		down = new JButton(new ImageIcon("down.png", "down"));
		subbutton.add(down);

		delete = new JButton(new ImageIcon("delete.png", "delete"));
		subbutton.add(delete);

	}

	public void setJTree() {
		tree = new JTree();
		jc = new JTreeController(tree);
		tree = jc.getJTree();

	}

	public void setJTable() {
		mx = new MatrixModel();
		table = new JTable(mx);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);

	}

	public void setRowHeader() {
		rowheader = new JList(new RowHeader().lm);
		rowheader.setFixedCellHeight(table.getRowHeight());
		rowheader.setCellRenderer(new RowHeaderRenderer(this.table));

	}

	public void setOpenAction() {
		OpenButtonListener openbutton = new OpenButtonListener(data, title);
		open.addActionListener(openbutton);
		opendsm.addActionListener(openbutton);
		LoadButtonListener loadbutton = new LoadButtonListener();
		load.addActionListener(loadbutton);
		openclsx.addActionListener(loadbutton);
	}

	public void setSaveAction() {
		SaveButtonListener savebutton = new SaveButtonListener();
		save.addActionListener(savebutton);
		saveclsx.addActionListener(savebutton);

		SaveAsButtonListener saveAsbutton = new SaveAsButtonListener();
		saveAs.addActionListener(saveAsbutton);
		saveclsxas.addActionListener(saveAsbutton);
	}

	public void setAboutAction() {
		AboutButtonListener aboutbutton = new AboutButtonListener();
		about.addActionListener(aboutbutton);
	}

	public void setExitAction() {
		ExitButtonListener exitbutton = new ExitButtonListener();
		exit.addActionListener(exitbutton);
	}

	public void setReDrawAction() {
		ReDrawButtonListener redrawbuttion = new ReDrawButtonListener();
		redraw.addActionListener(redrawbuttion);
	}

	public void reDraw() {
		mc = new MatrixController();
		jc = new JTreeController(title, tree);

		rowheader.setModel(new RowHeader(title).lm);
		mc.setMatrix(data, title);
		table.setModel(mc.mm);
		for (int i1 = 0; i1 < title.length; i1++)
			table.getColumnModel().getColumn(i1).setPreferredWidth(5);
	}
}
