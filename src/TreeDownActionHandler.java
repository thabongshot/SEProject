import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


public class TreeDownActionHandler implements ActionListener {
	

	TableData tbdata;

	
	// constructor
	public TreeDownActionHandler(TableData tbdata) {
		this.tbdata = tbdata;
	}


	// element up 액션 받아서 tree 배열 순서 바꿈. 
	// table 순서 같이 변경 
	public void actionPerformed(ActionEvent e) {

		TreePath[] tp = tbdata.tree.getSelectionPaths();

		DefaultMutableTreeNode node;
		DefaultTreeModel model = (DefaultTreeModel) (tbdata.tree.getModel());
		for (int i = 0; i < tp.length; i++) {
			
			// insert 하면 아예 다 움직인다 
			node = (DefaultMutableTreeNode) (tp[i].getLastPathComponent());

			if (tp[i] == null) {
				JOptionPane.showMessageDialog(null, "No node selected",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			
			// 노드의 index 구함 
			int index = model.getIndexOfChild(model.getRoot(), node);

			// ?? 
			if(i!=(model.getChildCount(model.getRoot()))-1){
				
				// tree 노드 변경 
				model.insertNodeInto(node,(DefaultMutableTreeNode) model.getRoot(), index + 1);
				
				// table row 변경, table title row 변경 
				changerow(index + 1, index);
				changetitle(index + 1, index);
				
				// tbdata 에 반영한다
				//MatrixController mc = new MatrixController();
				//tbdata.rowheader.setModel(new RowHeader(tbdata.title).lm);
				//mc.setMatrix(tbdata.data, tbdata.title);
				
			}
			
			 else { 
				 JOptionPane.showMessageDialog(null, "Selected node is last in tree.", "Error", JOptionPane.ERROR_MESSAGE); 
			 }
			 
		
			model.reload();

		}
		
		/*
		String[] str = new String[model.getChildCount(model.getRoot())];
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++) {
			str[i] = model.getChild(model.getRoot(), i).toString();

		}
		for (int i = 0; i < model.getChildCount(model.getRoot()); i++)
			System.out.println(str[i]);
		*/
	}
	
	
	// row 변경하는 함수 
	public void changerow(int to, int from){
		int[] tmp = new int[this.tbdata.data[0].length];
		tmp = this.tbdata.data[to];
		this.tbdata.data[to] = this.tbdata.data[from];
		this.tbdata.data[from] = tmp;
	}
	
	// title string 변경하는 함수 
	public void changetitle(int to, int from){
		String tmp = new String();
		tmp = this.tbdata.title[to];
		this.tbdata.title[to] = this.tbdata.title[from];
		this.tbdata.title[from] = tmp;
	}
	
}
