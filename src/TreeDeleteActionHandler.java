import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.*;

public class TreeDeleteActionHandler implements ActionListener {

	// initted by the constructor
	JTable table;
	JList rowHeader;
	JTree tree;

	
	// constructor
	public TreeDeleteActionHandler(JTable table, JList rowHeader, JTree tree) {
		
		//init
		this.tree = tree;
		this.table = table;
		this.rowHeader = rowHeader;

	}
		

	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());

		TreePath[] paths = tree.getSelectionPaths();

		
		for (int i = 0; i < paths.length; i++) {
			node = (DefaultMutableTreeNode) (paths[i].getLastPathComponent());
			model.removeNodeFromParent(node);
		}
		
		String[] str = new String[model.getChildCount(model.getRoot())];
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++) {
			str[i] = model.getChild(model.getRoot(), i).toString();

		}
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++)
			System.out.println(str[i]);
		
	}
	
	
}
