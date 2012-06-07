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

	
	// element up 액션 받아서 tree 배열 순서 바꿈. 
	// table 순서 같이 변경 
	public void actionPerformed(ActionEvent e) {

		TreePath[] tp = tree.getSelectionPaths();

		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (tree.getModel());
		for (int i = 0; i < tp.length; i++) {
			
			// reference 라서 insert 하면 아예 다 움직인다 
			node = (DefaultMutableTreeNode) (tp[i].getLastPathComponent());

			if (tp[i] == null) {
				JOptionPane.showMessageDialog(null, "No node selected",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			
			// 노드의 index 구함 
			int index = model.getIndexOfChild(model.getRoot(), node);

			if (index != 0) {
				
				// tree 노드 변경 
				model.insertNodeInto(node,
						(DefaultMutableTreeNode) model.getRoot(), index - 1);
				
				// table row 변경
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
		
		// tree 순서대로 출력해
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++)
			System.out.println("tree :: "+str[i]);

		
		//hi.setJtreeData(str);
		//tree.setModel(hi);
	}
}
