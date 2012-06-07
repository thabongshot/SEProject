import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class DsmViewer extends JFrame{
	
	public JPanel panel;
	public JTable table;

	public void DsmViewer(int num, String[][] r) {

		String[] column = new String[num]; 
		String[][] row = new String[num][num];
		JScrollPane scroll;
		Vector<String> vcolumn = new Vector<String>();
		Vector<String> vrow = new Vector<String>();

		int i = 0;
		int j = 0;
	
		for (i = 0; i < num; i++) {
			for (j = 0; j < num; j++) {
				row[i][j] = r[i][j];
			}
		}
		/*
		vcolumn.addElement("  ");
		vrow = new Vector<String>();
		
		model = new DefaultTableModel(2, 2);
		infoTable = new JTable(model);

		for (i = 0; i < 10; i++) {
			for (j = 0; j < 10; j++) {
				vrow.addElement("row" + i);
				vcolumn.addElement("col" + j);
			
				model.addRow(vrow);
				model.addColumn(vcolumn);
			}
		}*/
		
		for(i=0; i<num; i++){
			for(j=0; j<num; j++){
				vrow.addElement(r[i][j]);
				vcolumn.addElement(r[i][0]);			
			}
		}
		//JOptionPane.showMessageDialog(null, vrow);
		//JOptionPane.showMessageDialog(null, vcolumn);
		
		DefaultTableModel model = new DefaultTableModel(10,10);
		table.setModel(model);
		panel.add(table);
		
		//getContentPane().add(panel);

		/*panel = new JPanel();
		panel.setLayout(new BorderLayout());
		scroll = new JScrollPane(infoTable);
		panel.add(scroll, BorderLayout.CENTER);
		//panel.repaint();
		 */
	}
	
}