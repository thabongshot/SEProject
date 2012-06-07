import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;

public class ReDrawButtonListener implements ActionListener {	
	
	
	TableData tbdata;
	
	public ReDrawButtonListener(TableData tbdata) {
		this.tbdata = tbdata;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "DEBUG :: Performed re-draw button action");
		
		// reset data
		MatrixController mc = new MatrixController();
		JTreeController jc = new JTreeController(tbdata.title, tbdata.tree);
		tbdata.rowheader.setModel(new RowHeader(tbdata.title).lm);
		mc.setMatrix(tbdata.data, tbdata.title);
		
		// redraw table
		tbdata.table.setModel(mc.mm);
		for (int i1 = 0; i1 < tbdata.title.length; i1++)
			tbdata.table.getColumnModel().getColumn(i1).setPreferredWidth(5);

		for(int i=0; i<tbdata.title.length; i++)
			System.out.println("DEBUG :: title :: " + tbdata.title[i]);
	}
}

