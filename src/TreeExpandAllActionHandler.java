import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.*;

public class TreeExpandAllActionHandler implements ActionListener {
	
	TableData tbdata;

	public TreeExpandAllActionHandler(TableData tbdata) {
		this.tbdata = tbdata;
	}

	public void actionPerformed(ActionEvent e) {
		expandAll();
		this.tbdata.isExpand = true;
	}

	
	public void expandAll() {
	    TreeNode root = (TreeNode) tbdata.tree.getModel().getRoot();
	    expandAll(tbdata.tree, new TreePath(root));
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
	tree.expandPath(parent);
	}
}