import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.tree.*;

public class TreeUpActionHandler implements ActionListener {

	TableData tbdata;

	
	// constructor
	public TreeUpActionHandler(TableData tbdata) {
		this.tbdata = tbdata;
	}

	
	// element up �׼� �޾Ƽ� tree �迭 ���� �ٲ�. 
	// table ���� ���� ���� 
	public void actionPerformed(ActionEvent e) {

		//JOptionPane.showMessageDialog(null, "DEBUG :: tree up");
		TreePath[] tp = tbdata.tree.getSelectionPaths();

		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (tbdata.tree.getModel());
		for (int i = 0; i < tp.length; i++) {
			
			// insert �ϸ� �ƿ� �� �����δ� 
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
				model.insertNodeInto(node, (DefaultMutableTreeNode) model.getRoot(), index - 1);
				
				// table row ����, table title row ���� 
				//JOptionPane.showMessageDialog(null, "DEBUG :: now will change the row");
				changerow(index - 1, index);
				changetitle(index - 1, index);
				//JOptionPane.showMessageDialog(null, "DEBUG :: is changed?");

			} else {
				JOptionPane.showMessageDialog(null,
						"Selected node is first in tree.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			model.reload();

		}

		//String[] str = new String[model.getChildCount(model.getRoot())];
		//for (int i = 0; i < model.getChildCount(model.getRoot()); i++) {
			//str[i] = model.getChild(model.getRoot(), i).toString();
		//}
		
		//tree ������� �����
		//for (int i = 0; i < model.getChildCount(model.getRoot()); i++)
			//System.out.println("tree :: "+str[i]);

	}
	
	
	// row �����ϴ� �Լ� 
	public void changerow(int to, int from){
		int[] tmp = new int[this.tbdata.data[0].length];
		tmp = this.tbdata.data[to];
		this.tbdata.data[to] = this.tbdata.data[from];
		this.tbdata.data[from] = tmp;
	}
	
	// title string �����ϴ� �Լ� 
	public void changetitle(int to, int from){
		String tmp = new String();
		tmp = this.tbdata.title[to];
		this.tbdata.title[to] = this.tbdata.title[from];
		this.tbdata.title[from] = tmp;
	}
}
