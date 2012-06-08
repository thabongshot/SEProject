import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class MatrixModel extends AbstractTableModel {

	int[][] data;
	String[] title;
	int row;
	int col;

	public MatrixModel() {

		data = new int[1][1];
		data[0][0] = 0;

		this.title = new String[1];
		this.title[0] = "default";

		row = 1;
		col = 1;

	}

	public void setMatrix(int[][] matrix, String[] title) {

		data = matrix;
		this.title = title;
		row = matrix.length;
		col = matrix[0].length;
		

	}

	public int[][] getMatrix() {
		return data;
	}

	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return Integer.toString(col + 1);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return title.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		String[][] smatrix = new String[row][col];

		if (data[rowIndex][columnIndex] == 1)
			smatrix[rowIndex][columnIndex] = "x";
		else
			smatrix[rowIndex][columnIndex] = " ";

		 //System.out.println("rowindex : "+rowIndex+", colindex : "+columnIndex+", value : "+ matrix[rowIndex][columnIndex]);
		return smatrix[rowIndex][columnIndex];
	}

	
	
}
