import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeDownActionHandler implements ActionListener {
	
	// initted by the constructor
	JTable table;
	JList rowHeader;
	JTree tree;


	// constructor
	public TreeDownActionHandler(JTable table, JList rowHeader, JTree tree) {
		
		//init
		this.tree = tree;
		this.table = table;
		this.rowHeader = rowHeader;

	}

	public void actionPerformed(ActionEvent e) {

		TreePath[] tp = tree.getSelectionPaths();

		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());

		for (int i = 0; i < tp.length; i++) {
			node = (DefaultMutableTreeNode) (tp[i].getLastPathComponent());

			if (tp[i] == null) {
				JOptionPane.showMessageDialog(null, "No node selected",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			int index = model.getIndexOfChild(model.getRoot(), node);

			if(i!=(model.getChildCount(model.getRoot()))-1){
				model.insertNodeInto(node,(DefaultMutableTreeNode) model.getRoot(), index + 1); 
			}
			
			 else { 
				 JOptionPane.showMessageDialog(null, "Selected node is last in tree.", "Error", JOptionPane.ERROR_MESSAGE); 
			 }
			 
		
			model.reload();

		}
		String[] str = new String[model.getChildCount(model.getRoot())];
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++) {
			str[i] = model.getChild(model.getRoot(), i).toString();

		}
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++)
			System.out.println(str[i]);
	}

}
