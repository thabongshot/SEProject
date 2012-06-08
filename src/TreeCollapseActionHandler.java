import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeCollapseActionHandler implements ActionListener{
	
	TableData tbdata;

	public TreeCollapseActionHandler(TableData tbdata) {
		this.tbdata = tbdata;
	}

	
	// collapse action
	public void actionPerformed(ActionEvent e) {
		expandAll();
		
		// draw blank table
		this.tbdata.mc = new MatrixController();
		this.tbdata.rowheader.setModel(new RowHeader(tbdata.mc.mm.title).lm);
		this.tbdata.table.setModel(tbdata.mc.mm);
		this.tbdata.table.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		this.tbdata.isExpand = false;
			
		//tbdata.rowheader.setModel(new RowHeader(tbdata.title).lm);
		//mc.setMatrix(tbdata.data, tbdata.title);
	}

	public void expandAll() {
	    TreeNode root = (TreeNode) this.tbdata.tree.getModel().getRoot();
	    expandAll(this.tbdata.tree, new TreePath(root));
	}
	private void expandAll(JTree tree, TreePath parent) {
	    TreeNode node = (TreeNode) parent.getLastPathComponent();
	    if (node.getChildCount() >= 0) {
	      for (Enumeration e = node.children(); e.hasMoreElements();) {
	        TreeNode n = (TreeNode) e.nextElement();
	        TreePath path = parent.pathByAddingChild(n);
	        expandAll(tree, path);
	      }
	    }
	tree.collapsePath(parent);
	}
}