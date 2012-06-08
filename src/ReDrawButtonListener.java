import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ReDrawButtonListener implements ActionListener {	
	
	
	TableData tbdata;
	
	public ReDrawButtonListener(TableData tbdata) {
		this.tbdata = tbdata;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(null, "DEBUG :: Performed re-draw button action");
		
		// ==== re make mode and table ==> moved to tree action
		//tbdata.rowheader.setModel(new RowHeader(tbdata.title).lm);
		//mc.setMatrix(tbdata.data, tbdata.title);
		
		// ==== moved to open button listener
		//JTreeController jc = new JTreeController(tbdata.title, tbdata.tree);

		if( this.tbdata.isExpand ){
			// redraw table from tbdata
			MatrixController mc = new MatrixController();
			mc.setMatrix(this.tbdata.data, this.tbdata.title);
			this.tbdata.rowheader.setModel(new RowHeader(this.tbdata.title).lm);
			this.tbdata.table.setModel(mc.mm);
		}
		
		for (int i1 = 0; i1 < tbdata.title.length; i1++)
			this.tbdata.table.getColumnModel().getColumn(i1).setPreferredWidth(5);

		// for debug
		//for(int i=0; i<tbdata.title.length; i++)
		//	System.out.println("DEBUG :: title :: " + tbdata.title[i]);
	}
}

