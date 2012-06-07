import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeCollapseActionHandler implements ActionListener{
	JTree tree;

	public  TreeCollapseActionHandler(JTree tree) {
		this.tree = tree;
	}


	public void actionPerformed(ActionEvent e) {
		expandAll();
	}

	public void expandAll() {
	    TreeNode root = (TreeNode) tree.getModel().getRoot();
	    expandAll(tree, new TreePath(root));
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