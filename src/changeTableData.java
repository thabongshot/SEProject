import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.table.*;


// 일단은 보류 

/*

public class changeTableData implements TableModelListener{
	
	OpenButtonListener obl = new OpenButtonListener();
	
	public changeTableData() {
		obl.table.getModel().addTableModelListener(this);
	}
	
	public void tableChanged(TableModelEvent e){
		int row = e.getFirstRow();
		int col = e.getColumn();
		TableModel model = (TableModel)e.getSource();
		String columnName = model.getColumnName(col);
		Object data = model.getValueAt(row, col);
		
		//뭔가함........
		
		JOptionPane.showMessageDialog(null, "CHanged");
	}

}

*/