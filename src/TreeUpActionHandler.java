import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.tree.*;

public class TreeUpActionHandler implements ActionListener {

	// initted Sby the constructor
	JTable table;
	JList rowHeader;
	JTree tree;
	String[] str;

	
	// constructor
	public TreeUpActionHandler(JTable table, JList rowHeader, JTree tree) {
		
		//init
		this.tree = tree;
		this.table = table;
		this.rowHeader = rowHeader;
		
	}

	
	// element up �׼� �޾Ƽ� tree �迭 ���� �ٲ�. 
	// table ���� ���� ���� 
	public void actionPerformed(ActionEvent e) {

		TreePath[] tp = tree.getSelectionPaths();

		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
		for (int i = 0; i < tp.length; i++) {
			
			// reference �� insert �ϸ� �ƿ� �� �����δ� 
			node = (DefaultMutableTreeNode) (tp[i].getLastPathComponent());

			if (tp[i] == null) {
				JOptionPane.showMessageDialog(null, "No node selected",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			
			// ����� index ���� 
			int index = model.getIndexOfChild(model.getRoot(), node);

			if (index != 0) {
				
				// tree ��� ���� 
				model.insertNodeInto(node,
						(DefaultMutableTreeNode) model.getRoot(), index - 1);
				
				// table row ����
				//TableModel tableModel = table.getModel();
				//tableModel.getValueAt(rowIndex, columnIndex);
				//defaultTableModel.moveRow(index, index, index - 1);

				
			} else {
				JOptionPane.showMessageDialog(null,
						"Selected node is first in tree.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			model.reload();

		}

		String[] str = new String[model.getChildCount(model.getRoot())];
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++) {
			str[i] = model.getChild(model.getRoot(), i).toString();
		}
		
		// tree ������� �����
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++)
			System.out.println("tree :: "+str[i]);

		
		//hi.setJtreeData(str);
		//tree.setModel(hi);
	}
}
