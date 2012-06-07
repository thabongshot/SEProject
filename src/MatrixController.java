import javax.swing.JOptionPane;

public class MatrixController {

	MatrixModel mm;

	public MatrixController() {

		mm = new MatrixModel();
	}

	public void setMatrix(int[][] data, String[] title) {

		mm.setMatrix(data, title);
		//mf.Draw(mm.data, mm.title);
	}

	public int[][] getMatrix() {
		return mm.getMatrix();
	}
}
