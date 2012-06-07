import java.awt.BorderLayout;

import java.awt.Dimension;

import java.awt.event.*;

import javax.swing.*;

public class mainViewer extends JFrame {
	JSplitPane mjsp;
	JSplitPane sjsp;
	JScrollPane tableSP;
	JScrollPane treeSP;

	public mainViewer(String labelName, JMenuBar jmb, JToolBar toolbarmenu,
			JToolBar subbutton, JTree tree, JTable table, JList rowHeader ) {
		super(labelName);

		setLayout(new BorderLayout());

		setJMenuBar(jmb);

		getContentPane().add(toolbarmenu, BorderLayout.NORTH);

		mjsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		sjsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		// JTable

		tableSP = new JScrollPane(table);
		tableSP.setRowHeaderView(rowHeader);

		treeSP = new JScrollPane(tree);

		/*
		 * xml->JTree XMLtoJTreeController xjc = new XMLtoJTreeController();
		 * xjc.documentRead("moka_ACDC.clsx"); tree = xjc.getJTree();
		 * 
		 * // xml->JTree
		 */

		// ºÎÂø
		sjsp.setTopComponent(subbutton);
		sjsp.setBottomComponent(treeSP);
		mjsp.setLeftComponent(sjsp);

		mjsp.setRightComponent(tableSP);

		getContentPane().add(mjsp, BorderLayout.CENTER);

		setResizable(true);
		setPreferredSize(new Dimension(1000, 800));
		setLocation(400, 100);
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	
}
