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
import javax.swing.JOptionPane;
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
	
	// this is class data for drawing tables
	TableData tbdata ;


	public mainController() {

		// create data to heap
		tbdata = new TableData();
		
		// init
		tbdata.data = new int[1][1];
		tbdata.data[0][0] = 0;
		tbdata.title = new String[1];
		tbdata.title[0] = "default";
		
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

		tbdata.mv = new mainViewer("SE-Project", jmb, toolbarmenu, subbutton, tbdata.tree,
				tbdata.table, tbdata.rowheader);

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
		tbdata.tree = new JTree();
		tbdata.jc = new JTreeController(tbdata.tree);
		tbdata.tree = tbdata.jc.getJTree();

	}

	public void setJTable() {
		tbdata.mx = new MatrixModel();
		tbdata.table = new JTable(tbdata.mx);
		tbdata.table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbdata.table.getColumnModel().getColumn(0).setPreferredWidth(5);

	}

	public void setRowHeader() {
		tbdata.rowheader = new JList(new RowHeader().lm);
		tbdata.rowheader.setFixedCellHeight(tbdata.table.getRowHeight());
		tbdata.rowheader.setCellRenderer(new RowHeaderRenderer(this.tbdata.table));

	}

	public void setOpenAction() {
		OpenButtonListener openbutton = new OpenButtonListener(this.tbdata);
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
		
		// create listener
		ReDrawButtonListener redrawbutton = new ReDrawButtonListener(tbdata);
		
		// add to button
		redraw.addActionListener(redrawbutton);
	}

	public void reDraw() {
		
		// reset data
		tbdata.mc = new MatrixController();
		tbdata.jc = new JTreeController(tbdata.title, tbdata.tree);

		tbdata.rowheader.setModel(new RowHeader(tbdata.title).lm);
		tbdata.mc.setMatrix(tbdata.data, tbdata.title);
		
		// redraw table
		tbdata.table.setModel(tbdata.mc.mm);
		for (int i1 = 0; i1 < tbdata.title.length; i1++)
			tbdata.table.getColumnModel().getColumn(i1).setPreferredWidth(5);
		
	}
}
